package programmers_prac;
//연습문제 > 두 정수 사이의 합
public class lessons12912 {
    public long solution(int a, int b) {
        return (long) (a + b) * (Math.abs(a - b) + 1) / 2;
    }

    public static void main(String[] args) {
    }
}