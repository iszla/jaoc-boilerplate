package se.iszla.aoc2022;

import java.util.List;
import java.util.Map;

public interface Door<T> {
    Map<List<String>,T> getStepOneTestData();
    T stepOne(List<String> input);
    Map<List<String>,T> getStepTwoTestData();
    T stepTwo(List<String> input);
}
