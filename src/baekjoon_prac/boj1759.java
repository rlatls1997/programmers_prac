package baekjoon_prac;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj1759 {
    static void setPassword(Set<String> set, char[] alpha, int index, int depth, String result) {
        if (depth == 0) {
            boolean containM = false;
            int countJ = 0;
            for (char c : result.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    containM = true;
                } else {
                    countJ++;
                }
            }
            if (containM && countJ >= 2) {
                set.add(result);
            }
            return;
        }
        if (index == alpha.length) {
            return;
        }
        setPassword(set, alpha, index + 1, depth - 1, result + alpha[index]);
        setPassword(set, alpha, index + 1, depth, result);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        int L = s.nextInt();
        int C = s.nextInt();


        char[] alpha = new char[C];

        for (int i = 0; i < C; i++) {
            alpha[i] = s.next().charAt(0);
        }
        Arrays.sort(alpha);
        setPassword(set, alpha, 0, L, "");

        set.stream().sorted().forEach(el -> {
            System.out.println(el);
        });
    }
}