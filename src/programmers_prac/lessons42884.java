package programmers_prac;
//탐욕법(Greedy)
//단속카메라
import java.util.Arrays;

public class lessons42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        int cam = Integer.MIN_VALUE;

        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        for (int i = 0; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];

            if (start > cam) {
                answer++;
                cam = end;
            }
        }
        return answer;
    }

}
