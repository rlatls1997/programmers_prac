package programmers_prac;
//연습문제
//이상한 문자 만들기
//도움말
public class lessons12930 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            boolean isEven = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    answer += s.charAt(i);
                    isEven = true;
                } else {
                    if (isEven) {
                        answer += (s.charAt(i) + "").toUpperCase();
                        isEven = false;
                    } else {
                        answer += (s.charAt(i) + "").toLowerCase();
                        isEven = true;
                    }
                }
            }
            return answer;
        }
    }
}