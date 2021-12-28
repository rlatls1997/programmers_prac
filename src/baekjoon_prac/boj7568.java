package baekjoon_prac;
//덩치
import java.util.Scanner;

public class boj7568 {
    public static int getRanking(int[][] infos, int index) {
        int count = 1;
        int weight = infos[index][0];
        int height = infos[index][1];

        for (int i = 0; i < infos.length; i++) {
            if (weight < infos[i][0] && height < infos[i][1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[][] arr = new int[n][2];
        int[] answerArr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(getRanking(arr, i) + " ");
        }
    }
}
