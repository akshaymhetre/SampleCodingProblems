package com.akshay.learning.threading;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CountDownLatchExampleTest {

    @Test
    public void whenParallelProcessing_thenMainThreadWillBlockUntilCompletion() throws InterruptedException {
        List<String> outputScraper = new CopyOnWriteArrayList<>();
        // List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());

        CountDownLatch countDownLatch = new CountDownLatch(5);

        List<Thread> threads = Stream
                .generate(() -> new Thread(CountDownLatchExample.getWorker(outputScraper, countDownLatch)))
                .limit(5)
                .collect(Collectors.toList());

        threads.forEach(Thread::start);
        countDownLatch.await();
        outputScraper.add("Latch released");

        Assert.assertArrayEquals(
                outputScraper.toArray(),
                new String[]{
                        "Counted down",
                        "Counted down",
                        "Counted down",
                        "Counted down",
                        "Counted down",
                        "Latch released"
                }
         );

    }

    @Test
    public void whenDoingLotsOfThreadsInParallel_thenStartThemAtTheSameTime()
            throws InterruptedException {

        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch readyThreadCounter = new CountDownLatch(5);
        CountDownLatch callingThreadBlocker = new CountDownLatch(1);
        CountDownLatch completedThreadCounter = new CountDownLatch(5);
        List<Thread> workers = Stream
                .generate(() -> new Thread(CountDownLatchExample.getSmartWorker(
                        outputScraper, readyThreadCounter, callingThreadBlocker, completedThreadCounter)))
                .limit(5)
                .collect(Collectors.toList());

        workers.forEach(Thread::start);
        readyThreadCounter.await();
        outputScraper.add("Workers ready");
        callingThreadBlocker.countDown();
        completedThreadCounter.await();
        outputScraper.add("Workers complete");

        Assert.assertArrayEquals(
                outputScraper.toArray(),
                new String[]{
                        "Workers ready",
                        "Counted down",
                        "Counted down",
                        "Counted down",
                        "Counted down",
                        "Counted down",
                        "Workers complete"
                }
        );

    }
}

