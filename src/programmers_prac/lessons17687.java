package programmers_prac;
//2018 KAKAO BLIND RECRUITMENT > [3차]n진수 게임
public class lessons17687 {
    public static String solution(int n, int t, int m, int p) throws Exception {
        String answer = "";
        String tmp = "";
        int i = 0;
        while (tmp.length() < m * t) {
            tmp += getN(i, n);
            i++;
        }
        for (i = 0; i < t; i++) {
            answer += tmp.charAt(p - 1);
            p += m;
        }
        return answer;
    }

    public static String getN(int i, int n) throws Exception {
        String converted = "";
        if (i == 0) {
            converted += 0;
        }
        while (i != 0) {
            int rest = i % n;
            if (rest < 10) {
                converted = rest + converted;
            } else {
                converted = overTen(rest) + converted;
            }
            i /= n;
        }
        return converted;
    }

    public static char overTen(int rest) throws Exception {
        if (rest == 10) {
            return 'A';
        } else if (rest == 11) {
            return 'B';
        } else if (rest == 12) {
            return 'C';
        } else if (rest == 13) {
            return 'D';
        } else if (rest == 14) {
            return 'E';
        } else if (rest == 15) {
            return 'F';
        } else {
            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        solution(16, 16, 2, 1);
    }
}
