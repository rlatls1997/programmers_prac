package programmers_prac;
//위클리챌린지 > 12주차

public class lessons87946 {
    public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        boolean[] isVisited = new boolean[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            int enterable = getEnterableDungeon(k, i, 0, dungeons, isVisited);
            if (enterable > answer) answer = enterable;
        }
        return answer;
    }

    public static int getEnterableDungeon(int k, int i,int depth, int[][] dungeons, boolean[] isVisited) {
        if (k < dungeons[i][0]) {
            return depth;
        }
        k -= dungeons[i][1];
        depth++;
        int max = depth;
        boolean[] newVisited = new boolean[isVisited.length];
        for (int j = 0; j < isVisited.length; j++) {
            newVisited[j] = isVisited[j];
        }
        newVisited[i] = true;
        for (int j = 0; j < dungeons.length; j++) {
            if (!newVisited[j]) {
                int enterable = getEnterableDungeon(k, j,depth, dungeons, newVisited);
                if (enterable > max) max = enterable;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] dungeons = {{80, 20,}, {50, 40}, {30, 10}};
        solution(80, dungeons);
    }
}
