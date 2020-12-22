package dev.Dekay.aoc2020;

import java.util.Arrays;
import java.util.List;

public class Day11 extends AOCPuzzle {

    public Day11() {
        super("11");
    }

    @Override
    void solvePart1(List<String> input) {
        String[][] currentState;
        String[][] newState = new String[input.size()][input.get(0).length()];

        for (int i = 0; i < input.size(); i++) {
            newState[i] = input.get(i).split("");
        }

        do {
            currentState = Arrays.copyOf(newState, input.size());
            newState = new String[input.size()][input.get(0).length()];
            for (int i = 0; i < currentState.length; i++) {
                for (int j = 0; j < currentState[0].length; j++) {
                    int numOccupied = 0;
                    for (int xOff = -1; xOff <= 1; xOff++) {
                        for (int yOff = -1; yOff <= 1; yOff++) {

                            if (yOff == 0 && xOff == 0) {
                                continue;
                            }

                            try {
                                if (currentState[i + yOff][j + xOff].equals("#")) {
                                    numOccupied++;
                                }

                            } catch (IndexOutOfBoundsException ignored) {
                            }
                        }
                    }
                    if (currentState[i][j].equals("L")) {
                        if (numOccupied == 0) {
                            newState[i][j] = "#";
                        } else {
                            newState[i][j] = "L";
                        }
                    } else if (currentState[i][j].equals("#")) {
                        if (numOccupied >= 4) {
                            newState[i][j] = "L";
                        } else {
                            newState[i][j] = "#";
                        }
                    } else {
                        newState[i][j] = ".";
                    }
                }
            }
        } while (!arrayEquals(currentState, newState));

        System.out.println(countOccupied(newState));
    }

    @Override
    void solvePart2(List<String> input) {
        String[][] currentState;
        int cols = input.get(0).length();
        int rows = input.size();
        String[][] newState = new String[rows][cols];

        for (int i = 0; i < input.size(); i++) {
            newState[i] = input.get(i).split("");
        }

        do {
            currentState = Arrays.copyOf(newState, input.size());
            newState = new String[rows][cols];
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    int numOccupied = 0;
                    // Up
                    for (int yOff = y - 1; yOff >= 0; yOff--) {
                        if (currentState[yOff][x].equals("#")) {
                            numOccupied++;
                            break;
                        } else if (currentState[yOff][x].equals("L")) {
                            break;
                        }
                    }
                    // Up-Right
                    for (int yOff = y - 1, xOff = x + 1; yOff >= 0 && xOff < cols; yOff--, xOff++) {
                        if (currentState[yOff][xOff].equals("#")) {
                            numOccupied++;
                            break;
                        } else if (currentState[yOff][xOff].equals("L")) {
                            break;
                        }
                    }
                    // Right
                    for (int xOff = x + 1; xOff < cols;xOff++) {
                        if (currentState[y][xOff].equals("#")) {
                            numOccupied++;
                            break;
                        } else if (currentState[y][xOff].equals("L")) {
                            break;
                        }
                    }
                    // Down-Right
                    for (int yOff = y + 1, xOff = x + 1; yOff < rows && xOff < cols; yOff++, xOff++) {
                        if (currentState[yOff][xOff].equals("#")) {
                            numOccupied++;
                            break;
                        } else if (currentState[yOff][xOff].equals("L")) {
                            break;
                        }
                    }
                    // Down
                    for (int yOff = y + 1; yOff < rows; yOff++) {
                        if (currentState[yOff][x].equals("#")) {
                            numOccupied++;
                            break;
                        } else if (currentState[yOff][x].equals("L")) {
                            break;
                        }
                    }
                    // Down-Left
                    for (int yOff = y + 1, xOff = x - 1; yOff < rows && xOff >= 0; yOff++, xOff--) {
                        if (currentState[yOff][xOff].equals("#")) {
                            numOccupied++;
                            break;
                        } else if (currentState[yOff][xOff].equals("L")) {
                            break;
                        }
                    }
                    // Left
                    for (int xOff = x - 1; xOff >= 0; xOff--) {
                        if (currentState[y][xOff].equals("#")) {
                            numOccupied++;
                            break;
                        } else if (currentState[y][xOff].equals("L")) {
                            break;
                        }
                    }
                    // Up-Left
                    for (int yOff = y - 1, xOff = x - 1; yOff >= 0 && xOff >= 0; yOff--, xOff--) {
                        if (currentState[yOff][xOff].equals("#")) {
                            numOccupied++;
                            break;
                        } else if (currentState[yOff][xOff].equals("L")) {
                            break;
                        }
                    }


                    if (currentState[y][x].equals("L")) {
                        if (numOccupied == 0) {
                            newState[y][x] = "#";
                        } else {
                            newState[y][x] = "L";
                        }
                    } else if (currentState[y][x].equals("#")) {
                        if (numOccupied >= 5) {
                            newState[y][x] = "L";
                        } else {
                            newState[y][x] = "#";
                        }
                    } else {
                        newState[y][x] = ".";
                    }
                }
            }
        } while (!arrayEquals(currentState, newState));

        System.out.println(countOccupied(newState));
    }

    private boolean arrayEquals(String[][] a, String[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (!a[i][j].equals(b[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private int countOccupied(String[][] a) {
        int numOccupied = 0;
        for (String[] row : a) {
            for (String seat : row) {
                if (seat.equals("#")) {
                    numOccupied++;
                }
            }
        }
        return numOccupied;
    }
}
