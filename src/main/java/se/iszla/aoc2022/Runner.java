package se.iszla.aoc2022;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner<T> {

  private static final Logger log = LoggerFactory.getLogger(Runner.class);

  public void run(Door<T> door, String inputPath) {
    runDay(
        door.getClass().getSimpleName() + "01",
        door::stepOne,
        door.getStepOneTestData(),
        inputPath);
    runDay(
        door.getClass().getSimpleName() + "02",
        door::stepTwo,
        door.getStepTwoTestData(),
        inputPath);
  }

  private void runDay(
      String name,
      Function<List<String>, T> func,
      Map<List<String>, T> testInput,
      String readInput) {
    log.info("🎅 Executing {} ⛄", name);

    try {
      for (Map.Entry<List<String>, T> test : testInput.entrySet()) {
        T actual = func.apply(test.getKey());
        if (!actual.equals(test.getValue())) {
          log.error(
              "🔴 {} failed, expected value {} but received {}\n", name, test.getValue(), actual);
          return;
        }
      }

      List<String> inputData = Collections.emptyList();
      try {
        if (readInput != null) {
          Path resourcePath = Path.of(ClassLoader.getSystemResource(readInput).toURI());
          inputData = Files.readAllLines(resourcePath);
        }
      } catch (Exception e) {
        log.error("🟥 Failed to read input {}, {}\n", readInput, e.getMessage());
      }

      log.info("🟢 Result: {}\n", func.apply(inputData));
    } catch (RuntimeException e) {
      log.error("🟥 Failed to execute calculation: {}\n", e.getMessage());
    }
  }
}
