package se.iszla.aoc2022.doors;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.iszla.aoc2022.Door;

public class Door01 implements Door<Integer, Integer> {
  private static final Logger log = LoggerFactory.getLogger(Door01.class);

  @Override
  public Map<List<String>, Integer> getStepOneTestData() {
    return Map.of(
        List.of(
            "1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "",
            "10000"),
        24000);
  }

  public Integer stepOne(List<String> input) {
    return 0;
  }

  @Override
  public Map<List<String>, Integer> getStepTwoTestData() {
    return Map.of(
        List.of(
            "1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "",
            "10000"),
        45000);
  }

  public Integer stepTwo(List<String> input) {
    return 0;
  }
}
