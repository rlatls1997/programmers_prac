//gabia 코테 3
package programmers_prac;

import java.util.LinkedList;

public class lessons_gabia3 {
	public static class Node {
		int i;
		int time;

		public Node(int i, int time) {
			this.i = i;
			this.time = time;
		}

		public int getId() {
			return this.i;
		}

		public int getTime() {
			return this.time;
		}

		public void setTimeMinusOne() {
			this.time--;
		}
	}

	public static int[] solution(int N, int[] coffee_times) {
		int[] answer = {};
		answer = new int[coffee_times.length];

		// 커피 추출 순서와 시간을 가진 Node의 linkedList생성
		LinkedList<Node> al = new LinkedList<Node>();
		for (int i = 0; i < coffee_times.length; i++) {
			Node node = new Node(i + 1, coffee_times[i]);
			al.add(node);
		}

		// 커피추출구가 1개인 경우
		if (N == 1) {
			for (int i = 0; i < answer.length; i++) {
				answer[i] = i + 1;
			}
			return answer;
		}
		// 커피추출구 LinkedList
		LinkedList<Node> coffeeMachine = new LinkedList<Node>();

		// 커피추출구가 2개 이상인 경우
		int index = 0;
		while (index < answer.length) {

			while (coffeeMachine.size() <= N - 1) {
				coffeeMachine.addFirst(al.poll());
			}
			// 만들어지기까지의 시간 1씩 깎기
			for (Node a : coffeeMachine) {
				if (a != null) {
					a.setTimeMinusOne();
				}
			}

			// 시간 검사해서 0초이면 제거하고 index위치에 넣기
			int check = coffeeMachine.size() - 1;
			while (check >= 0) {
				if (coffeeMachine.get(check) != null) {
					if (coffeeMachine.get(check).getTime() == 0) {
						answer[index] = coffeeMachine.get(check).getId();
						coffeeMachine.remove(check);

						index++;
					}
				}
				check--;
			}
		}
		for (int a : answer) {
			System.out.print(" " + a);
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 2, 5, 3};
		solution(3, arr);
	}

}
