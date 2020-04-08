package leetcode;

/**
 * @Author gcl
 * @Date 2020/4/3 15:40
 */
public class FooBar {
    private boolean flag = true;
    private Object lock = new Object();
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (lock) {
                while (!flag){
                    lock.wait();
                }
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (lock) {
                while (flag){
                    lock.wait();
                }
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }
}
