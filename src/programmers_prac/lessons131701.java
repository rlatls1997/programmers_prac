package programmers_prac;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 연습문제
// 연속 부분 수열 합의 개수
public class lessons131701 {
	public int solution(int[] elements) {
		Set<Integer> numberSet = new HashSet<>();

		for (int i = 0; i < elements.length; i++) {
			int sum = Arrays.stream(elements, 0, i + 1).sum();
			numberSet.add(sum);

			for (int j = 0; j < elements.length; j++) {
				sum = sum - elements[j] + elements[(i + j + 1) % elements.length];
				numberSet.add(sum);
			}
		}

		return numberSet.size();
	}
}
