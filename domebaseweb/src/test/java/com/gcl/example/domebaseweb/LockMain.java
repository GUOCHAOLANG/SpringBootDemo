package com.gcl.example.domebaseweb;

public class LockMain {
    private static String A = "a";
    private static String B = "b";
    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("======a");
                    }
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A){
                        System.out.println("======b");
                    }
                }
            }
        });
        a.start();
        b.start();

    }
}
