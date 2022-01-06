package baekjoon_prac;
//1005_ACM Craft
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1005 {

    static int getMinimumTimeToBuildW(int[] timeToBuild, int[] totalTimeToBuild, Map<Integer, List<Integer>> rules, int w) {
        int timeToBuildW = timeToBuild[w - 1];
        int biggestTimeToBuildObject = Integer.MIN_VALUE;

        if (!rules.containsKey(w)) {
            return timeToBuildW;
        }
        List<Integer> objectsToBuild = rules.get(w);
        for (int object : objectsToBuild) {
            int timeToBuildObject;
            if (totalTimeToBuild[object - 1] != -1) {
                timeToBuildObject = totalTimeToBuild[object - 1];
            } else {
                timeToBuildObject = getMinimumTimeToBuildW(timeToBuild, totalTimeToBuild, rules, object);
                totalTimeToBuild[object - 1] = timeToBuildObject;
            }
            biggestTimeToBuildObject = Math.max(biggestTimeToBuildObject, timeToBuildObject);
        }
        return biggestTimeToBuildObject + timeToBuildW;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();

            int[] timeToBuild = new int[n];
            int[] totalTimeToBuild = new int[n];
            Map<Integer, List<Integer>> rules = new HashMap<>();

            for (int j = 0; j < n; j++) {
                timeToBuild[j] = s.nextInt();
                totalTimeToBuild[j] = -1;
            }
            for (int j = 0; j < k; j++) {
                int x = s.nextInt();
                int y = s.nextInt();

                List<Integer> objectsToBuild = rules.getOrDefault(y, new LinkedList<>());
                objectsToBuild.add(x);
                rules.put(y, objectsToBuild);
            }

            int w = s.nextInt();
            System.out.println(getMinimumTimeToBuildW(timeToBuild, totalTimeToBuild, rules, w));

        }
    }

    public static class boj2580 {
        public static boolean checkSell(int[][] matrix, int col, int row, int number) {
            //delete col and row
            for (int i = 0; i < 9; i++) {
                if (number == matrix[i][row] || number == matrix[col][i]) {
                    return false;
                }
            }
            //delete cell
            for (int i = (col / 3) * 3; i < (col / 3) * 3 + 3; i++) {
                for (int j = (row / 3) * 3; j < (row / 3) * 3 + 3; j++) {
                    if (number == matrix[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean setSudoku(int[][] matrix, List<int[]> zeroPositions, int depth) {
            if (depth == zeroPositions.size()) {
                return true;
            }

            int col = zeroPositions.get(depth)[0];
            int row = zeroPositions.get(depth)[1];

            for (int i = 1; i < 10; i++) {
                if (checkSell(matrix, col, row, i)) {
                    matrix[col][row] = i;
                    boolean result = setSudoku(matrix, zeroPositions, depth + 1);
                    if (result) {
                        return true;
                    }
                    matrix[col][row] = 0;
                }
            }
            return false;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int[][] matrix = new int[9][9];
            List<int[]> zeroPositions = new ArrayList<>();

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());

                int index = 0;
                while (st.hasMoreTokens()) {
                    matrix[i][index] = Integer.parseInt(st.nextToken());
                    if (matrix[i][index] == 0) {
                        zeroPositions.add(new int[]{i, index});
                    }
                    index++;
                }
            }
            setSudoku(matrix, zeroPositions, 0);

            for (int[] row : matrix) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
    }
}
