package programmers_prac;
// 2017 카카오코드 예선 > 카카오프렌즈 컬러링북
import java.util.HashSet;
import java.util.Set;

public class lessons1829 {
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Set<String> calledCell = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0) {
                    if (calledCell.contains(i + ", " + j)) {
                        continue;
                    } else {
                        int[] areaCellCount = {0};
                        numberOfArea++;
                        checkArea(i, j, picture, calledCell, picture[i][j], areaCellCount);
                        maxSizeOfOneArea = (areaCellCount[0] > maxSizeOfOneArea) ? areaCellCount[0] : maxSizeOfOneArea;
                    }
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void checkArea(int i, int j, int[][] picture, Set<String> calledCell, int color, int[] areaCellCount) {
        if (i < 0 || j < 0 || i >= picture.length || j >= picture[i].length
                || picture[i][j] != color || calledCell.contains(i + ", " + j)) {
            return;
        }
        if (!calledCell.contains(i + ", " + j)) {
            calledCell.add(i + ", " + j);
            areaCellCount[0]++;
        }
        int[] nextCell = {-1, 0, 1, 0, 0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            if (!calledCell.contains((i + nextCell[k * 2]) + ", " + (j + nextCell[k * 2 + 1]))) {
                checkArea(i + nextCell[k * 2], j + nextCell[k * 2 + 1], picture, calledCell, color, areaCellCount);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,3},{0,2,3,2},{3,3,3,0}};
        solution(3,4, arr);
    }
}
