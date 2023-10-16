package baekjoon_prac;

import java.util.Scanner;
import java.util.Stack;

// 10773 > 제로
public class boj10773 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int k = s.nextInt();

		Stack<Integer> callStack = new Stack<>();

		for (int i = 0; i < k; i++) {
			int current = s.nextInt();

			if (current == 0) {
				callStack.pop();
			} else {
				callStack.push(current);
			}
		}

		long sum = callStack.stream()
			.mapToInt(Integer::intValue)
			.sum();

		System.out.print(sum);
	}
}
