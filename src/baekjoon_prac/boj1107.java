package baekjoon_prac;
//리모컨
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj1107 {
    public static int count(int channel, int destination, int[] normalBtn, String btn) {
        int minCount = Integer.MAX_VALUE;
        if ((destination + "").length() == btn.length()) {
            int big = Integer.parseInt(btn);
            int bigCount = btn.length() + Math.abs(destination - big);
            minCount = Math.min(bigCount, minCount);

            for (int i = 0; i < normalBtn.length; i++) {
                int bigger = Integer.parseInt(btn + normalBtn[i]);
                int biggerCount = btn.length() + 1 + Math.abs(destination - bigger);

                minCount = Math.min(biggerCount, minCount);
            }

            if (btn.length() == 1) {
                return Math.min(minCount, Math.abs(destination - channel));
            }
            int small = Integer.parseInt(btn.substring(1));
            int smallCount = btn.length() - 1 + Math.abs(destination - small);
            minCount = Math.min(smallCount, minCount);

            return Math.min(minCount, Math.abs(destination - channel));
        }
        if (channel == destination) {
            return 0;
        }
        if (normalBtn.length == 0) {
            return Math.abs(destination - channel);
        } else {
            for (int i = 0; i < normalBtn.length; i++) {
                minCount = Math.min(count(channel, destination, normalBtn, btn + normalBtn[i]), minCount);
            }
        }
        return minCount;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int channel = 100;
        int destination = s.nextInt();
        int n = s.nextInt();
        Set<Integer> brokenBtn = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int broken = s.nextInt();
            brokenBtn.add(broken);
        }
        int[] normalBtn = new int[10 - brokenBtn.size()];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (!brokenBtn.contains(i)) {
                normalBtn[index] = i;
                index++;
            }
        }
        System.out.println(count(channel, destination, normalBtn, ""));
    }
}
