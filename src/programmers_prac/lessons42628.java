//힙(Heap) > 이중우선순위큐
package programmers_prac;

import java.util.Collections;
import java.util.PriorityQueue;

public class lessons42628 {
	public static int[] solution(String[] operations) {
		int[] answer = { 0, 0 };
		// 오름차순 pq
		PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>();
		// 내림차순 pq
		PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (String operation : operations) {
			String[] operArr = operation.split(" ");
			//삽입명령어일 경우
			if (operArr[0].equals("I")) {
				pqMin.add(Integer.parseInt(operArr[1]));
				pqMax.add(Integer.parseInt(operArr[1]));
			}
			//삭제명령어일 경우
			else {
				if (!pqMin.isEmpty()) {
					//최댓값 삭제
					if (operArr[1].equals("1")) {
						int max = pqMax.poll();
						pqMin.remove(max);
					}
					//최솟값 삭제
					else {
						int min = pqMin.poll();
						pqMax.remove(min);
					}
				}
			}
		}
		if (!pqMin.isEmpty()) {
			answer[0] = pqMax.poll();
			answer[1] = pqMin.poll();
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] arr = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
		solution(arr);
	}
}