package programmers_prac;

//연습문제_최대공약수와 최소공배수
public class lessons12940 {
    public static int[] solution(int n, int m) {
        int gcd = getGreatestCommonDivisor(n, m);
        int lcm = (m * n) / gcd;
        return new int[]{gcd, lcm};
    }

    public static int getGreatestCommonDivisor(int n, int m) {
        int gcd = 1;
        for (int i = Math.min(n, m); i > 0; i--) {
            if (n % i == 0 && m % i == 0) {
                return i;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        solution(3, 12);
    }
}
