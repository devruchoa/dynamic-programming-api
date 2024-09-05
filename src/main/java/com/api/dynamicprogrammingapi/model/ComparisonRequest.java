package com.api.dynamicprogrammingapi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class ComparisonRequest {

  @NotEmpty(message = "Sizes list cannot be empty")
  private List<@NotNull @Min(value = 1, message = "Size must be greater than 0") Integer> sizes;
  @Min(value = 1, message = "Number of samples must be at least 1")
  private int numSamples;

  public List<Integer> getSizes() {
    return sizes;
  }

  public void setSizes(List<Integer> sizes) {
    this.sizes = sizes;
  }

  public int getNumSamples() {
    return numSamples;
  }

  public void setNumSamples(int numSamples) {
    this.numSamples = numSamples;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComparisonRequest that = (ComparisonRequest) o;
    return numSamples == that.numSamples && Objects.equals(sizes, that.sizes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sizes, numSamples);
  }

  @Override
  public String toString() {
    return "ComparisonRequest{" +
        "sizes=" + sizes +
        ", numSamples=" + numSamples +
        '}';
  }
}
