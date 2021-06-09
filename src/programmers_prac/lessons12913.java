package programmers_prac;
// 연습문제 > 땅따먹기

public class lessons12913 {
    static int solution(int[][] land) {
        int[][] landArr = new int[land.length][4];

        for (int i = 0; i < landArr[0].length; i++) {
            landArr[0][i] = land[0][i];
        }
        for (int j = 1; j < land.length; j++) {
            for (int i = 0; i < land[j].length; i++) {
                landArr[j][i] = land[j][i] + getMax(landArr[j - 1], i);
            }
        }
        return getMax(landArr[land.length - 1], -1);
    }

    static int getMax(int[] beforeLayer, int except) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < beforeLayer.length; i++) {
            if (i != except && beforeLayer[i] > max) {
                max = beforeLayer[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 0}, {2, 2, 2, 8}, {4, 3, 2, 100}, {1, 1, 1, 1}};
        solution(arr);
    }
}
