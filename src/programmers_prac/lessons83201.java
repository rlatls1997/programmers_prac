//위클리챌린지 > 2주차_상호평가
package programmers_prac;

public class lessons83201 {
    public String solution(int[][] scores) {
        String answer = "";
        boolean[] isExcluded = new boolean[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int max = -1;
            int maxIndex = -1;
            int min = 101;
            int minIndex = -1;
            boolean isUnique = true;

            for (int j = 0; j < scores[i].length; j++) {
                if (scores[j][i] > max) {
                    max = scores[j][i];
                    maxIndex = j;
                }
                if (scores[j][i] < min) {
                    min = scores[j][i];
                    minIndex = j;
                }
            }
            if(i == maxIndex){
                int count = 0;
                for (int j = 0; j < scores[i].length; j++) {
                    if(scores[j][i] == max){
                        count++;
                    }
                }
                if(count > 1){
                    isUnique = false;
                }
            }
            if(i == minIndex){
                int count = 0;
                for (int j = 0; j < scores[i].length; j++) {
                    if(scores[j][i] == min){
                        count++;
                    }
                }
                if(count > 1){
                    isUnique = false;
                }
            }

            isExcluded[i] = false;
            if ((i == maxIndex || i == minIndex) && isUnique) {
                scores[i][i] = 0;
                isExcluded[i] = true;
            }
        }

        for (int i = 0; i < scores[0].length; i++) {
            double sum = 0;
            for (int j = 0; j < scores.length; j++) {
                sum += scores[j][i];
            }
            double average = (isExcluded[i]) ? sum / (scores.length - 1) : sum / scores.length;
            if (average >= 90) {
                answer += "A";
            } else if (average >= 80) {
                answer += "B";
            } else if (average >= 70) {
                answer += "C";
            } else if (average >= 50) {
                answer += "D";
            } else {
                answer += "F";
            }
        }
        return answer;
    }
}
