package com.example.traini8.controller;

import com.example.traini8.model.TrainingCenter;
import com.example.traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService service;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedTrainingCenter = service.saveTrainingCenter(trainingCenter);
        return ResponseEntity.ok(savedTrainingCenter);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = service.getAllTrainingCenters();
        return ResponseEntity.ok(centers);
    }
}
