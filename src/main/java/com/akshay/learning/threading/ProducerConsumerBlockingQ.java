package com.akshay.learning.threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQ {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try {
                int value = 0;
                while (true) {
                    buffer.put(value);
                    System.out.println("Produced " + value);
                    value++;
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int value = buffer.take();
                    System.out.println("Consume " + value);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
