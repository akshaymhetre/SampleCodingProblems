package com.akshay.learning.threading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class LockExamples {

}
// ReentrantLock Example
class SharedObjectReentrantLock {
    ReentrantLock lock = new ReentrantLock();
    int counter = 0;

    public void perform() {
        lock.lock();
        try {
            // Critical section here
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public void performTryLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        boolean isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);

        if(isLockAcquired) {
            try {
                //Critical section here
            } finally {
                lock.unlock();
            }
        }
    }
}

/*
*
* Let's see rules for acquiring the ReadLock or WriteLock by a thread:

Read Lock – if no thread acquired the write lock or requested for it then multiple threads can acquire the read lock
Write Lock – if no threads are reading or writing then only one thread can acquire the write lock
* */

class SynchronizedHashMapWithReadWriteLock {
    Map<String,String> syncHashMap = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void put(String key, String value) {
        try {
            writeLock.lock();
            syncHashMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }


    public String get(String key){
        try {
            readLock.lock();
            return syncHashMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public String remove(String key){
        try {
            writeLock.lock();
            return syncHashMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }



    public boolean containsKey(String key) {
        try {
            readLock.lock();
            return syncHashMap.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }
}
/*
* StampedLock is introduced in Java 8. It also supports both read and write locks.
* However, lock acquisition methods return a stamp that is used to release a lock or to check if the lock is still valid:
* */
class StampedLockDemo {
    Map<String,String> map = new HashMap<>();
    private StampedLock lock = new StampedLock();

    public void put(String key, String value){
        long stamp = lock.writeLock();
        try {
            map.put(key, value);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public String get(String key) throws InterruptedException {
        long stamp = lock.readLock();
        try {
            return map.get(key);
        } finally {
            lock.unlockRead(stamp);
        }
    }

    /*
    * Another feature provided by StampedLock is optimistic locking.
    * Most of the time read operations don't need to wait for write operation completion and as a result of this,
    * the full-fledged read lock isn't required
    * */
    public String readWithOptimisticLock(String key) {
        // Get a stamp
        long stamp = lock.tryOptimisticRead();
        // Read a value
        String value = map.get(key);
        // Has the stamp changed? try again or issue a blocking read
        if(!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                return map.get(key);
            } finally {
                lock.unlock(stamp);
            }
        }
        return value;
    }
}
