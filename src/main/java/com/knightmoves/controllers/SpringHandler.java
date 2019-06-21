package com.knightmoves.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.knightmoves.service.ChessKnight.getXCoordinate;
import static com.knightmoves.service.ChessKnight.getYCoordinate;
import static com.knightmoves.service.ChessKnight.count;

@RestController
@RequestMapping("/knight/rest")
public class SpringHandler {
    @GetMapping(value = "/count", produces = { "text/plain" })
    public ResponseEntity<String> getCount(@RequestParam("width") int width,
                           @RequestParam("height") int height,
                           @RequestParam("start") String start,
                           @RequestParam("end") String end) {
        return ResponseEntity.ok(String.valueOf(count(width, height,
                getXCoordinate(start),
                getYCoordinate(start),
                getXCoordinate(end),
                getYCoordinate(end))));
    }
}