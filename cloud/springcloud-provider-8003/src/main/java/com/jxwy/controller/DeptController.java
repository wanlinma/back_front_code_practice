package com.jxwy.controller;


import com.jxwy.springcloud.entities.Dept;
import com.jxwy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService service;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }


    // 服务发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices(); // 查找所有的微服务
        System.out.println("******" + list);
        List<ServiceInstance> srvList = client.getInstances("SPRINGCLOUD-PROVIDER"); // 大小写无要求
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.client;
    }


}
