// 연습문제 > 대충 만든 자판
package programmers_prac;

import java.util.Arrays;

public class lessons160586 {
    private static final int CANNOT_MAKE_STRING = -1;

    private int getMinimumPushTimes(String[] keymap, String target) {
        int totalPushTimes = 0;

        for (char key : target.toCharArray()) {
            int minimumPushTimes = Arrays.stream(keymap)
                    .mapToInt(keyInfo -> keyInfo.indexOf(key) + 1)
                    .filter(pushTime -> pushTime != 0)
                    .min()
                    .orElse(CANNOT_MAKE_STRING);

            if (minimumPushTimes == CANNOT_MAKE_STRING) {
                return CANNOT_MAKE_STRING;
            }

            totalPushTimes += minimumPushTimes;
        }

        return totalPushTimes;
    }

    public int[] solution(String[] keymap, String[] targets) {
        return Arrays.stream(targets)
                .mapToInt(target -> getMinimumPushTimes(keymap, target))
                .toArray();
    }
}
