package dev.Dekay.aoc2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AOCPuzzle {
    String day;

    public AOCPuzzle(String day) {
        this.day = day;
        File file = new File("res/day" + day + ".txt");
        if (!file.exists()) {
            solve(new ArrayList<>());
            return;
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("File not found!!");
            solve(new ArrayList<>());
            return;
        }

        List<String> inputLines = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null)
                inputLines.add(line);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        solve(inputLines);
    }

    public void solve(List<String> input) {
        System.out.println("Day " + day + ":");
        System.out.print("Answer Part1 : ");
        solvePart1(input);
        System.out.print("Answer Part2 : ");
        solvePart2(input);
    }

    abstract void solvePart1(List<String> input);
    abstract void solvePart2(List<String> input);

    public List<Integer> convertToInts(List<String> input) {
        List<Integer> ints = new ArrayList<>();
        for (String s : input)
            ints.add(Integer.parseInt(s));
        return ints;
    }

    public List<Long> convertToLongs(List<String> input) {
        List<Long> ints = new ArrayList<>();
        for (String s : input)
            ints.add(Long.parseLong(s));
        return ints;
    }

}