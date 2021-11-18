package com.akshay.learning.threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CyclicBarrierExample {
    public static Party getParty(int duration, CyclicBarrier barrier, List<String> outputScraper) {
        return new Party(duration, barrier, outputScraper);
    }

    public static void main(String[] args) throws InterruptedException, TimeoutException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        List<Thread> parties = Stream
                .generate(() -> new Thread(CyclicBarrierExample.getParty(1000, cyclicBarrier, outputScraper)))
                .limit(5)
                .collect(Collectors.toList());

        parties.forEach(Thread::start);

        cyclicBarrier.await(10, TimeUnit.SECONDS);
        outputScraper.add("Completed");
        System.out.println(outputScraper);
    }
}

class Party implements Runnable {
    private int duration;
    private CyclicBarrier barrier;
    private List<String> outputScraper;

    public Party(int duration, CyclicBarrier barrier, List<String> outputScraper) {
        this.outputScraper = outputScraper;
        this.duration = duration;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            outputScraper.add("Waiting");
            barrier.await();
            outputScraper.add("Started");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
