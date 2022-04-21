package com.nullzl.leetcode1200;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class LeetCode1115 {

    class SpinLock1{
        private volatile int flag;
        private volatile Thread waiter;
        private int spinTimes = Runtime.getRuntime().availableProcessors() < 2 ? 0 : 32;

        public SpinLock1(){
            flag = 0;
        }

        public void lock(int i){

            int spins = -1;
            while(true){
                if(flag == i)
                    return ;

                if(-1 == spins)
                    spins = spinTimes;
                else if(spins > 0){
                    spins--;
                }else if(null == waiter){
                    waiter = Thread.currentThread();
                } else{
                    LockSupport.park();
                }

            }
        }

        public void unlock(int i){
            flag = i ^ 1;
            if(null != waiter){
                LockSupport.unpark(waiter);
                waiter = null;
            }
        }
    }

    class SpinLock2{
        private Semaphore[] locks;
        public SpinLock2(){
            locks = new Semaphore[]{new Semaphore(1),new Semaphore(0)};
        }

        public void lock(int index){
            this.locks[index].acquireUninterruptibly();
        }

        public void unlock(int index){
            this.locks[1 ^ index].release();
        }
    }

    class SpinLock3 extends AbstractQueuedSynchronizer{
        public SpinLock3(){
            this.setState(0);
        }

        @Override
        public boolean tryAcquire(int i){
            return i == this.getState();
        }

        @Override
        public boolean tryRelease(int i){
            this.setState(i);
            return true;
        }

        public void lock(int i){
            this.acquire(i);
        }

        public void unlock(int i){
            this.release(i ^ 1);
        }
    }

    class SpinLock4{
        private final AtomicIntegerArray vals;

        public SpinLock4(){
            vals = new AtomicIntegerArray(98);
            vals.set(32,1);

        }

        public void lock(int i){
            vals.get(i == 0 ? 65 : 32);
            while(0 == vals.get(i == 0 ? 32 : 65));
        }

        public void unlock(int i){
            vals.set(i == 0 ? 32 : 65,0);
            vals.set(i == 0 ? 65 : 32,1);
        }
    }

    class SpinLock6{
        private final AtomicIntegerArray vals;
        public SpinLock6(){
            vals = new AtomicIntegerArray(98);
            vals.set(32,1);

        }

        public void lock(int i){
            while(0 == vals.get(i == 0 ? 32 : 65));
            vals.set(i == 0 ? 32 : 65,0);
        }

        public void unlock(int i){
            vals.set(i == 0 ? 65 : 32, 1);
        }
    }

    class SpinLock{
        private final AtomicIntegerArray vals;

        public SpinLock(){

            vals = new AtomicIntegerArray(2);
        }

        public int lock(int i){
            int spins = 0;
            while(0 == vals.get(i)){
                for(spins = 0 ; spins < 100 ; spins++);
            }
            vals.set(i,0);
            return spins;
        }

        public void unlock(int i){
            vals.set(i ^ 1, 1);
        }
    }


    class FooBar {
        private int n;
        private SpinLock lock ;
        public FooBar(int n) {
            this.n = n;
            lock = new SpinLock();

        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock(0);
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock.unlock(0);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock(1);
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock.unlock(1);
            }
        }
    }

}
