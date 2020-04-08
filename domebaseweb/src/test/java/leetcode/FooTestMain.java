package leetcode;

/**
 * @Author gcl
 * @Date 2020/4/3 14:24
 */
public class FooTestMain {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new Runnable() {
                        @Override
                        public void run() {
                            //System.out.println(1);
                            foo.one();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(new Runnable() {
                        @Override
                        public void run() {
                            //System.out.println(2);
                            foo.two();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new Runnable() {
                        @Override
                        public void run() {
                            //System.out.println(3);
                            foo.three();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
