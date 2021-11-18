package com.akshay.learning.threading;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static Worker getWorker(List<String> outputScraper, CountDownLatch countDownLatch){
        return new Worker(outputScraper, countDownLatch);
    }

    public static SmartWorker getSmartWorker(List<String> outputScraper, CountDownLatch readyThreadCounter, CountDownLatch callingThreadBlocker, CountDownLatch completedThreadCounter){
        return new SmartWorker(outputScraper, readyThreadCounter, callingThreadBlocker, completedThreadCounter);
    }
}

class Worker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            doSomeWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }

    private void doSomeWork() throws InterruptedException {
        Thread.sleep(2000);
    }
}

/*
*
* Usecase where  thousands of threads started instead of five, it’s likely that many of the earlier ones will have
* finished processing before we have even called start() on the later ones. This could make it difficult to try and reproduce a concurrency problem
* */

class SmartWorker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch readyThreadCounter;
    private CountDownLatch callingThreadBlocker;
    private CountDownLatch completedThreadCounter;

    public SmartWorker(List<String> outputScraper, CountDownLatch readyThreadCounter, CountDownLatch callingThreadBlocker, CountDownLatch completedThreadCounter) {
        this.outputScraper = outputScraper;
        this.readyThreadCounter = readyThreadCounter;
        this.callingThreadBlocker = callingThreadBlocker;
        this.completedThreadCounter = completedThreadCounter;
    }

    @Override
    public void run() {
        readyThreadCounter.countDown();
        try {
            callingThreadBlocker.await();
            doSomeWork();
            outputScraper.add("Counted down");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            completedThreadCounter.countDown();
        }
    }

    private void doSomeWork() throws InterruptedException {
        Thread.sleep(2000);
    }
}