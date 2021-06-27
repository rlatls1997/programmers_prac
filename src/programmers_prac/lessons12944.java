package programmers_prac;
//연습문제
//평균 구하기
//도움말
public class lessons12944 {
    public double solution(int[] arr) {
        double answer = 0;
        for(int a : arr){
            answer += a;
        }
        return answer / arr.length;
    }
}
