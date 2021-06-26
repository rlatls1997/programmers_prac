package programmers_prac;
//연습문제
//자릿수 더하기
//도움말
public class lessons12931 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 0; i<(n+"").toCharArray().length; i++){
            answer += Integer.parseInt((n+"").toCharArray()[i]+"");
        }
        return answer;
    }
}
