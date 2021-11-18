package com.akshay.learning.threading;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CyclicBarrierExampleTest {
    @Test
    public void testCyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        List<Thread> parties = Stream
                .generate(() -> new Thread(CyclicBarrierExample.getParty(1000, cyclicBarrier, outputScraper)))
                .limit(5)
                .collect(Collectors.toList());

        parties.forEach(Thread::start);

        outputScraper.add("Completed");

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

}