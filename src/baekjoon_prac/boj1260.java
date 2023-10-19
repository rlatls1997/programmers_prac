package baekjoon_prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1260 > DFS와 BFS
public class boj1260 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt(); // 정점의 개수 N
		int M = s.nextInt(); // 간선의 개수 M
		int V = s.nextInt() - 1; // 시작할 정점의 번호 V

		int[][] graph = new int[N][N];

		for (int i = 0; i < M; i++) {
			int vertex1 = s.nextInt() - 1;
			int vertex2 = s.nextInt() - 1;

			graph[vertex1][vertex2] = 1;
			graph[vertex2][vertex1] = 1;
		}

		boolean[] visited1 = new boolean[N];
		printDfs(V, graph, visited1);

		System.out.println();

		boolean[] visited2 = new boolean[N];
		printBfs(V, graph, visited2);
	}

	private static void printDfs(int vertex, int[][] graph, boolean[] visited) {
		visited[vertex] = true;
		System.out.print((vertex + 1) + " ");

		for (int i = 0; i < graph.length; i++) {
			if (graph[vertex][i] == 1 && !visited[i]) {
				printDfs(i, graph, visited);
			}
		}
	}

	private static void printBfs(int vertex, int[][] graph, boolean[] visited) {
		visited[vertex] = true;
		System.out.print((vertex + 1) + " ");
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);

		while (!queue.isEmpty()) {
			int target = queue.poll();

			for (int i = 0; i < graph.length; i++) {
				if (graph[target][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					System.out.print(i + 1 + " ");
				}
			}
		}
	}
}
