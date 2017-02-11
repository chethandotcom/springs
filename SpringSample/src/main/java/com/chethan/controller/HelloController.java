package com.chethan.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chethanshetty on 11/02/17.
 */
@EnableAutoConfiguration
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("")
    @ResponseBody
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String helloWithName(@RequestBody String name) {
        return "Hello " + name;
    }
}
