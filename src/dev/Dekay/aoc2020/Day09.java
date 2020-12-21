package dev.Dekay.aoc2020;

import java.util.List;

public class Day09 extends AOCPuzzle {
    public Day09() {
        super("9");
    }

    @Override
    void solvePart1(List<String> input) {
        int length = 25;
        long wrongNumber = 0;
        List<Long> inputInt = convertToLongs(input);
        outer: for (int i = 0; i < input.size() - length - 1; i++) {
            long desired = inputInt.get(i + length);
            for (int j = i; j < i + length; j++) {
                long first = inputInt.get(j);
                for (int k = j + 1; k < i + length; k++) {
                    long second = inputInt.get(k);
                    if (first + second == desired) {
                        continue outer;
                    }
                }
            }
            wrongNumber = inputInt.get(i + length);
            break;
        }
        System.out.println(wrongNumber);
    }

    @Override
    void solvePart2(List<String> input) {

    }
}
