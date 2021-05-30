package programmers_prac;
//연습문제 > 시저암호

public class lessons12926 {
    public String solution(String s, int n) {
        String answer = "";

        for (char a : s.toCharArray()) {
            if (Character.isAlphabetic(a)) {
                if ((int) a >= 65 && (int) a <= 90) {
                    char c = (char) ((a + n) % 91);
                    answer += (c < 65) ? (char) (c + 65) : c;
                } else {
                    char c = (char) ((a + n) % 123);
                    answer += (c < 97) ? (char) (c + 97) : c;

                }
            } else {
                answer += a;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
