package swexpertacademy_prac;

import java.util.Scanner;

// 17642. 최대 조작 횟수
public class problem17642 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			long a = s.nextLong();
			long b = s.nextLong();

			long times = b - a == 1 ? -1 : (b - a) / 2;

			if (a > b) {
				times = -1;
			}

			System.out.println("#" + test_case + " " + times);
		}
	}

}
