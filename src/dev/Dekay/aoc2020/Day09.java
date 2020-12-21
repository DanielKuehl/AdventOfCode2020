package dev.Dekay.aoc2020;

import java.util.List;

public class Day09 extends AOCPuzzle {
    public Day09() {
        super("9");
    }

    @Override
    void solvePart1(List<String> input) {
        System.out.println(findFlaw(input));
    }

    @Override
    void solvePart2(List<String> input) {
        long wrongNumber = findFlaw(input);

        List<Long> inputL = convertToLongs(input);

        long result = -1;
        outer: for (int i = 0; i < input.size() - 1; i++) {
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            long startValue = inputL.get(i);
            long sum = startValue;
            if (startValue < min) {
                min = startValue;
            }
            if (startValue > max) {
                max = startValue;
            }
            for (int j = i + 1; j < input.size(); j++) {
                long endValue = inputL.get(j);
                if (endValue < min) {
                    min = endValue;
                }
                if (endValue > max) {
                    max = endValue;
                }
                sum += endValue;
                if (sum == wrongNumber) {
                    result = min + max;
                    break outer;
                } else if (sum > wrongNumber) {
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private long findFlaw(List<String> input) {
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
        return wrongNumber;
    }
}
