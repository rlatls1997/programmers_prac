package programmers_prac;
//2018 KAKAO BLIND RECRUITMENT
//[1차] 셔틀버스

import java.util.*;

public class lessons17678 {
    public static String solution(int n, int t, int m, String[] timetable) {
        LinkedList<int[]> busList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int[] bus = new int[2];
            bus[0] = 540 + t * i;
            bus[1] = m;
            busList.add(bus);
        }

        Arrays.sort(timetable, Comparator.naturalOrder());
        int index = 0;

        while (index < timetable.length) {
            int personArrivedTime = convertTimeToInteger(timetable[index]);

            while (personArrivedTime > busList.get(0)[0]) {
                busList.poll();
                if (busList.isEmpty()) {
                    return convertIntegerToTime(540 + (n - 1) * t);
                }
            }

            busList.get(0)[1]--;
            if (busList.get(0)[1] == 0) {
                busList.poll();
            }
            if (busList.isEmpty()) {
                return convertIntegerToTime(personArrivedTime - 1);
            }
            index++;
        }
        return convertIntegerToTime(busList.getLast()[0]);
    }

    public static int convertTimeToInteger(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }

    public static String convertIntegerToTime(int time) {
        String hours = (time / 60 < 10) ? "0" + (time / 60) : "" + time / 60;
        String minutes = (time % 60 < 10) ? "0" + (time % 60) : "" + time % 60;
        return hours + ":" + minutes;
    }

    public static void main(String[] args) {
        String[] arr = {"23:59"};
        solution(1, 1, 1, arr);
    }
}