package baekjoon_prac;
//1011
//Fly me to the Alpha Centauri
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj1011 {
    static int getMinimumMove(int x, int y) {
        int distance = y - x;
        int move = 1;
        int time = 0;

        while (distance / 2 >= move) {
            distance -= move * 2;
            time += 2;
            move++;
        }
        if (1 <= distance && distance <= move) {
            time++;
        } else if (move < distance) {
            time += 2;
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int x = s.nextInt();
            int y = s.nextInt();

            System.out.println(getMinimumMove(x, y));
        }
    }

    public static class boj1019 {
        public static int pickNinM(int index, int n, int m) {
            int total = 0;

            if (m == 0) {
                return 1;
            }
            if (index == n) {
                return 0;
            }

            total += pickNinM(index + 1, n, m - 1);
            total += pickNinM(index + 1, n, m);
            return total;
        }

        public static int getZero(int m, int digit, boolean isFirst) {
            if (digit == 1) {
                return 0;
            }
            if (digit == 2) {
                return (isFirst) ? m : m + 9;
            }
            int toMDigit = 0;
            int added = isFirst ? 0 : 1;
            for (int i = 1; i < digit - 1 + added; i++) {
                if (i == digit - 2 + added) {
                    toMDigit += (isFirst) ? 9 * i : digit - 1;
                    continue;
                }
                toMDigit += Math.pow(9, digit - 1 - i) * pickNinM(0, digit - 2 + added, i) * (i + added);
            }
            toMDigit += (isFirst) ? getZero(1, digit - 1, isFirst) : Math.pow(9, digit - 1);
            if (m == 1) {
                return toMDigit;
            }
            return (int) (toMDigit + Math.pow(10, digit - 2) * (m - 1) * (digit - 1));

        }

        public static void setCount(int[] count, int n) {
            boolean isFirst = true;
            int digit = (n + "").length();
            int div = (int) Math.pow(10, digit - 1);
            List<Integer> mList = new ArrayList<>();
            int emptyZero = 0;

            while (div >= 1) {
                if (n / div != 0) {
                    int m = n / div;
                    for (int i : mList) {
                        count[i] += m * div;
                    }
                    mList.add(m);

                    if (isFirst) {
                        count[0] += getZero(m, digit, isFirst);
                        count[0] += (digit != 1) ? digit - 2 : 0;
                    } else {
                        count[0] += getZero(m, digit, isFirst);
                        count[0] += emptyZero * m * div;
                    }
                    isFirst = false;
                    for (int i = 1; i < 10; i++) {
                        count[i] += m * (digit - 1) * (div / 10);
                    }
                    for (int i = 1; i < m; i++) {
                        count[i] += div;
                    }
                    count[m] += 1;
                } else {
                    emptyZero++;
                }
                n %= div;
                div /= 10;
                digit--;
            }
        }

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            int m = s.nextInt();
            int[] count2 = new int[10];
            setCount(count2, m);

            for (int i = 0; i < count2.length; i++) {
                System.out.print(count2[i]);
                if (i != count2.length - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
