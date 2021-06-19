package programmers_prac;
//2021 KAKAO BLIND RECRUITMENT
//광고 삽입

public class lessons72414 {
    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int[] calledTime = new int[360000];

        for (String log : logs) {
            String[] splitLog = log.split("-");
            int startTime = getSec(splitLog[0]);
            int endTime = getSec(splitLog[1]);

            for (int i = startTime; i < endTime; i++) {
                calledTime[i]++;
            }
        }

        int adStart = 0;
        int adEnd = getSec(adv_time);
        int playTime = getSec(play_time);
        long rangeTotal = 0;

        for (int i = adStart; i < adEnd; i++) {
            rangeTotal += calledTime[i];
        }

        long max = rangeTotal;
        int minStartTime = 0;

        while (adEnd <= playTime) {
            rangeTotal = rangeTotal - calledTime[adStart++] + calledTime[adEnd++];
            if (rangeTotal > max) {
                max = rangeTotal;
                minStartTime = adStart;
            }
        }

        answer = getStringBySec(minStartTime);
        return answer;
    }

    public static int getSec(String log) {
        String[] times = log.split(":");
        return Integer.parseInt(times[0]) * 3600 + Integer.parseInt(times[1]) * 60 + Integer.parseInt(times[2]);
    }

    public static String getStringBySec(int sec) {
        String[] times = new String[3];
        times[0] = (sec / 3600) + "";
        times[1] = ((sec % 3600) / 60) + "";
        times[2] = (sec % 60) + "";

        for (int i = 0; i < times.length; i++) {
            if (times[i].length() == 1) {
                times[i] = "0" + times[i];
            }
        }
        return times[0] + ":" + times[1] + ":" + times[2];
    }


    public static void main(String[] args) {
        String[] arr = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        solution("99:59:59", "25:00:00", arr);
    }
}
