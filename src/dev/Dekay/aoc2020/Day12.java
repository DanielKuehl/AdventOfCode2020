package dev.Dekay.aoc2020;

import java.util.List;

public class Day12 extends AOCPuzzle {
    public Day12() {
        super("12");
    }

    @Override
    void solvePart1(List<String> input) {
        int angle = 0;
        double posHor = 0;
        double posVert = 0;

        for (String instr : input) {
            int value = Integer.parseInt(instr.substring(1));
            switch (instr.charAt(0)) {
                case 'N':
                    posVert += value;
                    break;
                case 'S':
                    posVert -= value;
                    break;
                case 'E':
                    posHor += value;
                    break;
                case 'W':
                    posHor -= value;
                    break;
                case 'L':
                    angle += value;
                    break;
                case 'R':
                    angle-= value;
                    break;
                case 'F':
                    posHor += Math.cos(Math.toRadians(angle)) * value;
                    posVert += Math.sin(Math.toRadians(angle)) * value;
                    break;
            }
        }

        System.out.println(Math.round(Math.abs(posHor) + Math.abs(posVert)));
    }

    @Override
    void solvePart2(List<String> input) {
        int xDir = 1;
        int yDir = 0;
        int shipX = 0;
        int shipY = 0;
        int wayPointX = 10;
        int wayPointY = 1;

        for (String instr : input) {
            int value = Integer.parseInt(instr.substring(1));
            switch (instr.charAt(0)) {
                case 'N':
                    wayPointY += value;
                    break;
                case 'S':
                    wayPointY -= value;
                    break;
                case 'E':
                    wayPointX += value;
                    break;
                case 'W':
                    wayPointX -= value;
                    break;
                case 'L':
                    if (value == 90) {
                        int temp = wayPointY;
                        wayPointY = wayPointX;
                        wayPointX = -temp;
                    } else if (value == 180) {
                        wayPointX *= -1;
                        wayPointY *= -1;
                    } else if (value == 270) {
                        int temp = wayPointX;
                        wayPointX = wayPointY;
                        wayPointY = -temp;
                    }
                    break;
                case 'R':
                    if (value == 90) {
                        int temp = wayPointX;
                        wayPointX = wayPointY;
                        wayPointY = -temp;
                    } else if (value == 180) {
                        wayPointX *= -1;
                        wayPointY *= -1;
                    } else if (value == 270) {
                        int temp = wayPointY;
                        wayPointY = wayPointX;
                        wayPointX = -temp;
                    }
                    break;
                case 'F':
                    shipX += wayPointX * value;
                    shipY += wayPointY * value;
                    break;
            }
        }

        System.out.println(Math.round(Math.abs(shipX) + Math.abs(shipY)));
    }
}
