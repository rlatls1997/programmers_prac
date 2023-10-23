package programmers_prac;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 연습문제 > 귤 고르기
public class lessons138476 {
	public int solution(int k, int[] tangerine) {
		int answer = 0;

		Map<Integer, Integer> tangerineCount = new HashMap<>();

		for (int tangerineType : tangerine) {
			tangerineCount.put(tangerineType, tangerineCount.getOrDefault(tangerineType, 0) + 1);
		}

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		priorityQueue.addAll(tangerineCount.values());

		while (k > 0) {
			int count = priorityQueue.poll();
			k -= count;

			answer++;
		}

		return answer;
	}
}
