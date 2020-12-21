package dev.Dekay.aoc2020;

import java.util.*;

public class Day06 extends AOCPuzzle {

    public Day06() {
        super("6");
    }

    @Override
    void solvePart1(List<String> input) {
        Set<Character> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            for (int j = 0; j < line.length(); j++) {
                set.add(line.charAt(j));
            }

            if (line.equals("") || i == input.size() - 1) {
                sum += set.size();
                set.clear();
            }
        }

        System.out.println(sum);
    }

    @Override
    void solvePart2(List<String> input) {
        Map<Character, Integer> m = new HashMap<>();
        int sum = 0;
        int persons = 0;
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            for (int j = 0; j < line.length(); j++) {
                Character c = line.charAt(j);
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) + 1);
                } else {
                    m.put(c, 1);
                }
            }
            persons++;

            if (line.equals("") || i == input.size() - 1) {
                if (i != input.size() - 1) {
                    persons--;
                }

                for (int j : m.values()) {
                    if (j == persons) {
                        sum++;
                    }
                }
                m.clear();
                persons = 0;
            }
        }

        System.out.println(sum);
    }
}
