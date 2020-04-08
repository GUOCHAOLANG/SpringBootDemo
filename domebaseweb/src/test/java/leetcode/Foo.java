package leetcode;

/**
 * @Author gcl
 * @Date 2020/4/3 14:16
 */
public class Foo {
    private Object lockA = new Object();
    private volatile boolean la = false;
    private volatile boolean lb = false;


    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lockA) {
            printFirst.run();
            la = true;
            lockA.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lockA) {
            while (!la){
                lockA.wait();
            }
            printSecond.run();
            lb = true;
            lockA.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lockA) {
            while (!lb){
                lockA.wait();
            }
            printThird.run();
            lockA.notifyAll();
        }
    }

    public void one() {System.out.println("one"); }
    public void two() { System.out.println("two"); }
    public void three() { System.out.println("three"); }
}
