package com.mediway.hos.srm.business.center.utils;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockUtil {
    private Map<String,EntityLockInfo> IConcurrentHashMap=new HashMap<String,EntityLockInfo>();
    private List<EntityLockInfo> keyInfos=new ArrayList<EntityLockInfo>();
    private  Long locMax=3000L;
    private  Long nowToDis=5000L;
    private  LockUtil(long locMax,Long nowToDis){
        this.locMax=locMax;
        this.nowToDis=nowToDis;
    }
    protected static  LockUtil init(Long locMax,Long nowToDis){
        return  new LockUtil(locMax,nowToDis);
    }
    public  synchronized  void lock(String key){
        EntityLockInfo lockInfo=null;

        if(keyInfos.size()>=locMax){
            int indexHaf=Math.round(keyInfos.size()/2);
            EntityLockInfo halEntityLockInfo=keyInfos.get(indexHaf);
            long halTime=halEntityLockInfo.getTimestamp();
            if(new Date().getTime()-halTime>=nowToDis){
                System.out.println("清除一半锁");
                List<EntityLockInfo> dropKeyInfos=keyInfos.subList(0,indexHaf);
                if(!dropKeyInfos.isEmpty()){
                    List<EntityLockInfo> newKeyInfos=keyInfos.subList(indexHaf,keyInfos.size());
                    dropKeyInfos.forEach(item->{
                        boolean itemLocked=item.isLocked();
                        if(!itemLocked){
                            String itemKey=item.getKey();
                            IConcurrentHashMap.remove(itemKey);
                        }else{
                            unLock(item.getKey());
                        }
                    });
                    keyInfos=newKeyInfos;
                }

            }
        }

        if(IConcurrentHashMap.containsKey(key)){

            lockInfo=IConcurrentHashMap.get(key);
        }else{
            //不存在时创建新的锁
            ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
            Lock writeLoc=readWriteLock.writeLock();
            lockInfo=new EntityLockInfo();
            lockInfo.setKey(key);
            lockInfo.setLock(writeLoc);
            lockInfo.setTimestamp((new Date().getTime()));
            keyInfos.add(lockInfo);

        }
        lockInfo.lock();
        IConcurrentHashMap.put(key,lockInfo);

    }
    public  void  unLock(String key){
        EntityLockInfo lockInfo=null;
        if(IConcurrentHashMap.containsKey(key)){
            lockInfo=IConcurrentHashMap.get(key);
        }else{
            return;
        }
        lockInfo.unLock();
        IConcurrentHashMap.remove(key);

    }
    public synchronized  boolean beLocked(String key){
        EntityLockInfo lockInfo=null;
        if(IConcurrentHashMap.containsKey(key)){
            lockInfo=IConcurrentHashMap.get(key);
            return lockInfo.isLocked();
        }else{
            return false;
        }
    }
}
