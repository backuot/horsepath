package com.knightmoves.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.knightmoves.services.ChessKnight.getXCoordinate;
import static com.knightmoves.services.ChessKnight.getYCoordinate;
import static com.knightmoves.services.ChessKnight.count;
import static com.knightmoves.services.ChessKnight.valid;

@RestController
@RequestMapping("/knight/rest")
public class SpringController {
    @GetMapping(value = "/count", produces = { "text/plain" })
    public ResponseEntity<String> getCount(@RequestParam("width") int width,
                                           @RequestParam("height") int height,
                                           @RequestParam("start") String start,
                                           @RequestParam("end") String end) {
        if (width < 3)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not valid width.");
        if (height < 3)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not valid height.");

        int x1 = getXCoordinate(start);
        int y1 = getYCoordinate(start);
        int x2 = getXCoordinate(end);
        int y2 = getYCoordinate(end);

        if (!valid(x1, y1, width, height))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not valid start.");
        if (!valid(x2, y2, width, height))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not valid end.");

        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(count(x1, y1, x2, y2, width, height)));
    }
}