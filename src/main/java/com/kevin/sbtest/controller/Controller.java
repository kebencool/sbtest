package com.kevin.sbtest.controller;

import com.kevin.sbtest.common.annotation.ApiVersion;
import com.kevin.sbtest.service.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiVersion(1)
public class Controller {

    @Autowired
    AspectService aspectService;

    @ApiVersion(2)
    @RequestMapping("/testAspect")
    public String test(boolean exception) {
//        aspectService.aspectTest(exception);
        System.out.println("v2");
        return "testAspect";
    }

    @ApiVersion(1)
    @RequestMapping("/testAspect")
    public String test1(boolean exception) {
          aspectService.aspectTest(exception);
        System.out.println("v1");
        return "testAspect";
    }


}






