package programmers_prac;
//2018 KAKAO BLIND RECRUITMENT
//[1차] 다트 게임
import java.util.*;

public class lessons17682 {
    public static int solution(String dartResult) {
        int answer = 0;
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('S', 1);
        hm.put('D', 2);
        hm.put('T', 3);

        String[] arr = new String[3];
        int[] multiple = new int[3];

        for (int i = 0; i < multiple.length; i++) {
            multiple[i] = 1;
        }

        String tmp = "" + dartResult.charAt(0);
        int index = 0;
        for (int i = 1; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) == '#') {
                multiple[index - 1] *= -1;
            } else if (dartResult.charAt(i) == '*') {
                multiple[index - 1] *= 2;
                if (index != 1) {
                    multiple[index - 2] *= 2;
                }
            } else {
                tmp += dartResult.charAt(i);
            }

            if (tmp.length() != 0 && Character.isDigit(tmp.charAt(0)) && Character.isAlphabetic(tmp.charAt(tmp.length() - 1))) {
                arr[index++] = tmp;
                tmp = "";
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i].substring(0, arr[i].length() - 1));
            char upper = arr[i].charAt(arr[i].length() - 1);

            answer += (int) Math.pow(num, hm.get(upper)) * multiple[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        solution("1D2S#10S");
    }
}
