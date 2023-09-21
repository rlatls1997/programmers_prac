// 2023 KAKAO BLIND RECRUITMENT > 개인정보 수집 유효기간
package programmers_prac;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class lessons150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayInt = convertDateToDayInt(today);

        Map<String, Integer> termsMap = Arrays.stream(terms)
                .collect(Collectors.toMap(term -> term.split(" ")[0], term -> Integer.parseInt(term.split(" ")[1]) * 28));

        return IntStream.range(0, privacies.length)
                .filter(i -> convertDateToDayInt(privacies[i].split(" ")[0]) + termsMap.get(privacies[i].split(" ")[1]) <= todayInt)
                .map(i -> i + 1)
                .sorted()
                .toArray();
    }

    private int convertDateToDayInt(String date) {
        String[] dateInfo = date.split("\\.");
        return Integer.parseInt(dateInfo[0]) * 12 * 28 + Integer.parseInt(dateInfo[1]) * 28 + Integer.parseInt(dateInfo[2]);
    }
}
