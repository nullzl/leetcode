package com.nullzl.leetcode1200;

import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode1114 {

    class Foo {

        AtomicInteger ticket;

        public Foo() {
            ticket = new AtomicInteger(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.

            printFirst.run();
            ticket.set(2);
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while(!ticket.compareAndSet(2,3)){Thread.yield();}
            printSecond.run();
            ticket.set(4);
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            while(!ticket.compareAndSet(4,5)){Thread.yield();}
            printThird.run();
        }
    }
}
