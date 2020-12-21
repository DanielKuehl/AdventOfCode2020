package dev.Dekay.aoc2020;

import java.util.Comparator;
import java.util.List;

public class Day10 extends AOCPuzzle {

    public Day10() {
        super("10");
    }

    @Override
    void solvePart1(List<String> input) {
        input.sort(Comparator.comparingInt(Integer::parseInt));

        int prevVoltage = 0;
        int oneCounter = 0;
        int threeCounter = 0;

        for (String s : input) {
            int currentVoltage = Integer.parseInt(s);
            int diff = currentVoltage - prevVoltage;
            if (diff == 1) {
                oneCounter++;
            } else if (diff == 3) {
                threeCounter++;
            }
            prevVoltage = currentVoltage;
        }
        threeCounter++;

        System.out.println(oneCounter * threeCounter);
    }

    @Override
    void solvePart2(List<String> input) {
        input.sort(Comparator.comparingInt(Integer::parseInt));
        // Outlet Voltage
        input.add(input.get(input.size() - 1) + 3);

        int prevVoltage = 0;

        int possibilities = 0;

        for (int i = 0; i < input.size() - 1; i++) {
            String s = input.get(i);
            int currentVoltage = Integer.parseInt(s);
            int diff = currentVoltage - prevVoltage;


            prevVoltage = currentVoltage;
        }
    }
}
