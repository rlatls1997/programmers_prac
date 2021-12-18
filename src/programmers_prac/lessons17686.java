package programmers_prac;

import java.util.Arrays;
// 2018 KAKAO BLIND RECRUITMENT_[3차]파일명 정렬
public class lessons17686 {
    public static String[] solution(String[] files) {
        sortArr(files);
        return files.clone();
    }

    public static void sortArr(String[] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            String[] dividedO1 = getDividedString(o1);
            String[] dividedO2 = getDividedString(o2);

            int compared = dividedO1[0].compareToIgnoreCase(dividedO2[0]);

            if (compared == 0) {
                return Integer.parseInt(dividedO1[1]) - Integer.parseInt(dividedO2[1]);
            } else {
                return compared;
            }
        });
    }

    public static String[] getDividedString(String file) {
        String head = "";
        String number = "";
        String tail = "";

        int cur = 0;
        int countNum = 0;

        for (int j = 0; j < file.length(); j++) {
            if (Character.isDigit(file.charAt(j))) {
                cur = 1;
            } else {
                if (cur == 1) {
                    cur = 2;
                }
            }
            if (cur == 0) {
                head += file.charAt(j);
            }
            if (cur == 1) {
                number += file.charAt(j);
                countNum++;
                if (countNum == 5) {
                    cur = 2;
                }
            }
            if (cur == 2) {
                tail += file.substring(j);
                break;
            }
        }
        return new String[]{head, number, tail};
    }


    public static void main(String[] args) {
        String[] arr1 = {"muzi1.txt1", "MUZI1.txt", "muzi001.txt", "muzi1.TXT"};
        String[] arr = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat",
                "A-10 Thunderbo1111lt II"};
        solution(arr1);
    }
}
