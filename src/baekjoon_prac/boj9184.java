package baekjoon_prac;
//9184
//신나는 함수 실행
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj9184 {
    static int w(int a, int b, int c, Map<String, Integer> dp) {
        String key = a + ", " + b + ", " + c;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            int result = w(20, 20, 20, dp);
            dp.put(key, result);
            return result;
        }
        if (a < b && b < c) {
            int result = w(a, b, c - 1, dp) + w(a, b - 1, c - 1, dp) - w(a, b - 1, c, dp);
            dp.put(key, result);
            return result;
        }
        int result = w(a - 1, b, c, dp) + w(a - 1, b - 1, c, dp) + w(a - 1, b, c - 1, dp) - w(a - 1, b - 1, c - 1, dp);
        dp.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, Integer> dp = new HashMap<>();
        while (true) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c, dp);
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
        }
    }
}
