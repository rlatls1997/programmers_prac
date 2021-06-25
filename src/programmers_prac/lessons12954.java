package programmers_prac;
//연습문제
//x만큼 간격이 있는 n개의 숫자
public class lessons12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int index = 0;
        long now = x;
        while(index < n){
            answer[index] = now;
            now += x;
            index++;
        }
        return answer;
    }
}
