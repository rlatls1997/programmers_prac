package programmers_prac;
//연습문제
//서울에서 김서방 찾기

public class lessons12919 {
    public String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }
}