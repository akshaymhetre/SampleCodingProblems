package com.akshay.learning.threading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class LoginQueueUsingSemaphore extends ReentrantLock {

    private Semaphore semaphore;

    public LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }
}