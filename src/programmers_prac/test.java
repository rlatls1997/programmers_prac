package programmers_prac;

import java.util.Arrays;
import java.util.LinkedList;

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
		LinkedList<String> a = new LinkedList<String>();
		a.add("aaa");
		a.add("dfa");
		char [] ar = {'a', 'h', 'a', 'w','e','d','c'};
		Arrays.sort(ar);
		String temp = "";
		for(char e : ar) {
			temp += e;
		}
		System.out.println(ar[100]);
		String [] b = a.toArray(new String[a.size()]);

		for(String c : b) {
			System.out.println(c);
		}

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
