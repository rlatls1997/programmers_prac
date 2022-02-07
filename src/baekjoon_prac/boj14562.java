package baekjoon_prac;

import java.util.Scanner;

//14562_태권왕
public class boj14562 {
    public static int getMinKickTime(int myScore, int enemyScore, int kickTime) {
        if (myScore == enemyScore) {
            return kickTime;
        }
        if (myScore > enemyScore) {
            return Integer.MAX_VALUE;
        }
        int strongKick = getMinKickTime(myScore * 2, enemyScore + 3, kickTime + 1);
        int normalKick = getMinKickTime(myScore + 1, enemyScore, kickTime + 1);

        return Math.min(strongKick, normalKick);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int C = s.nextInt();
        for (int i = 0; i < C; i++) {
            int S = s.nextInt();
            int T = s.nextInt();
            int minKickTime = getMinKickTime(S, T, 0);
            System.out.println(minKickTime);
        }
    }
}
