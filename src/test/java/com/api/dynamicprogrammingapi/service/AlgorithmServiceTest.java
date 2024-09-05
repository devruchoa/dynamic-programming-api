package com.api.dynamicprogrammingapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.api.dynamicprogrammingapi.model.ComparisonRequest;
import com.api.dynamicprogrammingapi.model.ComparisonResult;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AlgorithmServiceTest {

  @InjectMocks
  private AlgorithmService algorithmService;

  private ComparisonRequest comparisonRequest;

  @BeforeEach
  public void setUp() {
    comparisonRequest = new ComparisonRequest();
    comparisonRequest.setSizes(Arrays.asList(10, 20, 30));
    comparisonRequest.setNumSamples(5);
  }

  @Test
  void testCompareAlgorithms() {
    ComparisonResult result = algorithmService.compareAlgorithms(comparisonRequest);

    List<Integer> expectedSizes = comparisonRequest.getSizes();
    assertEquals(expectedSizes, result.getSizes());

    assertEquals(expectedSizes.size(), result.getTimesRecMemo().size());
    assertEquals(expectedSizes.size(), result.getTimesIter().size());
  }
}
