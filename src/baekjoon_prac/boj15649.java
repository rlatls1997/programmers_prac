package baekjoon_prac;

import java.util.Scanner;
//N과 M(1)
public class boj15649 {
    static void print(boolean[] visited, int[] picked, int count, int M) {
        if (count == M) {
            for (int num : picked) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[count] = i + 1;
                print(visited, picked, count + 1, M);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();
        boolean[] visited = new boolean[N];
        int[] picked = new int[M];
        print(visited, picked, 0, M);
    }
}
