package programmers_prac;

import java.util.HashSet;

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
		StringBuilder sb = new StringBuilder("aa");
		HashSet<Node> hs = new HashSet<Node>();
		char f = 'Z';
		System.out.println((int)f);

		int ab = Integer.parseInt("011");
		System.out.println(ab);
		Node b = new Node(1,2);
		Node a = new Node(1,2);
		hs.add(a);
		hs.add(b);
		for(Node c : hs)
		System.out.println(5+""+-5);

		sb.delete(0, 1);

		char [] arr = {'*', '+', '-'};

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
