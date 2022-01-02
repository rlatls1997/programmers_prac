package baekjoon_prac;

import java.util.Scanner;

public class boj9663 {
    static int getNumOfCases(int[] board, int depth, int n) {
        int numOfCases = 0;
        if (depth == n) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            boolean canPosition = true;
            for (int j = 0; j < depth; j++) {
                if (i == board[j] || i == board[j] + depth - j || i == board[j] + j - depth) {
                    canPosition = false;
                    break;
                }
            }
            if (!canPosition) {
                continue;
            }
            board[depth] = i;
            numOfCases += getNumOfCases(board, depth + 1, n);
        }
        return numOfCases;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] board = new int[n];

        System.out.println(getNumOfCases(board, 0, n));
    }
}
