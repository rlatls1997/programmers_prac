package programmers_prac;
//위클리 챌린지_아이템 줍기
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lessons87694 {
    static int[][] nextCoordinate = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        Set<String> coordinateCanMove = new HashSet<>();

        for (int[] rect : rectangle) {
            for (int i = 0; i < rect.length; i++) {
                rect[i] = rect[i] * 2;
            }
        }
        characterX = characterX * 2;
        characterY = characterY * 2;
        itemX = itemX * 2;
        itemY = itemY * 2;

        for (int[] rect : rectangle) {
            List<int[]> borderCoordinate = getBorderCoordinate(rect);

            borderCoordinate.forEach((coordinate) -> {
                boolean isOnBorder = true;
                int xOfBorderCoordinate = coordinate[0];
                int yOfBorderCoordinate = coordinate[1];
                for (int[] rectToCheck : rectangle) {
                    int minX = rectToCheck[0];
                    int maxX = rectToCheck[2];
                    int minY = rectToCheck[1];
                    int maxY = rectToCheck[3];
                    if ((xOfBorderCoordinate > minX && xOfBorderCoordinate < maxX) &&
                            (yOfBorderCoordinate > minY && yOfBorderCoordinate < maxY)) {
                        isOnBorder = false;
                        break;
                    }
                }
                if (isOnBorder) {
                    coordinateCanMove.add(xOfBorderCoordinate + ", " + yOfBorderCoordinate);
                }
            });
        }

        for (int[] next : nextCoordinate) {
            int nextX = characterX + next[0];
            int nextY = characterY + next[1];

            if (coordinateCanMove.contains(nextX + ", " + nextY)) {
                Set<String> isVisited = new HashSet<>();
                isVisited.add(characterX + ", " + characterY);
                int length = getLengthToItem(coordinateCanMove, isVisited, nextX, nextY, itemX, itemY);
                if (length < answer) answer = length;
            }

        }

        return answer / 2;
    }

    public static List<int[]> getBorderCoordinate(int[] rect) {
        List<int[]> borderCoordinate = new ArrayList<>();
        int x1 = rect[0];
        int y1 = rect[1];
        int x2 = rect[2];
        int y2 = rect[3];

        for (int i = x1; i <= x2; i++) {
            int[] coordinate1 = {i, y1};
            int[] coordinate2 = {i, y2};
            borderCoordinate.add(coordinate1);
            borderCoordinate.add(coordinate2);
        }
        for (int i = y1; i <= y2; i++) {
            int[] coordinate1 = {x1, i};
            int[] coordinate2 = {x2, i};
            borderCoordinate.add(coordinate1);
            borderCoordinate.add(coordinate2);
        }
        return borderCoordinate;
    }

    public static int getLengthToItem(Set<String> coordinateCanMove, Set<String> isVisited,
                                      int characterX, int characterY, int itemX, int itemY) {
        int lengthToItem = 1;
        isVisited.add(characterX + ", " + characterY);
        if (characterX == itemX && characterY == itemY) {
            return lengthToItem;
        }
        for (int[] next : nextCoordinate) {
            int nextX = characterX + next[0];
            int nextY = characterY + next[1];

            if (coordinateCanMove.contains(nextX + ", " + nextY) && !isVisited.contains(nextX + ", " + nextY)) {
                lengthToItem += getLengthToItem(coordinateCanMove, isVisited, nextX, nextY, itemX, itemY);
            }
        }
        return lengthToItem;
    }

    public static void main(String[] args) {
        int[][] rect = {{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}};
        int[][] test = {{1, 1, 3, 3}, {2, 2, 4, 4}};
        int a = solution(rect, 1, 4, 6, 3);
//        int b = solution(test, 1, 1, 4, 4);
//        System.out.println(b);
        System.out.println(a);
    }
}
