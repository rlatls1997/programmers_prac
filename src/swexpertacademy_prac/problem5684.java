package swexpertacademy_prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 5684. [Professional] 운동
public class problem5684 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();

			int[][] map = new int[N + 1][N + 1];

			for (int j = 0; j < M; j++) {
				int s = scanner.nextInt();
				int e = scanner.nextInt();
				int c = scanner.nextInt();

				map[s][e] = c;
			}

			int minimumDistanceOfCycle = Integer.MAX_VALUE;

			for (int j = 1; j <= N; j++) {
				minimumDistanceOfCycle = Math.min(minimumDistanceOfCycle, getMinimumDistanceOfCycle(map, j));
			}

			int result = minimumDistanceOfCycle == Integer.MAX_VALUE ? -1 : minimumDistanceOfCycle;
			System.out.println("#" + i + " " + result);
		}
	}

	private static int getMinimumDistanceOfCycle(int[][] map, int start) {
		boolean[] visited = new boolean[map.length];
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {start, 0});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 1; i < map.length; i++) {
				if (map[current[0]][i] > 0 && !visited[i]) {
					visited[i] = true;
					queue.add(new int[] {i, current[1] + map[current[0]][i]});
				}

				if (map[current[0]][i] > 0 && i == start) {
					return current[1] + map[current[0]][i];
				}
			}

		}

		return Integer.MAX_VALUE;
	}
}
