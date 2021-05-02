//깊이/너비 우선 탐색(DFS/BFS) > 네트워크
package programmers_prac;

public class lessons43162 {
	public int solution(int n, int[][] computers) {
		int answer = 0;

		int[] saved = new int[computers.length];

		for (int i = 0; i < computers.length; i++) {
			if (saved[i] == 0) {
				answer++;
				insert(i, computers,saved);
			}
		}
		return answer;
	}

	public static void insert(int i, int [][] computers, int [] saved) {
		for(int j = 0; j<computers.length; j++) {
			if(computers[i][j] == 1 && saved[j] != 1) {
				saved[j] = 1;
				insert(j, computers, saved);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("a");

	}

}
