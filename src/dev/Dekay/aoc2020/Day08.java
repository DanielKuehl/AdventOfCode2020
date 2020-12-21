package dev.Dekay.aoc2020;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day08 extends AOCPuzzle {

    public Day08() {
        super("8");
    }

    @Override
    void solvePart1(List<String> input) {
        int pos = 0;
        int acc = 0;
        Set<Integer> visited = new HashSet<>();

        while (true) {
            String instr = input.get(pos);
            if (!visited.add(pos)) {
                break;
            }
            if (instr.startsWith("acc")) {
                acc += parseSignedInt(instr.substring(4));
            } else if (instr.startsWith("jmp")) {
                pos += parseSignedInt(instr.substring(4));
                continue;
            }
            pos++;
        }

        System.out.println(acc);
    }

    @Override
    void solvePart2(List<String> input) {
        int acc = 0;
        Set<Integer> visited = new HashSet<>();
        int num = (int) input.stream().filter(s -> s.startsWith("jmp") || s.startsWith("nop")).count();

        outer: for (int i = 1; i < num + 1; i++) {
            int pos = 0;

            int occ = 1;
            while (pos < input.size()) {
                String instr = input.get(pos);
                if (!visited.add(pos)) {
                    visited.clear();
                    acc = 0;
                    continue outer;
                }
                if (instr.startsWith("acc")) {
                    acc += parseSignedInt(instr.substring(4));
                } else if (instr.startsWith("jmp")) {
                    if (occ != i) {
                        pos += parseSignedInt(instr.substring(4));
                        occ++;
                        continue;
                    }
                    occ++;
                } else if (instr.startsWith("nop")) {
                    if (occ == i) {
                        pos += parseSignedInt(instr.substring(4));
                        occ++;
                        continue;
                    }
                    occ++;
                }
                pos++;
            }
            break;
        }

        System.out.println(acc);
    }

    private int parseSignedInt(String s) {
        if (s.startsWith("+")) {
            return Integer.parseInt(s.substring(1));
        } else {
            return -Integer.parseInt(s.substring(1));
        }
    }
}
