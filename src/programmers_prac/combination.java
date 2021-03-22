//조합, n개의 숫자 중에서 r개의 수를 순서없이 뽑는 경우(순서가 없다는 말은 같은 집합에서 순서가 바뀌었다고 해서 다른 집합으로 처리하지 않음)
package programmers_prac;

import java.util.ArrayList;

public class combination {

	public static void main(String[] args) {
		int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        ArrayList<String> ar = new ArrayList<String>();



        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, visited, 0, n, i,ar);
        }
        for (String a : ar) {
            System.out.println(a);

        }
    }

    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r, ArrayList<String> ar) {

        if (r == 0) {
        	String str="";
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                	str += arr[i];
                    System.out.print(arr[i] + " ");
                }
            }
            ar.add(str);
            System.out.println();
            return ;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, ar);
            visited[i] = false;
        }
    }

    // 재귀 사용
    // 사용 예시 : comb(arr, visited, 0, n, r)
    static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
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

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
