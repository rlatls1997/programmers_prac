package programmers_prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

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
		int [] arr12 = new int[3];
		System.out.println(arr12[2]+"1");
		Set<Integer> [] hs = new Set[8];
		ArrayList<Integer> [] ae = new ArrayList[8];
		String temp = "";
		String qw = "(5+5)*10";
		System.out.println(Integer.parseInt(qw));
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
