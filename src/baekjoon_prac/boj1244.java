package baekjoon_prac;
//1244_스위치 켜고 끄기

import java.util.Scanner;

public class boj1244 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt(); // 스위치 개수

		int[] switches = new int[N];

		for (int i = 0; i < N; i++) {
			switches[i] = s.nextInt();
		}

		int M = s.nextInt(); // 학생 수

		for (int i = 0; i < M; i++) {
			int gender = s.nextInt();
			int switchNumber = s.nextInt();

			convertSwitches(switches, gender, switchNumber);
		}

		for (int i = 0; i < N; i++) {
			System.out.print(switches[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}

	public static void convertSwitches(int[] switches, int gender, int switchNumber) {
		// 남학생일 경우
		if (gender == 1) {
			int targetSwitchNumber = switchNumber;

			while (targetSwitchNumber <= switches.length) {
				switches[targetSwitchNumber - 1] = Math.abs(switches[targetSwitchNumber - 1] - 1);
				targetSwitchNumber += switchNumber;
			}
		}

		// 여학생일 경우
		if (gender == 2) {
			int distance = 0;
			int switchNumberIndex = switchNumber - 1;

			while (switchNumberIndex - distance - 1 >= 0 && switchNumberIndex + distance + 1 < switches.length) {
				if (switches[switchNumberIndex - distance - 1] != switches[switchNumberIndex + distance + 1]) {
					break;
				}

				distance++;
			}

			for (int i = switchNumberIndex - distance; i <= switchNumberIndex + distance; i++) {
				switches[i] = Math.abs(switches[i] - 1);
			}
		}
	}
}
