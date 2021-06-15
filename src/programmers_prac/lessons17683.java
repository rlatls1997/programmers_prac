package programmers_prac;
//2018 KAKAO BLIND RECRUITMENT > [3차]방금그곡

public class lessons17683 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = Integer.MIN_VALUE;

        for (String music : musicinfos) {
            String[] musicArr = music.split(",");
            int runtime = totalPlayMinutes(musicArr[0], musicArr[1]);

            if (runtime > maxPlayTime) {
                String totalMelody = getTotalMelody(musicArr[3], runtime);
                if (containMelody(m, totalMelody)) {
                    answer = musicArr[2];
                    maxPlayTime = runtime;
                }
            }
        }
        return answer;
    }

    public static boolean containMelody(String m, String totalMelody) {
        boolean contain = false;
        int start = 0;
        int end = m.length();

        while (end <= totalMelody.length()) {
            String substring = totalMelody.substring(start, end);

            if (end == totalMelody.length()) {
                if (substring.equals(m)) {
                    contain = true;
                    break;
                }
            } else {
                if (substring.equals(m) && totalMelody.charAt(end) != '#') {
                    contain = true;
                    break;
                }
            }
            start++;
            end++;
        }
        return contain;
    }

    public static int totalPlayMinutes(String start, String end) {
        int hours = Integer.parseInt(end.substring(0, 2))
                - Integer.parseInt(start.substring(0, 2));
        int minutes = Integer.parseInt(end.substring(3)) - Integer.parseInt(start.substring(3));

        return hours * 60 + minutes;
    }

    public static String getTotalMelody(String melody, int play) {
        String totalMelody = "";
        int melodyPlayTime = melody.length();


        for (int i = 0; i < melody.length(); i++) {
            if (melody.charAt(i) == '#') {
                melodyPlayTime--;
            }
        }

        for (int i = 0; i < play / melodyPlayTime; i++) {
            totalMelody += melody;
        }

        int rest = play % melodyPlayTime;
        for (int i = 0; i < rest; i++) {
            totalMelody += melody.charAt(i);
            if (melody.charAt(i) == '#') {
                rest++;
            }
        }
        return totalMelody;
    }

    public static void main(String[] args) {
        String[] a = {"10:00,10:01,AAA,AC#", "00:00,00:02,BBB,AC#", "01:00,01:59,CCC,AABB"};
        solution("AC#", a);
    }
}
