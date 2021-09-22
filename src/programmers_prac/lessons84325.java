//위클리 챌린지 > 4주차_직업군 추천하기
package programmers_prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class lessons84325 {
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        String[][] tableInfo = new String[table.length][6];
        String[][] score = new String[table.length][2];
        Map<String, Integer> languagePref = new HashMap<>();

        for (int i = 0; i < languages.length; i++) {
            languagePref.put(languages[i], preference[i]);
        }

        for (int i = 0; i < table.length; i++) {
            tableInfo[i] = table[i].split(" ");
        }

        for (int i = 0; i < tableInfo.length; i++) {
            String[] scoreInfo = new String[2];
            int total = 0;
            String job = tableInfo[i][0];
            for (int j = 1; j < tableInfo[i].length; j++) {
                if (languagePref.containsKey(tableInfo[i][j])) {
                    total += languagePref.get(tableInfo[i][j]) * (6 - j);
                }
            }

            scoreInfo[0] = job;
            scoreInfo[1] = total + "";
            score[i] = scoreInfo;
        }
        Arrays.sort(score, (o1, o2) -> o1[0].compareTo(o2[0]));
        Arrays.sort(score, (o1, o2) -> Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]));
        answer = score[0][0];
        return answer;
    }

    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"JAVA", "JAVASCRIPT"};
        int [] preference = {7, 5};

        solution(table, languages, preference);
    }
}
