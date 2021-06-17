package programmers_prac;
//2018 KAKAO BLIND RECRUITMENT
//[1차] 추석 트래픽
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lessons17676 {
    public static int solution(String[] lines) {
        int answer = 0;
        List<int[]> eachTime = new ArrayList<>();
        Set<Integer> isAlreadyCalled = new HashSet<>();

        for (int i = 0; i < lines.length; i++) {
            int[] times = getStartTimeAndEndTime(lines[i]);
            eachTime.add(times);
        }
        int max = Integer.MIN_VALUE;
        for (int[] line : eachTime) {
            for (int i = 0; i < 1000; i++) {
                int endTime = line[0] + i;
                if (!isAlreadyCalled.contains(endTime)) {
                    int withStartTime = getIncludedWork(eachTime, endTime - 999, endTime);
                    max = (withStartTime > max) ? withStartTime : max;
                    isAlreadyCalled.add(endTime);
                }
                endTime = line[1] + i;
                if (!isAlreadyCalled.contains(endTime)) {
                    int withEndTime = getIncludedWork(eachTime, endTime - 999, endTime);
                    max = (withEndTime > max) ? withEndTime : max;
                    isAlreadyCalled.add(endTime);
                }
            }
        }
        answer = max;
        return answer;
    }

    public static int getIncludedWork(List<int[]> eachTime, int startTime, int endTime) {
        int num = 0;

        for (int i = eachTime.size() - 1; i >= 0; i--) {
            int[] line = eachTime.get(i);
            if (line[1] < startTime) {
                break;
            }
            if (line[1] < startTime || line[0] > endTime) {
                continue;
            }
            num++;
        }
        return num;
    }

    public static int[] getStartTimeAndEndTime(String line) {
        int[] time = new int[2];

        String[] stringsTmp = line.split(" ");
        String finishedTimeString = stringsTmp[1];
        double requiredTime = Double.parseDouble(stringsTmp[2].substring(0, stringsTmp[2].length() - 1));

        char[] finishedTimeChar = finishedTimeString.toCharArray();

        String finishedTimeTmp = "";
        String timeTmp = "";
        String underDot = "";
        int index = 0;
        int doubleDotCalledTime = 0;
        for (int i = 0; i < finishedTimeChar.length; i++) {
            if (finishedTimeChar[i] == '.') {
                finishedTimeTmp = "" + (Integer.parseInt(finishedTimeTmp) + Integer.parseInt(timeTmp));
                index = i;
                break;
            }
            if (Character.isDigit(finishedTimeChar[i])) {
                timeTmp += finishedTimeChar[i];
            }
            if (finishedTimeChar[i] == ':') {
                if (doubleDotCalledTime == 0) {
                    finishedTimeTmp += Integer.parseInt(timeTmp) * 3600;
                    timeTmp = "";
                } else if (doubleDotCalledTime == 1) {
                    finishedTimeTmp = "" + (Integer.parseInt(finishedTimeTmp) + Integer.parseInt(timeTmp) * 60);
                    timeTmp = "";
                }
                doubleDotCalledTime++;
            }
        }
        underDot = finishedTimeString.substring(index);
        finishedTimeTmp += underDot;

        double finishedTime = Double.parseDouble(finishedTimeTmp);

        time[0] = ((int) ((finishedTime - requiredTime) * 1000) + 1);
        time[1] = (int) (finishedTime * 1000);

        return time;
    }

    public static void main(String[] args) {
        String[] arr = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        solution(arr);
    }
}
