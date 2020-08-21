package com.memorize.api.controller;

import com.memorize.api.service.INumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/athletes/{athleteId}/numbers")
public class NumberDataController {
    private final INumberService iNumberService;

    @Autowired
    public NumberDataController(INumberService iNumberService) {
        this.iNumberService = iNumberService;
    }

    @GetMapping
    public ResponseEntity<?> getNumberData(@PathVariable("athleteId") String athleteId) {
        try {
           return ResponseEntity.ok(iNumberService.getNumberData(UUID.fromString(athleteId)));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
