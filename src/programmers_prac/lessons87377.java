package programmers_prac;
//위클리챌린지_10주차 교점에 별 만들기
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lessons87377 {
    public static String[] solution(int[][] line) {
        String[] answer = {};
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;

        Map<Long, ArrayList<Long>> coordinates = new HashMap<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                double mother = (long) line[i][0] * (long) line[j][1] - (long) line[i][1] * (long) line[j][0];
                if (i != j && mother != 0) {
                    double x = ((long) line[i][1] * (long) line[j][2] - (long) line[i][2] * (long) line[j][1]) / mother;
                    double y = ((long) line[i][2] * (long) line[j][0] - (long) line[i][0] * (long) line[j][2]) / mother;

                    if (x % 1 == 0 && y % 1 == 0) {
                        long longX = (long) x;
                        long longY = (long) y;
                        if (!coordinates.containsKey(longY)) {
                            coordinates.put(longY, new ArrayList<>());
                        }
                        ArrayList<Long> xCoordinates = coordinates.get(longY);
                        if (!xCoordinates.contains(longX)) {
                            xCoordinates.add(longX);
                        }
                        maxX = (longX > maxX) ? longX : maxX;
                        minX = (longX < minX) ? longX : minX;
                        maxY = (longY > maxY) ? longY : maxY;
                        minY = (longY < minY) ? longY : minY;
                    }
                }
            }
        }
        int xLength = (answer.length == 1) ? 1 : (int)(maxX - minX) + 1;
        int yLength = (answer.length == 1) ? 1 : (int)(maxY - minY) + 1;
        answer = new String[yLength];
        for (int i = 0; i < answer.length; i++) {
            String layer = "";
            long y = maxY - i;

            if (!coordinates.containsKey(y)) {
                for (int j = 0; j < xLength; j++) {
                    layer += ".";
                }
            } else {
                ArrayList<Long> xCoordinates = coordinates.get(y);
                for (int j = 0; j < xLength; j++) {
                    long x = minX + j;
                    layer += (xCoordinates.contains(x)) ? "*" : ".";
                }
            }
            answer[i] = layer;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        solution(a);
    }
}
