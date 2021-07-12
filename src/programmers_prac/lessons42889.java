package programmers_prac;
//2019 KAKAO BLIND RECRUITMENT
//실패율
import java.util.Arrays;
import java.util.Comparator;

public class lessons42889 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[][] failed = new double[N][2];
        for (int i = 0; i < N; i++) {
            double[] stageInfo = new double[2];
            int stage = i + 1;
            int totalStageChallenger = 0;
            int failedChallenger = 0;
            for (int challenger : stages) {
                if (challenger >= stage) {
                    totalStageChallenger++;
                    if (challenger == stage) {
                        failedChallenger++;
                    }
                }
            }
            stageInfo[0] = stage;
            stageInfo[1] = (totalStageChallenger != 0) ? failedChallenger / (double) totalStageChallenger : 0;
            failed[i] = stageInfo;
        }
        Arrays.sort(failed, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1]) {
                    if (o1[0] < o2[0]) {
                        return -1;
                    } else
                        return 1;
                } else if (o1[1] > o2[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failed[i][0];
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
