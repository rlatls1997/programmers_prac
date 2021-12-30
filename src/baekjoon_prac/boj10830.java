package baekjoon_prac;
//10830
//행렬제곱
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj10830 {
    static int[][] mul(int[][] matrix1, int[][] matrix2) {
        int[][] matrix = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int sum = 0;
                for (int k = 0; k < matrix.length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                matrix[i][j] = sum % 1000;
            }
        }

        return matrix;
    }

    static int[][] getMatrix(int[][] matrix, long time, Map<Long, int[][]> dp) {
        if (dp.containsKey(time)) {
            return dp.get(time);
        }
        if (time == 1) {
            int[][] newMatrix = clone(matrix);
            dp.put(1L, newMatrix);
            return newMatrix;
        }
        if (time == 2) {
            int[][] matrix1 = clone(matrix);
            int[][] matrix2 = clone(matrix);

            int[][] newMatrix = mul(matrix1, matrix2);
            dp.put(2L, newMatrix);
            return newMatrix;
        }
        long halfTime = time / 2;
        int[][] newMatrix = mul(getMatrix(matrix, halfTime, dp), getMatrix(matrix, time - halfTime, dp));
        dp.put(time, newMatrix);
        return newMatrix;
    }

    static int[][] clone(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[i][j] % 1000;
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        long t = s.nextLong();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        Map<Long, int[][]> dp = new HashMap<>();
        int[][] newMatrix = getMatrix(matrix, t, dp);
        for (int[] row : newMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
