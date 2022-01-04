package baekjoon_prac;
//1022
//소용돌이 예쁘게 출력하기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1022 {
    static int getValue(int i, int j) {
        char direction = getDirection(i, j);
        if (direction == 'R') {
            return (int) (Math.pow(2 * j - 1, 2) + Math.abs(i - j));
        }
        if (direction == 'U') {
            return (int) (Math.pow(2 * i + 1, 2) + Math.abs(2 * -i) + Math.abs(j + i));
        }
        if (direction == 'L') {
            return (int) (Math.pow(2 * j + 1, 2) + 2 * Math.abs(2 * -j) + Math.abs(i - j));
        }
        return (int) (Math.pow(2 * i - 1, 2) + 3 * Math.abs(2 * i) + Math.abs(i + j));
    }

    static char getDirection(int i, int j) {
        int absI = Math.abs(i);
        int absJ = Math.abs(j);

        if (i > 0 && i == j) {
            return 'D';
        }
        if (absI > absJ) {
            return (i < 0) ? 'U' : 'D';
        }
        return (j < 0) ? 'L' : 'R';
    }

    static String getPaddedString(int num, int length) {
        String paddedString = num + "";

        while (paddedString.length() < length) {
            paddedString = " " + paddedString;
        }
        return paddedString;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] infosString = reader.readLine().split(" ");
        int[] infos = new int[infosString.length];

        for (int i = 0; i < infos.length; i++) {
            infos[i] = Integer.parseInt(infosString[i]);
        }

        int biggestNum = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i += 2) {
            for (int j = 1; j < 4; j += 2) {
                int num = getValue(infos[i], infos[j]);
                biggestNum = Math.max(biggestNum, num);
            }
        }
        int lengthOfMax = (biggestNum + "").length();

        for (int i = infos[0]; i <= infos[2]; i++) {
            for (int j = infos[1]; j <= infos[3]; j++) {
                System.out.print(getPaddedString(getValue(i, j), lengthOfMax));
                if (j != infos[3]) {
                    System.out.print(" ");
                }
            }
            if (i != infos[2]) {
                System.out.println();
            }
        }
    }
}

