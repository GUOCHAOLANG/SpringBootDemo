package com.gcl.server.eurekaserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServerController {

    @RequestMapping("/server")
    public Map<String, String> server() {
        //localhost:10001/client
        Map<String, String> map = new HashMap<>();
        map.put("client01", "one");
        map.put("client02", "add");
        map.put("client03", "helloabc");
        return map;
    }
}
