package dev.Dekay.aoc2020;

import java.util.List;

public class Day04 extends AOCPuzzle {

    public Day04() {
        super("4");
    }

    @Override
    void solvePart1(List<String> input) {
        boolean byr = false, iyr = false, eyr = false, hgt = false, hcl = false, ecl = false, pid = false;
        int counter = 0;
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            if (line.contains("byr")) {
                byr = true;
            }
            if (line.contains("iyr")) {
                iyr = true;
            }
            if (line.contains("eyr")) {
                eyr = true;
            }
            if (line.contains("hgt")) {
                hgt = true;
            }
            if (line.contains("hcl")) {
                hcl = true;
            }
            if (line.contains("ecl")) {
                ecl = true;
            }
            if (line.contains("pid")) {
                pid = true;
            }

            if (line.equals("") || i == input.size() - 1) {
                if (byr && iyr && eyr && hgt && hcl && ecl && pid) {
                    counter++;
                }
                byr = false;
                iyr = false;
                eyr = false;
                hgt = false;
                hcl = false;
                ecl = false;
                pid = false;
            }
        }
        System.out.println(counter);
    }

    @Override
    void solvePart2(List<String> input) {
        boolean byr = false, iyr = false, eyr = false, hgt = false, hcl = false, ecl = false, pid = false;
        int counter = 0;
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                if (token.matches("^byr:(19[2-9][0-9]$|200[0-2]$)")) {
                    byr = true;
                    continue;
                }

                if (token.matches("^iyr:(201[0-9]$|2020$)")) {
                    iyr = true;
                    continue;
                }

                if (token.matches("^eyr:(202[0-9]$|2030$)")) {
                    eyr = true;
                    continue;
                }

                if (token.matches("^hgt:((1[5-8][0-9]|19[0-3])cm$|(59|6[0-9]|7[0-6])in$)")) {
                    hgt = true;
                    continue;
                }

                if (token.matches("^hcl:#[0-9a-f]{6}$")) {
                    hcl = true;
                    continue;
                }


                if (token.matches("^ecl:(amb|blu|brn|gry|grn|hzl|oth)$")) {
                    ecl = true;
                    continue;
                }

                if (token.matches("^pid:[0-9]{9}$")) {
                    pid = true;
                }
            }
            if (line.equals("") || i == input.size() - 1) {
                if (byr && iyr && eyr && hgt && hcl && ecl && pid) {
                    counter++;
                }
                byr = false;
                iyr = false;
                eyr = false;
                hgt = false;
                hcl = false;
                ecl = false;
                pid = false;
            }
        }
        System.out.println(counter);
    }
}
