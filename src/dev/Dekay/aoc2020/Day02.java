package dev.Dekay.aoc2020;

import java.util.List;

public class Day02 extends AOCPuzzle {

    public Day02() {
        super("2");
    }

    @Override
    void solvePart1(List<String> input) {
        int validPW = 0;
        for (String s : input) {
            String[] tokens = s.split("[- ]|(: )");
            int min = Integer.parseInt(tokens[0]);
            int max = Integer.parseInt(tokens[1]);
            String c = tokens[2];
            String pw = tokens[3];

            int counter = 0;
            for (int i = 0; i < pw.length(); i++) {
                if (pw.charAt(i) == c.charAt(0)) {
                    counter++;
                }
            }
            if (min <= counter && counter <= max) {
                validPW++;
            }
        }

        System.out.println(validPW);
    }

    @Override
    void solvePart2(List<String> input) {
        int validPW = 0;
        for (String s : input) {
            String[] tokens = s.split("[- ]|(: )");
            int first = Integer.parseInt(tokens[0]);
            int second = Integer.parseInt(tokens[1]);
            char c = tokens[2].charAt(0);
            String pw = tokens[3];


            boolean b1 = pw.charAt(first - 1) == c;
            boolean b2 = pw.charAt(second - 1) == c;
            if ((b1 || b2) && !(b1 && b2)) {
                validPW++;
            }
        }

        System.out.println(validPW);
    }
}
