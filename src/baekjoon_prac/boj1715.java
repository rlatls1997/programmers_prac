package baekjoon_prac;

import java.util.PriorityQueue;
import java.util.Scanner;

// 1715 > 카드 정렬하기
public class boj1715 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int number = s.nextInt();
			pq.add(number);
		}

		int totalSum = 0;

		while (pq.size() >= 2) {
			int small1st = pq.poll();
			int small2nd = pq.poll();

			int sum = small1st + small2nd;
			totalSum += sum;

			pq.add(sum);
		}

		System.out.print(totalSum);
	}
}
