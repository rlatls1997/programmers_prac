//완전탐색 > 모의고사
package programmers_prac;

import java.util.Arrays;
import java.util.stream.IntStream;

public class lessons42840_1 {
    private static final int[][] SOLUTION_METHODS = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

    public int[] solution(int[] answers) {
        int[] correctAnswerCount = new int[SOLUTION_METHODS.length];

        for (int i = 0; i < answers.length; i++) {
            int correctAnswer = answers[i];

            for (int j = 0; j < SOLUTION_METHODS.length; j++) {
                int solutionAnswer = SOLUTION_METHODS[j][i % SOLUTION_METHODS[j].length];

                if (solutionAnswer == correctAnswer) {
                    correctAnswerCount[j]++;
                }
            }
        }

        int max = Arrays.stream(correctAnswerCount).max().getAsInt();
        return IntStream.range(0, correctAnswerCount.length)
                .filter(i -> correctAnswerCount[i] == max)
                .map(i -> i + 1)
                .sorted()
                .toArray();
    }
}
