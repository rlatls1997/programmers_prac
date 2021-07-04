package programmers_prac;
//연습문제
//하노이의 탑
import java.util.ArrayList;
import java.util.List;

public class lessons12946 {
    public int[][] solution(int n) {
        int[][] answer;
        List<int[]> moved = new ArrayList<>();
        hanoi(n, 1, 2, 3, moved);
        answer = new int[moved.size()][2];
        for (int i = 0; i < moved.size(); i++) {
            answer[i] = moved.get(i);
        }
        return answer;
    }

    public void hanoi(int n, int start, int mid, int end, List<int[]> moved) {
        int[] move = new int[2];
        move[0] = start;
        move[1] = end;
        if (n == 1) {
            moved.add(move);
        } else {
            hanoi(n - 1, start, end, mid, moved);
            moved.add(move);
            hanoi(n - 1, mid, start, end, moved);
        }
    }

    public static void main(String[] args) {
    }
}
