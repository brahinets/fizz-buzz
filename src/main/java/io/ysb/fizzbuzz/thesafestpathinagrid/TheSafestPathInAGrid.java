package io.ysb.fizzbuzz.thesafestpathinagrid;

import java.util.*;

public class TheSafestPathInAGrid {

    private static final int[][] TURNS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    private static final int NOT_VISITED = -1;
    private static final int VISITED = -2;
    private static final int THIEF = 1;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] safenessGrid = buildSafenessGrid(grid);

        PriorityQueue<int[]> safenessPriority = new PriorityQueue<>(
                (a, b) -> b[2] - a[2]
        );
        safenessPriority.offer(new int[]{0, 0, safenessGrid[0][0]});
        safenessGrid[0][0] = VISITED;

        while (!safenessPriority.isEmpty()) {
            int[] current = safenessPriority.poll();
            int x = current[0];
            int y = current[1];
            int safeness = current[2];

            if (x == grid.size() - 1 && y == grid.get(0).size() - 1) {
                return safeness;
            }

            for (int[] turn : TURNS) {
                int newX = x + turn[0];
                int newY = y + turn[1];

                if (inBounds(safenessGrid, newX, newY) && safenessGrid[newX][newY] != VISITED) {
                    safenessPriority.offer(new int[]{newX, newY, Math.min(safeness, safenessGrid[newX][newY])});
                    safenessGrid[newX][newY] = VISITED;
                }
            }
        }

        return -1;
    }

    private static int[][] buildSafenessGrid(List<List<Integer>> grid) {
        int[][] safenessGrid = matrixOf(NOT_VISITED, grid.size(), grid.get(0).size());
        Queue<int[]> toVisit = new LinkedList<>();

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if (grid.get(i).get(j) == THIEF) {
                    toVisit.offer(new int[]{i, j, 0});
                    safenessGrid[i][j] = 0;
                } else {
                    safenessGrid[i][j] = NOT_VISITED;
                }
            }
        }

        while (!toVisit.isEmpty()) {
            int[] current = toVisit.poll();
            int x = current[0];
            int y = current[1];
            int safeness = current[2];

            for (int[] turn : TURNS) {
                int newX = x + turn[0];
                int newY = y + turn[1];
                int newSafeness = safeness + 1;

                if (inBounds(safenessGrid, newX, newY) && safenessGrid[newX][newY] == NOT_VISITED) {
                    safenessGrid[newX][newY] = newSafeness;
                    toVisit.offer(new int[]{newX, newY, newSafeness});
                }
            }
        }

        return safenessGrid;
    }

    private static boolean inBounds(int[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }

    private static int[][] matrixOf(int val, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(matrix[i], val);
        }

        return matrix;

    }
}