package se.iszla.aoc2022;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner<T> {

  private static final Logger log = LoggerFactory.getLogger(Runner.class);

  public void execute(Door<T> day, T firstExpectedValue, T secondExpectedValue, String inputPath) {
    runDay(day.getClass().getSimpleName() + "01", day::StepOne, firstExpectedValue, inputPath);
    runDay(day.getClass().getSimpleName() + "02", day::StepTwo, secondExpectedValue, inputPath);
  }

  private void runDay(
      String name, Function<List<String>, T> func, T expectedValue, String readInput) {
    log.info("🎅 Executing {} ⛄", name);

    try {
      T actual = func.apply(Collections.emptyList());
      if (!actual.equals(expectedValue)) {
        log.error("🔴 {} failed, expected value {} but received {}\n", name, expectedValue, actual);
        return;
      }

      if (readInput != null) {
        Path resourcePath = Path.of(ClassLoader.getSystemResource(readInput).toURI());
        List<String> inputData = Files.readAllLines(resourcePath);
        log.info("🟢 Result {}\n", func.apply(inputData));
      }
    } catch (URISyntaxException | IOException e) {
      log.error("🟥 Failed to read input {}, {}\n", readInput, e.getMessage());
    } catch (RuntimeException e) {
      log.error("🟥 Failed to execute calculation: {}\n", e.getMessage());
    }
  }
}
