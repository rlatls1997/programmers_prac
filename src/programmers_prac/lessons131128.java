package programmers_prac;

import java.util.HashMap;
import java.util.Map;

// 연습문제 > 숫자 작궁
public class lessons131128 {
	public String solution(String X, String Y) {
		Map<String, Integer> xCount = makeNumberCountMap(X);
		Map<String, Integer> yCount = makeNumberCountMap(Y);

		StringBuilder answer = new StringBuilder();

		for (int i = 9; i >= 0; i--) {
			String number = i + "";

			int count = Math.min(xCount.getOrDefault(number, 0), yCount.getOrDefault(number, 0));

			while (count > 0) {
				answer.append(number);
				count--;
			}
		}

		return answer.isEmpty() ? "-1" : answer.toString().startsWith("0") ? "0" : answer.toString();
	}

	private Map<String, Integer> makeNumberCountMap(String numbers) {
		Map<String, Integer> count = new HashMap<>();

		for (int i = 0; i < numbers.length(); i++) {
			String number = numbers.charAt(i) + "";

			count.put(number, count.getOrDefault(number, 0) + 1);
		}

		return count;
	}
}
