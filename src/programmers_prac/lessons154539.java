// 연습문제 > 뒤에 있는 큰 수 찾기
package programmers_prac;

import java.util.Stack;

public class lessons154539 {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < numbers.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
				continue;
			}

			int peekIndex = stack.peek();

			while (numbers[peekIndex] < numbers[i]) {
				int indexOfLowNumber = stack.pop();

				answer[indexOfLowNumber] = numbers[i];

				if (stack.isEmpty()) {
					break;
				}

				peekIndex = stack.peek();
			}

			stack.push(i);
		}

		for (int index : stack) {
			answer[index] = -1;
		}

		return answer;
	}
}
