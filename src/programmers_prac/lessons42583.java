//스택/큐 > 다리를 지나는 트럭
package programmers_prac;

import java.util.LinkedList;

public class lessons42583 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		// 대기중인 트럭 리스트
		LinkedList<Integer> wait = new LinkedList<Integer>();

		// 다리에 올라간 트럭 배열
		int[] bridge = new int[bridge_length];

		for (int i = 0; i < bridge.length; i++) {
			bridge[i] = 0;
		}

		// 다리를 지난 트럭 리스트
		LinkedList<Integer> clear = new LinkedList<Integer>();

		for (int a : truck_weights) {
			wait.add(a);
		}
		// 트럭 총 개수
		int num = wait.size();
		// 다리에 올라가있는 트럭 개수
		int allTrucks = 0;

		// 다리를 완전히 지난 트럭대수가 트럭 총 대수랑 같아질떄까지
		while (clear.size() < num) {

			// 시간 1초 경과
			answer++;

			// 다리에 올라가있는 트럭 총 무게
			int allWeight = 0;

			// 트럭 한칸씩 이동
			for (int i = 0; i < bridge.length; i++) {

				int truck = bridge[i];

				// 해당 위치에 트럭이 있을 경우
				if (truck != 0) {
					// 트럭의 총 무게에 추가
					allWeight += truck;

					// 다리의 맨 끝에 트럭이 있는 경우
					if (i == 0) {
						clear.add(truck);
						bridge[i] = 0;
						allWeight -= truck;
						allTrucks--;
					} else {
						int newLocation = i - 1;
						bridge[newLocation] = truck;
						bridge[i] = 0;
					}
				}

			}
			// 대기중인 트럭이 있다면
			if (wait.size() > 0) {
				int peek = wait.peek();

				// 제일 앞에서 대기중인 트럭을 검사
				if (peek + allWeight <= weight) {
					// 트럭을 다리에 올리기
					bridge[bridge.length - 1] = wait.poll();
					allWeight += peek;
					allTrucks++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 4, 5, 6 };
		System.out.println(solution(2, 10, arr));

	}

}
