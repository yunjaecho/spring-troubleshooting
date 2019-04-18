package com.yunjae.springtroubleshooting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 0.1.0
 * @Created by aromiton 2019-04-18
 */
@Controller
@Slf4j
public class HelloWorldController {

    @GetMapping("/")
    public String index() {
        log.warn("this is a warning");
        log.info("this is a info");
        log.debug("this is a debug");
        log.trace("this is a trace");
        log.error("this is a error");
//        log.fatal("This is absolutely FATAL!");

        return "index";
    }
}
