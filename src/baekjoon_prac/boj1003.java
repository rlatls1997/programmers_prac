package baekjoon_prac;
//1003_피보나치 함수
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj1003 {
    static void fibo(int n, int[] count, Map<Integer, int[]> dp) {
        if (dp.containsKey(n)) {
            int[] value = dp.get(n);
            count[0] += value[0];
            count[1] += value[1];
            return;
        }
        fibo(n - 1, count, dp);
        fibo(n - 2, count, dp);
        if (!dp.containsKey(n)) {
            int[] value = {count[0], count[1]};
            dp.put(n, value);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Map<Integer, int[]> dp = new HashMap<>();
        dp.put(0, new int[]{1, 0});
        dp.put(1, new int[]{0, 1});
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int[] count = new int[2];
            fibo(num, count, dp);
            System.out.println(count[0] + " " + count[1]);
        }
    }
}
