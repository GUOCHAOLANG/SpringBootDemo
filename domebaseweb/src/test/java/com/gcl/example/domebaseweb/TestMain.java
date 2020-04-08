package com.gcl.example.domebaseweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("one");
//        System.out.println("===="+list.size());
//        List<String> al = list.subList(1,1);
//        System.out.println("22222===="+al.size());

        List<One> companyList = new ArrayList<>();
        companyList.add(new One(1,true));
        companyList.add(new One(2,false));
        companyList.add(new One(3,true));
        companyList.add(new One(4,true));
        List<One> dataList = companyList.stream().map(company -> {
            One data = new One(company.getA(),company.getT());
            return data;
        }).filter(p -> judge(p)).collect(Collectors.toList());

        for (One o:dataList){
            System.out.println(o.getA());
        }
    }

    private static boolean judge(One p) {
        if (p.getT()) return p.getT();
        return false;
    }
}
