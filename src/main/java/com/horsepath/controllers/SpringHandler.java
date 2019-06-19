package com.horsepath.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horse/rest")
public class SpringHandler {
    @GetMapping("/count")
    public String getCount(@RequestParam("width") int width,
                           @RequestParam("height") int height,
                           @RequestParam("start") String start,
                           @RequestParam("end") String end) {
        return "It's Spring Boot " + width + " " + height + " " + start + " " + end;
    }
}