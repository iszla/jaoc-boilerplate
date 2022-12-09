package se.iszla.aoc2022;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.iszla.aoc2022.doors.Door01;

public class Aoc2022 {
    private static final Logger log = LoggerFactory.getLogger(Aoc2022.class);

    public static void main(String[] args) {
        Runner<Integer> intRunner = new Runner<>();

        log.info("Starting AoC 2022 executor");
        log.info("Legend:\n🟢 Passed test\n🔴 Failed test\n🟥 Exception");

        intRunner.run(new Door01(), 24000, 45000, "01.txt");
    }
}
