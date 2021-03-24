//힙 > 더 맵게
package programmers_prac;

import java.util.PriorityQueue;

public class lessons42626 {
	public static int solution(int[] scoville, int K) {
		int answer = 0;

		//우선순위큐, 루트노드가 최소값을 갖는 힙의 형태
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		//큐에 원소추가
		for(int a : scoville) {
			q.add(a);
		}
		//큐의 루트노드가 K이상이 되거나 원소가 하나밖에 남지 않을 때까지 반복
		while(q.size() > 1 && q.peek() < K) {
			int minimum1 = q.poll();
			int minimum2 = q.poll();

			q.add(minimum1 + minimum2 * 2);
			answer++;

		}

		//큐에 원소가 하나남았는데 그 원소가 K보다 작은 경우
		if(q.size() < 2 && q.peek() < K) {
			return -1;
		}
		return answer;
	}

	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 9, 10, 12};

		solution(arr, 7);

	}

}
