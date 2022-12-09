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

  public void run(Door<T> door, T firstExpectedValue, T secondExpectedValue, String inputPath) {
    runStep(door.getClass().getSimpleName() + "01", door::StepOne, firstExpectedValue, inputPath);
    runStep(door.getClass().getSimpleName() + "02", door::StepTwo, secondExpectedValue, inputPath);
  }

  private void runStep(
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
