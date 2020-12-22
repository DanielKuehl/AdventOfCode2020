package dev.Dekay.aoc2020;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day13 extends AOCPuzzle {
    public Day13() {
        super("13");
    }

    @Override
    void solvePart1(List<String> input) {
        int earliestTime = Integer.parseInt(input.get(0));
        ArrayList<Integer> rates = new ArrayList<>();
        Arrays.stream(input.get(1).split(",")).filter(i -> !i.equals("x")).mapToInt(Integer::parseInt).forEach(rates::add);
        ArrayList<Integer> diff = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < rates.size(); i++) {
            int d = rates.get(i) - (earliestTime % rates.get(i));

            if (d < min) {
                min = d;
                minIndex = i;
            }

            diff.add(d);
        }

        System.out.println(rates.get(minIndex) * diff.get(minIndex));
    }

    @Override
    void solvePart2(List<String> input) {
        ArrayList<String> rates = new ArrayList<>(Arrays.asList(input.get(1).split(",")));

        int maxRate = rates.stream().filter(s -> !s.equals("x")).mapToInt(Integer::parseInt).max().orElse(0);

        boolean found = false;

        BigDecimal t = new BigDecimal("100000000000000");

        t = t.subtract(t.remainder(new BigDecimal(maxRate))).subtract(new BigDecimal(rates.indexOf(maxRate + "")));

        outer: while (!found) {
            for (int i = 0; i < rates.size(); i++) {
                if (rates.get(i).equals("x")) {
                    continue;
                }
                int rate = Integer.parseInt(rates.get(i));

                if (t.remainder(new BigDecimal(rate)).longValue() != (rate - i) % rate) {
                    t = t.add(new BigDecimal(maxRate));
                    continue outer;
                }
            }
            found = true;
        }
        System.out.println(t);
    }
}
