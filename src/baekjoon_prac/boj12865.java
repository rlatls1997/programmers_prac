package baekjoon_prac;

import java.util.Scanner;
//12865_평범한 배낭
public class boj12865 {
    static int[][] values = new int[101][100001];

    static int getMaxValue(int[][] wNv, int i, int maxWeight, int totalWeight) {
        int max = 0;
        if (i < 0) {
            return 0;
        }
        if (maxWeight == totalWeight) {
            return 0;
        }
        if (values[i][totalWeight] != -1) {
            return values[i][totalWeight];
        }
        if (totalWeight + wNv[i][0] <= maxWeight) {
            max = Math.max(max, getMaxValue(wNv, i - 1, maxWeight, totalWeight + wNv[i][0]) + wNv[i][1]);
        }
        max = Math.max(max, getMaxValue(wNv, i - 1, maxWeight, totalWeight));
        values[i][totalWeight] = max;
        return max;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int maxWeight = s.nextInt();

        int[][] weightAndValue = new int[n][2];
        for (int i = 0; i < n; i++) {
            weightAndValue[i][0] = s.nextInt();
            weightAndValue[i][1] = s.nextInt();
        }
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 100001; j++) {
                values[i][j] = -1;
            }
        }
        System.out.println(getMaxValue(weightAndValue, n - 1, maxWeight, 0));
    }
}
