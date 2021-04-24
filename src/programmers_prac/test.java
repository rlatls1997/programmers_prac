package programmers_prac;

import java.util.ArrayList;
import java.util.Arrays;

public class test {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		ArrayList<String []> b = new ArrayList<String []>();

		String [] query = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};

		Arrays.sort(query);
		for(String a : query) {
			System.out.println(a);
		}

		String nextToken = "260";
		int score = Integer.parseInt("200");
		System.out.println(Integer.parseInt(nextToken) < score);

	}
	 static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
	        if (r == 0) {

	            return;
	        }

	        if (depth == n) {
	            return;
	        }

	        visited[depth] = true;
	        comb(arr, visited, depth + 1, n, r - 1);

	        visited[depth] = false;
	        comb(arr, visited, depth + 1, n, r);
	    }

}
