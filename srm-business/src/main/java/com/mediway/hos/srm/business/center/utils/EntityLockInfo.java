package com.mediway.hos.srm.business.center.utils;

import java.util.concurrent.locks.Lock;

public class EntityLockInfo {
    private  Lock lock;
    private  String key;
    private  long timestamp;
    private  boolean locked;

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public  void unLock(){
        this.lock.unlock();
        this.locked=false;
    }
    public  void lock(){
        this.lock.lock();
        this.locked=true;
    }
}
