package programmers_prac;
//월간 코드 챌린지 시즌1 > 3진법 뒤집기
public class lessons68935 {
    public static int solution(int n) {
        int answer = 0;
        String to3 = "";

        int maxIndex = 0;
        while (Math.pow(3, ++maxIndex) <= n) {
        }

        while (n != 0) {
            maxIndex--;
            if (Math.pow(3, maxIndex) > n) {
                to3 += 0;
                continue;
            } else {
                int a = n / (int) Math.pow(3, maxIndex);
                to3 += a;
                n -= a * Math.pow(3, maxIndex);
            }
        }
        String reverse = "";
        for (char c : to3.toCharArray()) {
            reverse = c + reverse;
        }
        char[] reverseChar = reverse.toCharArray();
        for (int i = 0; i < reverseChar.length; i++) {
            answer += Math.pow(3, reverseChar.length - 1 - i) * Integer.parseInt(reverseChar[i] + "");
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(125);
    }
}
