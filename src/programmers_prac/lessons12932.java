package programmers_prac;
//연습문제
//자연수 뒤집어 배열로 만들기

public class lessons12932 {
    public int[] solution(long n) {
        int[] answer = new int[(n + "").length()];
        for (int i = 0; i < (n + "").length(); i++) {
            answer[i] = Integer.parseInt((n + "").charAt((n + "").length() - i - 1) + "");
        }
        return answer;
    }
}
