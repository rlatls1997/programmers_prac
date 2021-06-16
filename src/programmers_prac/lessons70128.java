package programmers_prac;
//월간 코드 챌린지 시즌1
//내적

public class lessons70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i<a.length; i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}
