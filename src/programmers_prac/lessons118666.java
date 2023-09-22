// 2022 KAKAO TECH INTERNSHIP > 성격 유형 검사하기
package programmers_prac;

import java.util.HashMap;
import java.util.Map;

public class lessons118666 {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> score = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            String type = choices[i] < 4 ? Character.toString(survey[i].charAt(0)) : Character.toString(survey[i].charAt(1));
            score.put(type, score.getOrDefault(type, 0) + Math.abs(choices[i] - 4));
        }

        return (score.getOrDefault("T", 0) > score.getOrDefault("R", 0) ? "T" : "R")
                + (score.getOrDefault("F", 0) > score.getOrDefault("C", 0) ? "F" : "C")
                + (score.getOrDefault("M", 0) > score.getOrDefault("J", 0) ? "M" : "J")
                + (score.getOrDefault("N", 0) > score.getOrDefault("A", 0) ? "N" : "A");
    }
}
