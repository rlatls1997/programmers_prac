package programmers_prac;
// Summer/Winter Coding(~2018) > 예산
import java.util.Arrays;

public class lessons12982 {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if (budget < d[i]) {
                break;
            }
            budget -= d[i];
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 2, 5, 4};
        solution(a, 9);
    }
}
