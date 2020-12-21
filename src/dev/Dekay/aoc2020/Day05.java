package dev.Dekay.aoc2020;

import java.util.List;
import java.util.stream.IntStream;

public class Day05 extends AOCPuzzle {
    
    public Day05() {
        super("5");
    }

    @Override
    void solvePart1(List<String> input) {
        int highestID = -1;
        for (String line : input) {
            int start = 0;
            int end = 127;
            for (int i = 0; i < 7; i++) {
                if (line.charAt(i) == 'F') {
                    end = (end + start) / 2;
                } else {
                    start = (end + start) / 2 + 1;
                }
            }
            int row = start;

            start = 0;
            end = 7;
            for (int i = 7; i < 10; i++) {
                if (line.charAt(i) == 'L') {
                    end = (end + start) / 2;
                } else {
                    start = (end + start) / 2 + 1;
                }
            }
            int col = start;

            highestID = Math.max(highestID, row * 8 + col);
        }
        System.out.println(highestID);
    }

    @Override
    void solvePart2(List<String> input) {
        IntStream s = IntStream.iterate(0, i -> i < 128 * 8, i -> ++i);

        for (String line : input) {
            int start = 0;
            int end = 127;
            for (int i = 0; i < 7; i++) {
                if (line.charAt(i) == 'F') {
                    end = (end + start) / 2;
                } else {
                    start = (end + start) / 2 + 1;
                }
            }
            int id = start * 8;

            start = 0;
            end = 7;
            for (int i = 7; i < 10; i++) {
                if (line.charAt(i) == 'L') {
                    end = (end + start) / 2;
                } else {
                    start = (end + start) / 2 + 1;
                }
            }
            id += start;

            int finalId = id;
            s = s.filter(i -> i != finalId);
        }
        int[] a = s.toArray();

        for (int i = 1; i < a.length - 1; i++) {
            int beforeID = a[i - 1];
            int seatID = a[i];
            int afterID = a[i + 1];

            if (beforeID - seatID != -1 && seatID - afterID != -1) {
                System.out.println(seatID);
            }
        }
    }
}
