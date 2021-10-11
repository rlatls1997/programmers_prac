package programmers_prac;
//위클리 챌린지 6주차_복서 정렬하기
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class lessons85002 {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<double[]> boxerInfos = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {
            //복서 번호, 복서몸무게, 승률, 자신보다 몸무게가 무거운 복서를 이긴 횟수,
            double[] boxerInfo = new double[4];
            double winTime = 0;
            double loseTime = 0;
            double winTimeHeavier = 0;
            double winningRate = 0;

            char[] matchRecord = head2head[i].toCharArray();
            for (int j = 0; j < matchRecord.length; j++) {
                char matchResult = matchRecord[j];
                if (matchResult == 'L') {
                    loseTime++;
                } else if (matchResult == 'W') {
                    winTime++;
                    if (weights[i] < weights[j]) {
                        winTimeHeavier++;
                    }
                }
            }
            winningRate = (winTime + loseTime == 0) ? 0 : winTime / (winTime + loseTime);
            boxerInfo[0] = i;
            boxerInfo[1] = weights[i];
            boxerInfo[2] = winningRate;
            boxerInfo[3] = winTimeHeavier;

            boxerInfos.add(boxerInfo);
        }

        boxerInfos.sort((o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[3] == o2[3]) {
                    if (o1[1] == o2[1]) {
                        return (o1[0] < o2[0]) ? -1 : 1;
                    } else if (o1[1] > o2[1]) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else if (o1[3] > o2[3]) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (o1[2] > o2[2]) {
                return -1;
            } else {
                return 1;
            }
        });

        for(int i = 0; i<boxerInfos.size(); i++){
            answer[i] = (int)boxerInfos.get(i)[0]+1;
        }
        return answer;
    }
}
