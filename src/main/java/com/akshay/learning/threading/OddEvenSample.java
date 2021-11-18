package com.akshay.learning.threading;

public class OddEvenSample {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        int TOTAL = 10;
        Thread oddThread = new Thread(new TaskEvenOdd(printer, TOTAL, false), "Odd-Thread");
        Thread evenThread = new Thread(new TaskEvenOdd(printer, TOTAL, true), "Even-Thread");
        oddThread.start();
        evenThread.start();
        oddThread.join();
        evenThread.join();
        System.out.println("Finished");
    }
}

class TaskEvenOdd implements Runnable {

    private final Printer printer;
    private final int total;
    private final boolean isEven;

    public TaskEvenOdd(Printer printer, int total, boolean isEven) {
        this.printer = printer;
        this.total = total;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while (number <= total) {
            if (isEven) {
                printer.printEven(number);
            } else {
                printer.printOdd(number);
            }
            number += 2;
        }
    }
}

class Printer {

    private volatile boolean isOdd = false;

    synchronized void printEven(int number) {

        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Even:" + number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Odd:" + number);
        isOdd = true;
        notifyAll();
    }

}

