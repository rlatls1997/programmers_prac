package baekjoon_prac;
//1005_ACM Craft
import java.util.*;

public class boj1005 {

    static int getMinimumTimeToBuildW(int[] timeToBuild, int[] totalTimeToBuild, Map<Integer, List<Integer>> rules, int w) {
        int timeToBuildW = timeToBuild[w - 1];
        int biggestTimeToBuildObject = Integer.MIN_VALUE;

        if (!rules.containsKey(w)) {
            return timeToBuildW;
        }
        List<Integer> objectsToBuild = rules.get(w);
        for (int object : objectsToBuild) {
            int timeToBuildObject;
            if (totalTimeToBuild[object - 1] != -1) {
                timeToBuildObject = totalTimeToBuild[object - 1];
            } else {
                timeToBuildObject = getMinimumTimeToBuildW(timeToBuild, totalTimeToBuild, rules, object);
                totalTimeToBuild[object - 1] = timeToBuildObject;
            }
            biggestTimeToBuildObject = Math.max(biggestTimeToBuildObject, timeToBuildObject);
        }
        return biggestTimeToBuildObject + timeToBuildW;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();

            int[] timeToBuild = new int[n];
            int[] totalTimeToBuild = new int[n];
            Map<Integer, List<Integer>> rules = new HashMap<>();

            for (int j = 0; j < n; j++) {
                timeToBuild[j] = s.nextInt();
                totalTimeToBuild[j] = -1;
            }
            for (int j = 0; j < k; j++) {
                int x = s.nextInt();
                int y = s.nextInt();

                List<Integer> objectsToBuild = rules.getOrDefault(y, new LinkedList<>());
                objectsToBuild.add(x);
                rules.put(y, objectsToBuild);
            }

            int w = s.nextInt();
            System.out.println(getMinimumTimeToBuildW(timeToBuild, totalTimeToBuild, rules, w));

        }
    }
}
