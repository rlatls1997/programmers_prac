//완전탐색 > 소수찾기
package programmers_prac;

import java.util.HashSet;

public class lessons42839 {
	public static int solution(String numbers) {
		int answer = 0;
		StringBuilder sb = new StringBuilder(numbers);
		char[] ch = new char[sb.length()];
		HashSet<Integer> hs = new HashSet<Integer>();

		char[] output = new char[sb.length()];
		boolean[] visited = new boolean[sb.length()];

		for (int i = 0; i < sb.length(); i++) {
			ch[i] = sb.charAt(i);
		}

		for (int i = 1; i < ch.length+1; i++) {
			perm(ch, output, visited, 0, ch.length, i, hs);
		}
		answer = hs.size();
		return answer;
	}

	// 사전순으로 순열 구하기
	// 사용 예시: perm(arr, output, visited, 0, n, 3);
	static void perm(char[] arr, char[] output, boolean[] visited, int depth, int n, int r,
			HashSet<Integer> hs) {
		if (depth == r) {
			print(output, r, hs);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r, hs);
				visited[i] = false;
			}
		}
	}

	// 배열 출력
    static void print(char[] arr, int r, HashSet<Integer> hs) {
    	String a = "";
        for (int i = 0; i < r; i++)
        	a += arr[i];
        int b = Integer.parseInt(a);
        if(b%2 != 0 || b == 2) {
        	boolean isOk = true;
        	if(b == 1)
        		isOk = false;
        	for(int i = 2; i<b; i++) {
        		if(b%i == 0) {
        			isOk = false;
        			break;
        		}
        	}
        	if(isOk) {
        		hs.add(b);
        	}
        }
    }

	public static void main(String[] args) {
		solution("24");

	}

}
