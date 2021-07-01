package programmers_prac;
//연습문제
//정수 내림차순으로 배치하기

import java.util.Arrays;

public class lessons12933 {

    public long solution(long n) {
        String tmp = "";
        char[] charArr = (n + "").toCharArray();
        Arrays.sort(charArr);
        for (int i = charArr.length - 1; i >= 0; i--) {
            tmp += charArr[i];
        }
        return Long.parseLong(tmp);
    }

}
