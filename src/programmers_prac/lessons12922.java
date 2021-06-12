package programmers_prac;
//연습문제 > 수박수박수박수박수박수?
public class lessons12922 {
    public String solution(int n) {
        String answer = "";
        for(int i = 1; i<=n; i++){
            answer += (i % 2 == 0)? '박' : '수';
        }
        return answer;
    }

}
