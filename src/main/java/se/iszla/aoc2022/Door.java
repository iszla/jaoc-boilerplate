package se.iszla.aoc2022;

import java.util.List;
import java.util.Map;

public interface Door<T, U> {
    Map<List<String>,T> getStepOneTestData();
    T stepOne(List<String> input);
    Map<List<String>,U> getStepTwoTestData();
    U stepTwo(List<String> input);
}
