package com.github.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${keySwitch:Y}")
    private String keySwitch;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable("id") Long id) {
        if ("ALL".equals(keySwitch)) {
            return String.format("user-ALL-%s", id);
        }
        return String.format("user-%s-%s", keySwitch, id);
    }
}

