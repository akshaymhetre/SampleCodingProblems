package com.akshay.learning.threading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
    public static void main(String[] args) throws InterruptedException {
        Buffer<Integer> buffer = new Buffer<>(5);

        Thread producer = new Thread(() -> {
            try {
                int value = 0;
                while (true) {
                    buffer.add(value);
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
                    int value = buffer.poll();
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

class Buffer<T> {
    private final Queue<T> list;
    private final int size;

    public Buffer(int size) {
        this.size = size;
        list = new LinkedList<>();
    }
    public void add(T value) throws InterruptedException {
        synchronized (this) {
            while (list.size() == size) {
                wait();
            }
            list.add(value);
            notify();
        }
    }

    public T poll() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) {
                wait();
            }
            T value = list.poll();
            notify();
            return value;
        }
    }

}