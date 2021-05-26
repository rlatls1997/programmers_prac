package programmers_prac;
//2018 KAKAO BLIND RECRUITMENT > [3차]압축
import java.util.*;

public class lessons17684 {
    public static int[] solution(String msg) {
        int[] answer = {};
        char[] msgChar = msg.toUpperCase().toCharArray();
        List<Integer> print = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();

        int index = 1;
        while (index <= 26) {
            dic.put((char) (index + 64) + "", index++);
        }
        int i;
        for (i = 0; i < msgChar.length; ) {
            String nowInput = msgChar[i++] + "";
            while (dic.containsKey(nowInput)) {
                if (i >= msgChar.length) {
                    break;
                } else {
                    nowInput += msgChar[i++];
                }
            }
            if (i == msgChar.length && dic.containsKey(nowInput)) {
                print.add(dic.get(nowInput));
            } else {
                print.add(dic.get(nowInput.substring(0, nowInput.length() - 1)));
                if (i == msgChar.length) {
                    print.add(dic.get(nowInput.substring(nowInput.length() - 1)));
                }
            }
            if (i < msgChar.length) {
                i--;
            }
            dic.put(nowInput, index++);
        }
        answer = new int[print.size()];
        for (int j = 0; j < print.size(); j++) {
            answer[j] = print.get(j);
        }
        return answer;
    }

    public static void main(String[] args) {
        solution("TOBEORNOTTOBEORTOBEORNOT");
    }
}
