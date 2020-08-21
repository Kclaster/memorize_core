package com.memorize.api.controller;

import com.memorize.api.service.INumberService;
import com.memorize.model.number.NumberPerformancePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PostMapping
    @RequestMapping("{numberId}/numberPerformances")
    public ResponseEntity PostAttempt(@PathVariable(value = "athleteId") String athleteId,
                                      @PathVariable(value = "numberId") String numberId,
                                      @RequestBody final NumberPerformancePostRequest numberPerformanceEntity) throws Exception {
        URI location = URI.create(String.format("api/v1/users/%s/numbers", athleteId));
        iNumberService.createNumberPerformance(UUID.fromString(athleteId), UUID.fromString(numberId), numberPerformanceEntity);

        return ResponseEntity.created(location).build();
    }
}
