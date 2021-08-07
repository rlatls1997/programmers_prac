package programmers_prac;

public class lessons82612 {
    public long solution(int price, int money, int count) {
        long answer = -(money - (2 * price + (long) (count - 1) * price) * count / 2);
        return (answer < 0) ? 0 : answer;
    }
}
