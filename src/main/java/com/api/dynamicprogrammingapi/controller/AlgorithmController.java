package com.api.dynamicprogrammingapi.controller;

import com.api.dynamicprogrammingapi.model.ComparisonRequest;
import com.api.dynamicprogrammingapi.model.ComparisonResult;
import com.api.dynamicprogrammingapi.service.AlgorithmService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/algorithm")
@CrossOrigin(origins = "http://localhost:4200")
public class AlgorithmController {

  private final AlgorithmService algorithmService;

  public AlgorithmController(AlgorithmService algorithmService) {
    this.algorithmService = algorithmService;
  }

  @PostMapping("/compare")
  public ResponseEntity<ComparisonResult> compareAlgorithms(
      @Valid @RequestBody ComparisonRequest request
  ) {
    ComparisonResult result = algorithmService.compareAlgorithms(request);
    return ResponseEntity.ok(result);
  }
}
