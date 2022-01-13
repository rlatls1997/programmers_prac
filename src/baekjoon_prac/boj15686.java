package baekjoon_prac;
//15686_치킨 배달
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj15686 {

    static int getMinDist(List<int[]> chickenStore, List<int[]> house, List<Integer> picked, int index, int depth) {
        int min;
        if (depth == 0) {
            int sum = 0;
            for (int[] houseEl : house) {
                int minDist = Integer.MAX_VALUE;
                for (int pickedIndex : picked) {
                    int[] chickenEl = chickenStore.get(pickedIndex);
                    int distance = Math.abs(houseEl[0] - chickenEl[0]) + Math.abs(houseEl[1] - chickenEl[1]);
                    minDist = Math.min(minDist, distance);
                }
                sum += minDist;
            }
            return sum;
        }
        if (index == chickenStore.size()) {
            return Integer.MAX_VALUE;
        }
        picked.add(index);
        min = getMinDist(chickenStore, house, picked, index + 1, depth - 1);
        picked.remove((Integer) index);
        min = Math.min(min, getMinDist(chickenStore, house, picked, index + 1, depth));
        return min;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        List<int[]> chickenStore = new ArrayList<>();
        List<int[]> house = new ArrayList<>();
        List<Integer> picked = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int type = s.nextInt();
                if (type == 2) {
                    chickenStore.add(new int[]{i, j});
                }
                if (type == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }
        System.out.println(getMinDist(chickenStore, house, picked, 0, m));

    }
}
