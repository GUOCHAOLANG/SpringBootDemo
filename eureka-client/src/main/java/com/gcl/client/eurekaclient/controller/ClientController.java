package com.gcl.client.eurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {

    @RequestMapping("/client")
    public Map<String, String> client() {
        //localhost:10001/client
        Map<String, String> map = new HashMap<>();
        map.put("client01", "one");
        map.put("client02", "add");
        map.put("client03", "helloabc");
        return map;
    }
    @RequestMapping("/clientone")
    public Map<String, String> clientone(@RequestParam("one") String one) {
        //localhost:10001/clientone?one=123
        Map<String, String> map = new HashMap<>();
        map.put("带参数", "1111111");
        map.put("ttt", "222222");
        map.put("hellocanshu", one);
        return map;
    }

}
