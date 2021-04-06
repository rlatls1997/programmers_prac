package programmers_prac;

public class lessons12903 {
	public static String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder(s);

        //짝수
        if(sb.length() % 2 == 0) {
        	answer = sb.substring(sb.length()/2-1, sb.length()/2+1);

        }
        //홀수
        else {
        	answer = sb.substring(sb.length()/2, sb.length()/2+1);
        }
        return answer;
    }

	public static void main(String[] args) {
		solution("qwer");

	}

}
