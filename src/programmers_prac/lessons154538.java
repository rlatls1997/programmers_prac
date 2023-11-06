package programmers_prac;

import java.util.LinkedList;
import java.util.Queue;

// 연습문제
// 숫자 변환하기
public class lessons154538 {
	public int solution(int x, int y, int n) {
		return getMinimumCalculationTime(x, y, n);
	}

	public static class NumberAndTimes {
		private final float number;
		private final int times;

		public NumberAndTimes(float number, int times) {
			this.number = number;
			this.times = times;
		}

		public int getTimes() {
			return times;
		}

		public float getNumber() {
			return number;
		}
	}

	public int getMinimumCalculationTime(float x, float y, int n) {
		Queue<NumberAndTimes> queue = new LinkedList<>();
		queue.add(new NumberAndTimes(y, 0));

		while (!queue.isEmpty()) {
			NumberAndTimes current = queue.poll();
			float currentNumber = current.getNumber();
			int currentTimes = current.getTimes();

			if (currentNumber == x) {
				return currentTimes;
			}

			if (currentNumber < x || currentNumber % 1 != 0) {
				continue;
			}

			queue.add(new NumberAndTimes(currentNumber - n, currentTimes + 1));
			queue.add(new NumberAndTimes(currentNumber / 2, currentTimes + 1));
			queue.add(new NumberAndTimes(currentNumber / 3, currentTimes + 1));
		}

		return -1;
	}
}
