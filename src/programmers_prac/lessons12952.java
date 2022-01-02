package programmers_prac;
//연습문제_N-Queen
import java.util.HashSet;
import java.util.Set;

public class lessons12952 {
    public static int solution(int n) {
        int[] board = new int[n];
        return getNumOfCases(board, 0, n);
    }

    static int getNumOfCases(int[] board, int depth, int n) {
        int numOfCases = 0;
        if (depth == n) {
            return 1;
        }
        Set<Integer> possiblePosition = new HashSet<>();
        for (int i = 0; i < n; i++) {
            possiblePosition.add(i);
        }

        for (int i = 0; i < depth; i++) {
            possiblePosition.remove(board[i]);
            possiblePosition.remove(board[i] + (depth - i));
            possiblePosition.remove(board[i] - (depth - i));
        }
        for (int position : possiblePosition) {
            board[depth] = position;
            numOfCases += getNumOfCases(board, depth + 1, n);
        }
        return numOfCases;
    }

    public static void main(String[] args) {
        int a = solution(5);
        System.out.println(a);

    }
}
