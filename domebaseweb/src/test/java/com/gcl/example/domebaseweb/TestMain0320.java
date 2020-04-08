package com.gcl.example.domebaseweb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * gcl
 * 2020/3/20 14:15
 */
public class TestMain0320 {
    public static void main(String[] args) {
        System.out.println("======"+doTest("c"));
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(10));
        list.add(new Apple(500));
        list.add(new Apple(11));
        list.add(new Apple(300));
        list.stream().forEach(s-> System.out.print(s.high+" "));
        System.out.println();
        list.sort(Comparator.comparing(Apple::getHigh));
        list.stream().forEach(s-> System.out.print(s.high+" "));
        System.out.println();
        //类：
        Comparator<Integer> cam1 = (x,y)->x.compareTo(y);
        System.out.println(cam1.compare(12,3));
        Comparator<Integer> cam = Integer::compareTo;
        System.out.println(cam.compare(3,3));
        System.out.println();
        Thread t = new Thread(()-> System.out.println("hello"));
        //List<Apple> newList = filterApples(list, Apple::isHighApple);
        List<Apple> newList = filterApples(list, (Apple a)->a.getHigh()>=11);

        newList.stream().forEach(s-> System.out.print(s.high+" "));
    }

    private static int doTest(String a) {
        switch (a){
            case "a": return 1;
            case "b": return 2;
        }
        System.out.println("over");
        return 0;
    }

    static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple :apples){
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    private static class Apple {
        private Integer high;

        public Integer getHigh() {
            return high;
        }

        public void setHigh(Integer high) {
            this.high = high;
        }

        public Apple(Integer high) {
            this.high = high;
        }
        public static boolean isHighApple(Apple apple){
            return apple.getHigh()>100;
        }
    }
}
