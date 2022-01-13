package baekjoon_prac;
//2293_동전1
import java.util.*;

public class boj2293 {
    static int[][] dp;

    static int getKindOf(int[] coins, int index, int goal, int sum) {
        int count = 0;

        if (sum == goal) {
            return 1;
        }
        if (sum > goal) {
            return 0;
        }
        if (index < 0) {
            return 0;
        }
        int added = 0;

        while (sum + added <= goal) {
            if (index > 0  && dp[index - 1][sum + added] != -1) {
                count += dp[index - 1][sum + added];
            } else {
                count += getKindOf(coins, index - 1, goal, sum + added);
            }
            added += coins[index];
        }
        dp[index][sum] = count;
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int goal = s.nextInt();
        int[] coins = new int[n];
        dp = new int[n][10001];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10001; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            coins[i] = s.nextInt();
        }
        System.out.println(getKindOf(coins, n - 1, goal, 0));
    }
}
