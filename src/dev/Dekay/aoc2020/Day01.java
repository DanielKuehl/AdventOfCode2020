package dev.Dekay.aoc2020;

import java.util.List;

public class Day01 extends AOCPuzzle {

    public Day01() {
        super("1");
    }

    @Override
    void solvePart1(List<String> input) {
        List<Integer> l = convertToInts(input);

        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                int a = l.get(i);
                int b = l.get(j);
                if (a + b == 2020) {
                    System.out.println(a * b);
                }
            }
        }
    }

    @Override
    void solvePart2(List<String> input) {
        List<Integer> l = convertToInts(input);

        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                for (int k = j + 1; k < l.size(); k++) {
                    int a = l.get(i);
                    int b = l.get(j);
                    int c = l.get(k);
                    if (a + b + c == 2020) {
                        System.out.println(a * b * c);
                    }
                }
            }
        }
    }
}
