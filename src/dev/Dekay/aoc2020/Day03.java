package dev.Dekay.aoc2020;

import java.util.List;

public class Day03 extends AOCPuzzle {

    public Day03() {
        super("3");
    }

    @Override
    void solvePart1(List<String> input) {
        int x = 0;
        int y = 0;

        int treeCounter = 0;
        do {
            String row = input.get(y);
            if (row.charAt(x % row.length()) == '#') {
                treeCounter++;
            }
            x += 3;
            y += 1;

        } while (y < input.size());
        System.out.println(treeCounter);
    }

    @Override
    void solvePart2(List<String> input) {
        int[][] slopes = new int[][]{{1, 1},
                {3, 1},
                {5, 1},
                {7, 1},
                {1, 2}};

        long treeFactor = 1;
        for (int[] slope : slopes) {


            int x = 0;
            int y = 0;

            int treeCount = 0;
            do {
                String row = input.get(y);
                if (row.charAt(x % row.length()) == '#') {
                    treeCount++;
                }
                x += slope[0];
                y += slope[1];

            } while (y < input.size());
            treeFactor *= treeCount;
        }
        System.out.println(treeFactor);
    }
}
