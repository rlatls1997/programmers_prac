package programmers_prac;

import java.util.Stack;

// 연습문제 > 택배상자
public class lessons131704 {
	public int solution(int[] order) {
		int answer = 0;

		Stack<Integer> boxStack = new Stack<>();

		int boxOfConveyer = 1;

		for (int orderBox : order) {
			if (!boxStack.isEmpty() && orderBox == boxStack.peek()) {
				boxStack.pop();
				answer++;
				continue;
			}

			if (orderBox >= boxOfConveyer) {
				while (orderBox >= boxOfConveyer) {
					if (orderBox == boxOfConveyer) {
						answer++;
					} else {
						boxStack.push(boxOfConveyer);
					}

					boxOfConveyer++;
				}

				continue;
			}

			break;
		}

		return answer;
	}
}
