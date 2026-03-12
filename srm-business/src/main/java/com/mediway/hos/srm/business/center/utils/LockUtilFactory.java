package com.mediway.hos.srm.business.center.utils;

import java.util.HashMap;
import java.util.Map;

public class LockUtilFactory {
    private  static Map<String,LockUtil> lockUtilMap=new HashMap<String,LockUtil>();
    private  static LockUtil lockUtil=LockUtil.init(1000L, 24 * 60 * 60 * 1000L);
    public static LockUtil getLockUtil(String lockname,long lockMax,long nowtoDis){
        LockUtil mylockUtil=null;
        try{
            lockUtil.lock(lockname);
            if(lockUtilMap.containsKey(lockname)){
                lockUtilMap.get(lockname);
            }
            mylockUtil=LockUtil.init(lockMax,nowtoDis);
            lockUtilMap.put(lockname,mylockUtil);

        }finally {
            lockUtil.unLock(lockname);
        }
        return mylockUtil;
    }

}
