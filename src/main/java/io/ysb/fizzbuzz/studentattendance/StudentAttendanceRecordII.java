package io.ysb.fizzbuzz.studentattendance;

public class StudentAttendanceRecordII {
    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        int[][][] memo = arrayOf(matrixOf(0, 2, 3), n + 1);
        memo[0][0][0] = 1;
        buildPossibleStates(n, memo);

        int result = 0;
        for (int totalAbsence = 0; totalAbsence < 2; totalAbsence++) {
            for (int totalLate = 0; totalLate < 3; totalLate++) {
                result = (result + memo[n][totalAbsence][totalLate]) % MOD;
            }
        }

        return result;
    }

    private void buildPossibleStates(int n, int[][][] memo) {
        for (int i = 1; i <= n; i++) {
            for (int totalAbsence = 0; totalAbsence < 2; totalAbsence++) {
                for (int totalLate = 0; totalLate < 3; totalLate++) {
                    memo[i][totalAbsence][0] = (memo[i][totalAbsence][0] + memo[i - 1][totalAbsence][totalLate]) % MOD;

                    if (totalLate < 2) {
                        memo[i][totalAbsence][totalLate + 1] = (memo[i][totalAbsence][totalLate + 1] + memo[i - 1][totalAbsence][totalLate]) % MOD;
                    }

                    if (totalAbsence < 1) {
                        memo[i][totalAbsence + 1][0] = (memo[i][totalAbsence + 1][0] + memo[i - 1][totalAbsence][totalLate]) % MOD;
                    }
                }
            }
        }
    }

    private int[][][] arrayOf(int[][] val, int size) {
        int[][][] array = new int[size][][];
        for (int i = 0; i < size; i++) {
            array[i] = matrixOf(0, 2, 3);
        }
        return array;
    }

    private int[][] matrixOf(int val, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = val;
            }
        }
        return matrix;
    }

}