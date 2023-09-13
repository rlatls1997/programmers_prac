package programmers_prac;

import java.util.ArrayList;
import java.util.List;
//2020 KAKAO BLIND RECRUITMENT_기둥과 보 설치
public class lessons60061 {
    public int[][] solution(int n, int[][] build_frame) {
        // [poll, panel]
        int[][][] status = new int[n + 1][n + 1][2];

        for (int[] command : build_frame) {
            int x = command[0];
            int y = command[1];
            boolean isPanel = command[2] == 1;
            boolean isAdding = command[3] == 1;

            if (isAdding) {
                boolean canAdd = isPanel ? canAddPanel(status, x, y) : canAddPoll(status, x, y);
                if (!canAdd) {
                    continue;
                }
                status[x][y][command[2]] = 1;
            } else {
                status[x][y][command[2]] = 0;
                if (canRemove(status)) {
                    continue;
                }
                status[x][y][command[2]] = 1;
            }

        }
        return getResult(status);
    }

    int[][] getResult(int[][][] status) {
        int[][] result;
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[0].length; j++) {
                if (status[i][j][0] == 1) {
                    resultList.add(new int[]{i, j, 0});
                }
                if (status[i][j][1] == 1) {
                    resultList.add(new int[]{i, j, 1});
                }
            }
        }
        result = new int[resultList.size()][3];

        resultList.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });

        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    boolean canRemove(int[][][] status) {
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[0].length; j++) {
                if (status[i][j][0] == 1) {
                    if (!canAddPoll(status, i, j)) {
                        return false;
                    }
                }
                if (status[i][j][1] == 1) {
                    if (!canAddPanel(status, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean canAddPanel(int[][][] status, int x, int y) {
        //하단에 기둥이 있는 경우
        if (status[x][y - 1][0] == 1) {
            return true;
        }

        //우하단에 기둥이 있는 경우
        if (x + 1 < status.length && status[x + 1][y - 1][0] == 1) {
            return true;
        }
        //양쪽에 패널이 있는 경우
        if (x - 1 >= 0 && status[x - 1][y][1] == 1 &&
                x + 1 < status.length && status[x + 1][y][1] == 1) {
            return true;
        }
        return false;
    }

    boolean canAddPoll(int[][][] status, int x, int y) {
        //바닥면
        if (y == 0) {
            return true;
        }
        //아래에 기둥이 있는 경우
        if (status[x][y - 1][0] == 1) {
            return true;
        }
        //좌하단에 패널이 있는 경우
        if (x - 1 >= 0 && status[x - 1][y][1] == 1) {
            return true;
        }
        //우하단에 패널이 있는 경우
        if (status[x][y][1] == 1) {
            return true;
        }
        return false;
    }
}
