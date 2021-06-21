package programmers_prac;
//연습문제
//정수 제곱근 판별
public class lessons12934 {
    public long solution(long n) {
        return (Math.sqrt(n) % 1.0 == 0) ? (long) Math.pow(Math.sqrt(n) + 1, 2) : -1;
    }
}
