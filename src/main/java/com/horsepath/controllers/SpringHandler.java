package com.horsepath.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.horsepath.service.HorsePath.getXCoordinate;
import static com.horsepath.service.HorsePath.getYCoordinate;
import static com.horsepath.service.HorsePath.count;

@RestController
@RequestMapping("/horse/rest")
public class SpringHandler {
    @GetMapping("/count")
    public int getCount(@RequestParam("width") int width,
                           @RequestParam("height") int height,
                           @RequestParam("start") String start,
                           @RequestParam("end") String end) {
        return count(width, height,
                getXCoordinate(start),
                getYCoordinate(start),
                getXCoordinate(end),
                getYCoordinate(end));
    }
}