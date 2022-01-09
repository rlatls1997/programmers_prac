package baekjoon_prac;
//5357_큐빙
import java.util.Scanner;

public class boj5357 {
    static int[][] rotateSequences = {{3, 5, 2, 4}, {3, 4, 2, 5}, {0, 5, 1, 4}, {0, 4, 1, 5}, {0, 2, 1, 3}, {0, 3, 1, 2}};

    static void rotateCube(char[][][] cube, String info) {
        char side = info.charAt(0);
        char direction = info.charAt(1);

        rotateSide(cube, side, direction);
        rotateOtherSide(cube, side, direction);
    }

    static void rotateOtherSide(char[][][] cube, char side, char direction) {
        int sideIndex = getSideIndex(side);
        int sequenceIndex = sideIndex;

        if (direction == '-') {
            if (sideIndex % 2 == 0) {
                sequenceIndex++;
            } else {
                sequenceIndex--;
            }
        }
        int[] sequence = rotateSequences[sequenceIndex];

        if (side == 'U' || side == 'D') {
            char[][] tmp = clone(cube, sequence[3]);
            int col = (side == 'U') ? 0 : 2;
            for (int i = 3; i >= 0; i--) {
                if (i == 0) {
                    for (int j = 0; j < 3; j++) {
                        cube[sequence[i]][col][j] = tmp[col][j];
                    }
                    break;
                }
                for (int j = 0; j < 3; j++) {
                    cube[sequence[i]][col][j] = cube[sequence[i - 1]][col][j];
                }
            }
        }
        if (side == 'F' || side == 'B') {
            char[][] tmp = clone(cube, sequence[3]);
            int col = (side == 'F') ? 0 : 2;
            for (int i = 3; i >= 0; i--) {
                int curSide = sequence[i];
                if (i == 0) {
                    for (int j = 0; j < 3; j++) {
                        cube[curSide][2 - col][j] = sequence[3] == 4 ? tmp[2 - j][2 - col] : tmp[j][col];
                    }
                    break;
                }
                int prevSide = sequence[i - 1];
                for (int j = 0; j < 3; j++) {
                    if (curSide == 1) {
                        cube[curSide][2 - col][j] = prevSide == 4 ? cube[prevSide][2 - j][2 - col] : cube[prevSide][j][col];
                    }
                    if (curSide == 4) {
                        cube[curSide][j][2 - col] = cube[prevSide][2 - col][2 - j];
                    }
                    if (curSide == 5) {
                        cube[curSide][j][col] = cube[prevSide][2 - col][j];
                    }
                }
            }
        }
        if (side == 'L' || side == 'R') {
            char[][] tmp = clone(cube, sequence[3]);
            int row = (side == 'L') ? 0 : 2;
            for (int i = 3; i >= 0; i--) {
                int curSide = sequence[i];
                if (i == 0) {
                    for (int j = 0; j < 3; j++) {
                        cube[curSide][j][row] = (sequence[3] == 2) ? tmp[j][row] : tmp[2 - j][2 - row];
                    }
                    break;
                }
                int prevSide = sequence[i - 1];
                for (int j = 0; j < 3; j++) {
                    if (curSide == 1) {
                        cube[curSide][j][2 - row] = (prevSide == 3) ? cube[prevSide][j][2 - row] : cube[prevSide][2 - j][row];
                    }
                    if (curSide == 2) {
                        cube[curSide][j][row] = (prevSide == 0) ? cube[prevSide][j][row] : cube[prevSide][2 - j][2 - row];
                    }
                    if (curSide == 3) {
                        cube[curSide][j][2 - row] = (prevSide == 1) ? cube[prevSide][j][2 - row] : cube[prevSide][2 - j][row];
                    }
                }
            }
        }
    }

    static void rotateSide(char[][][] cube, char side, char direction) {
        int sideIndex = getSideIndex(side);
        char[][] clone = clone(cube, sideIndex);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[sideIndex][i][j] = (direction == '+') ? clone[2 - j][i] : clone[j][2 - i];
            }
        }
    }

    static char[][] clone(char[][][] cube, int sideIndex) {
        char[][] clone = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                clone[i][j] = cube[sideIndex][i][j];
            }
        }
        return clone;
    }

    static int getSideIndex(char side) {
        switch (side) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'F':
                return 2;
            case 'B':
                return 3;
            case 'L':
                return 4;
            default:
                return 5;
        }
    }

    static char[][][] getCube() {
        char[][][] cube = {{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}},
                {{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}},
                {{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}},
                {{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}},
                {{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}},
                {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}}};
        return cube;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            char[][][] cube = getCube();
            for (int j = 0; j < m; j++) {
                String info = s.next();
                rotateCube(cube, info);
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(cube[0][j][k]);
                }
                System.out.println();
            }
        }
    }
}
