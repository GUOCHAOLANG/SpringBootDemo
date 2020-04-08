package com.gcl.example.domebaseweb;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author gcl
 * @Date 2020/4/7 11:26
 */
public class TestMain0407 {
    public static void main(String[] args) {
        Map<String,Long> map = new HashMap<>();
        map.put("one",3L);
        map.put("one",2L);

        System.out.println(map.get("one"));
    }
}
