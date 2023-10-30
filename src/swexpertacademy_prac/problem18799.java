package swexpertacademy_prac;

import java.util.Scanner;

// 18799. 평균의 평균
public class problem18799 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] group = new int[n];

			for (int i = 0; i < n; i++) {
				group[i] = sc.nextInt();
			}

			double sumOfAverages = 0;

			for (int i = 1; i <= n; i++) {
				sumOfAverages += getAverageOfSet(group, 0, i, 0, 0);
			}

			double averageOfAverages = sumOfAverages / (Math.pow(2, n) - 1);
			String formattedAverageOfAverages = averageOfAverages % 1 == 0.0 ? String.format("%.0f", averageOfAverages) : "" + averageOfAverages;

			System.out.println("#" + test_case + " " + formattedAverageOfAverages);
		}

	}

	private static double getAverageOfSet(int[] group, int i, int n, int r, int sum) {
		double total = 0;

		if (n == r) {
			return sum / (double)r;
		}

		if (i == group.length) {
			return 0;
		}

		total += getAverageOfSet(group, i + 1, n, r + 1, sum + group[i]);
		total += getAverageOfSet(group, i + 1, n, r, sum);

		return total;
	}
}
