package com.api.dynamicprogrammingapi.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.api.dynamicprogrammingapi.model.ComparisonRequest;
import com.api.dynamicprogrammingapi.model.ComparisonResult;
import com.api.dynamicprogrammingapi.service.AlgorithmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AlgorithmController.class)
class AlgorithmControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AlgorithmService algorithmService;

  private ComparisonRequest comparisonRequest;
  private ComparisonResult comparisonResult;

  @BeforeEach
  void setUp() {
    comparisonRequest = new ComparisonRequest();
    comparisonRequest.setSizes(Arrays.asList(10, 20, 30));
    comparisonRequest.setNumSamples(5);

    comparisonResult = new ComparisonResult();
    comparisonResult.setSizes(Arrays.asList(10, 20, 30));
    comparisonResult.setTimesRecMemo(Arrays.asList(1.0, 2.0, 3.0));
    comparisonResult.setTimesIter(Arrays.asList(1.5, 2.5, 3.5));

    Mockito.when(algorithmService.compareAlgorithms(comparisonRequest))
        .thenReturn(comparisonResult);
  }

  @Test
  void testCompareAlgorithms() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/algorithm/compare")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(comparisonRequest)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(asJsonString(comparisonResult)));
  }

  private static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
