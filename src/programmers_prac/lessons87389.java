package programmers_prac;
//나머지가 1이 되는 수 찾기
public class lessons87389 {
    public int solution(int n) {
        int answer = 0;
        int rest = 0;
        while(rest != 1){
            answer++;
            rest = n % answer;
        }
        return answer;
    }
}
