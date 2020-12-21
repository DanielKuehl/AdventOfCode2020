package dev.Dekay.aoc2020;

import java.util.*;

public class Day07 extends AOCPuzzle {

    public Day07() {
        super("7");
    }

    @Override
    void solvePart1(List<String> input) {
        Set<String> possibleColors = new HashSet<>();
        Map<String, List<String>> rules = new HashMap<>();

        for (String line : input) {
            String[] tokens = line.split("s contain ");
            String outerBag = tokens[0];
            String[] innerBags = tokens[1].split("([1-9] )|(s*, )|(s*\\.)");

            innerBags = Arrays.stream(innerBags).filter(s -> !s.equals("")).toArray(String[]::new);

            if (tokens[1].equals("no other bags.")) {
                rules.put(outerBag, Collections.emptyList());
            } else {
                rules.put(outerBag, Arrays.asList(innerBags));
            }
        }

        List<String> toCheck = new ArrayList<>(Collections.singletonList("shiny gold bag"));
        for (int i = 0; i < toCheck.size(); i++) {
            String element = toCheck.get(i);
            for (String key : rules.keySet()) {
                List<String> l = rules.get(key);

                for (String s : l) {
                    if (s.equals(element)) {
                        possibleColors.add(key);
                        if (!toCheck.contains(key)) {
                            toCheck.add(key);
                        }
                    }
                }
            }
        }

        System.out.println(possibleColors.size());
    }

    @Override
    void solvePart2(List<String> input) {
        Map<String, List<String>> rules = new HashMap<>();

        for (String line : input) {
            String[] tokens = line.split("s contain ");
            String outerBag = tokens[0];
            String[] innerBags = tokens[1].split("(s*, )|(s*\\.)");

            System.out.println(outerBag);
            System.out.println(Arrays.toString(innerBags));

            if (tokens[1].equals("no other bags.")) {
                rules.put(outerBag, Collections.emptyList());
            } else {
                rules.put(outerBag, Arrays.asList(innerBags));
            }
        }

        System.out.println(getBags(rules, "shiny gold bag") - 1);
    }

    private int getBags(Map<String, List<String>> rules, String bag) {
        int sum = 1;

        List<String> insides = rules.get(bag);

        if (insides.size() == 0) {
            return 1;
        }

        for (String inside : insides) {
            int factor = Integer.parseInt(inside.charAt(0) + "");
            String innerBag = inside.substring(2);
            sum += factor * getBags(rules, innerBag);
        }

        return sum;
    }
}
