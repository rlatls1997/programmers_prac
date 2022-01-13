package baekjoon_prac;

import java.util.Scanner;

class boj1027 {
    static int getBuildingsOnRightCanSee(int idx, int[] building) {
        int count = 0;
        int rightIdx = idx + 1;
        int pivotBuilding = building[idx];
        double slope = Double.MIN_VALUE;
        while (rightIdx < building.length) {
            int curBuilding = building[rightIdx];
            double curSlope = getSlope(rightIdx, curBuilding, idx, pivotBuilding, true);

            if (rightIdx == idx + 1) {
                count++;
                slope = curSlope;
            } else if (curBuilding > slope * (rightIdx - idx) + pivotBuilding) {
                count++;
                slope = curSlope;
            }
            rightIdx++;
        }
        return count;
    }

    static int getBuildingsOnLeftCanSee(int idx, int[] building) {
        int count = 0;
        int leftIdx = idx - 1;
        int pivotBuilding = building[idx];
        double slope = Double.MIN_VALUE;
        while (leftIdx >= 0) {
            int curBuilding = building[leftIdx];
            double curSlope = getSlope(leftIdx, curBuilding, idx, pivotBuilding, false);
            if (leftIdx == idx - 1) {
                count++;
                slope = curSlope;
            } else if (curBuilding > slope * (idx - leftIdx) + pivotBuilding) {
                count++;
                slope = curSlope;
            }
            leftIdx--;
        }
        return count;
    }

    static double getSlope(int x1, int y1, int x2, int y2, boolean isRight) {
        double slope;
        if (y2 > y1) {
            slope = (double) (y2 - y1) / (x1 - x2);
        } else {
            slope = (double) (y2 - y1) / (x1 - x2);
        }
        return isRight ? -slope : slope;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int n = s.nextInt();
        int[] building = new int[n];
        for (int i = 0; i < n; i++) {
            building[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int nums = getBuildingsOnLeftCanSee(i, building) + getBuildingsOnRightCanSee(i, building);
            max = Math.max(max, nums);
        }
        System.out.println(max);
    }

}