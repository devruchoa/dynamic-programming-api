package com.api.dynamicprogrammingapi.model;

import java.util.List;
import java.util.Objects;

public class ComparisonResult {

  private List<Integer> sizes;
  private List<Double> timesRecMemo;
  private List<Double> timesIter;

  public List<Integer> getSizes() {
    return sizes;
  }

  public void setSizes(List<Integer> sizes) {
    this.sizes = sizes;
  }

  public List<Double> getTimesRecMemo() {
    return timesRecMemo;
  }

  public void setTimesRecMemo(List<Double> timesRecMemo) {
    this.timesRecMemo = timesRecMemo;
  }

  public List<Double> getTimesIter() {
    return timesIter;
  }

  public void setTimesIter(List<Double> timesIter) {
    this.timesIter = timesIter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComparisonResult that = (ComparisonResult) o;
    return Objects.equals(sizes, that.sizes) && Objects.equals(timesRecMemo,
        that.timesRecMemo) && Objects.equals(timesIter, that.timesIter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sizes, timesRecMemo, timesIter);
  }

  @Override
  public String toString() {
    return "ComparisonResult{" +
        "sizes=" + sizes +
        ", timesRecMemo=" + timesRecMemo +
        ", timesIter=" + timesIter +
        '}';
  }
}
