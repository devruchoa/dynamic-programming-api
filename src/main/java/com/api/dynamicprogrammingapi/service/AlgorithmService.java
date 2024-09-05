package com.api.dynamicprogrammingapi.service;

import com.api.dynamicprogrammingapi.model.ComparisonRequest;
import com.api.dynamicprogrammingapi.model.ComparisonResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class AlgorithmService {

  private static final int MAX_RANDOM_VALUE = 100;
  private static final int RANDOM_OFFSET = 1;
  private static final int MILLISECONDS_CONVERSION = 1_000_000;
  private final Random random = new Random();

  public ComparisonResult compareAlgorithms(ComparisonRequest request) {
    List<Integer> sizes = request.getSizes();
    int numSamples = request.getNumSamples();

    List<Double> timesRecMemo = new ArrayList<>();
    List<Double> timesIter = new ArrayList<>();

    for (int size : sizes) {
      timesRecMemo.add(measureAverageTime(() -> executeKnapsackRecMemo(size), numSamples));
      timesIter.add(measureAverageTime(() -> executeKnapsackIter(size), numSamples));
    }

    ComparisonResult result = new ComparisonResult();
    result.setSizes(sizes);
    result.setTimesRecMemo(timesRecMemo);
    result.setTimesIter(timesIter);

    return result;
  }

  private double measureAverageTime(Runnable algorithm, int numSamples) {
    long totalTime = IntStream.range(0, numSamples)
        .mapToLong(i -> {
          long startTime = System.nanoTime();
          algorithm.run();
          return System.nanoTime() - startTime;
        })
        .sum();
    return totalTime / (double) numSamples / MILLISECONDS_CONVERSION;
  }

  private void executeKnapsackRecMemo(int size) {
    int[] weights = generateRandomArray(size);
    int[] values = generateRandomArray(size);
    int capacity = size * 10;

    knapsackRecMemo(weights, values, capacity);
  }

  private void executeKnapsackIter(int size) {
    int[] weights = generateRandomArray(size);
    int[] values = generateRandomArray(size);
    int capacity = size * 10;

    knapsackIter(weights, values, capacity);
  }

  private int[] generateRandomArray(int size) {
    return random.ints(size, RANDOM_OFFSET, MAX_RANDOM_VALUE + RANDOM_OFFSET).toArray();
  }

  private void knapsackRecMemo(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] memo = new int[n][capacity + 1];
    knapsackRecMemoHelper(weights, values, capacity, n - 1, memo);
  }

  private int knapsackRecMemoHelper(int[] weights, int[] values, int capacity, int i,
      int[][] memo) {
    if (i < 0 || capacity <= 0) {
      return 0;
    }
    if (memo[i][capacity] != 0) {
      return memo[i][capacity];
    }
    if (weights[i] > capacity) {
      memo[i][capacity] = knapsackRecMemoHelper(weights, values, capacity, i - 1, memo);
    } else {
      int include =
          values[i] + knapsackRecMemoHelper(weights, values, capacity - weights[i], i - 1, memo);
      int exclude = knapsackRecMemoHelper(weights, values, capacity, i - 1, memo);
      memo[i][capacity] = Math.max(include, exclude);
    }
    return memo[i][capacity];
  }

  private void knapsackIter(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];
    for (int i = 1; i <= n; i++) {
      for (int w = 0; w <= capacity; w++) {
        if (weights[i - 1] <= w) {
          dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
        } else {
          dp[i][w] = dp[i - 1][w];
        }
      }
    }
  }
}
