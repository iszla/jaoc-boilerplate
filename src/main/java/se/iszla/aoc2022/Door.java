package se.iszla.aoc2022;

import java.util.List;

public interface Door<T> {
    T StepOne(List<String> input);
    T StepTwo(List<String> input);
}
