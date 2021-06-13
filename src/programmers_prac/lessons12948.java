package programmers_prac;
// 연습문제 > 핸드폰 번호 가리기
public class lessons12948 {
    public String solution(String phone_number) {
        String answer = "";
        for(int i = 0; i<phone_number.length()-4; i++){
            answer += '*';
        }
        answer += phone_number.substring(phone_number.length()-5);
        return answer;
    }
}
