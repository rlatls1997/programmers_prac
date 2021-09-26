//위클리 챌린지 > 3주차_퍼즐 조각 채우기
package programmers_prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lessons84021 {
    public static int solution(int[][] game_board, int[][] table) {
        int numOfBlankAtInitialTime = getNumOfBlank(game_board);
        while (!isTableEmpty(table)) {
            List<int[]> piece = getPieceInfo(table);
            for (int i = 0; i < 4; i++) {
                if (putPieceIntoBoard(piece, game_board)) {
                    break;
                }
                rotatePiece(piece);
            }
        }
        return numOfBlankAtInitialTime - getNumOfBlank(game_board);
    }

    public static boolean putPieceIntoBoard(List<int[]> piece, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isRetractable(piece, board, i, j) &&
                        isTightToBlank(piece, board, i, j)) {
                    setBoardWithNewPiece(piece, board, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void setBoardWithNewPiece(List<int[]> piece, int[][] board, int i, int j) {
        for (int[] pieceInfo : piece) {
            int relativeX = i + pieceInfo[0];
            int relativeY = j + pieceInfo[1];
            board[relativeX][relativeY] = 1;
        }
    }

    public static boolean isRetractable(List<int[]> piece, int[][] board, int i, int j) {
        for (int[] pieceInfo : piece) {
            int relativeX = i + pieceInfo[0];
            int relativeY = j + pieceInfo[1];

            if (relativeX < 0 || relativeX >= board.length
                    || relativeY < 0 || relativeY >= board.length) {
                return false;
            }
            if (board[relativeX][relativeY] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTightToBlank(List<int[]> piece, int[][] board, int i, int j) {
        boolean isTight = true;
        Set<String> positionSet = new HashSet<>();

        for (int[] pieceInfo : piece) {
            int relativeX = i + pieceInfo[0];
            int relativeY = j + pieceInfo[1];
            String positionSetStr = relativeX + ", " + relativeY;
            positionSet.add(positionSetStr);
        }

        for (int[] pieceInfo : piece) {
            int[][] allSides = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int relativeX = i + pieceInfo[0];
            int relativeY = j + pieceInfo[1];

            for (int[] side : allSides) {
                int sideX = relativeX + side[0];
                int sideY = relativeY + side[1];
                String positionSetStr = sideX + ", " + sideY;

                if (!positionSet.contains(positionSetStr) &&
                        isBlankElement(board, sideX, sideY)) {
                    isTight = false;
                }
            }
        }
        return isTight;
    }

    public static boolean isBlankElement(int[][] board, int i, int j) {
        if ((i >= 0 && i < board.length) &&
                (j >= 0 && j < board.length)) {
            return (board[i][j] == 0) ? true : false;
        }
        return false;
    }

    public static int getNumOfBlank(int[][] board) {
        int numOfBlank = 0;
        for (int[] row : board) {
            for (int element : row) {
                if (element == 0) {
                    numOfBlank++;
                }
            }
        }
        return numOfBlank;
    }

    public static void rotatePiece(List<int[]> piece) {
        for (int[] arr : piece) {
            int tmp = -arr[1];
            arr[1] = arr[0];
            arr[0] = tmp;
        }
    }

    public static boolean isTableEmpty(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<int[]> getPieceInfo(int[][] table) {
        List<int[]> pieceInfo = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 1) {
                    setPieceAndTable(pieceInfo, table, i, j, 0, 0);
                    return pieceInfo;
                }
            }
        }
        return pieceInfo;
    }

    public static void setPieceAndTable(List<int[]> pieceArr, int[][] table, int i, int j
            , int xDirectionByInitial, int yDirectionByInitial) {
        if ((i >= 0 && i < table.length) && (j >= 0 && j < table[i].length) && table[i][j] == 1) {
            table[i][j] = 0;
            int[] relativePosition = new int[2];
            relativePosition[0] = xDirectionByInitial;
            relativePosition[1] = yDirectionByInitial;
            pieceArr.add(relativePosition);

            int[][] allSides = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] side : allSides) {
                setPieceAndTable(pieceArr, table, i + side[0], j + side[1]
                        , xDirectionByInitial + side[0], yDirectionByInitial + side[1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {
                0, 1, 1, 1, 0, 0}};
        int[][] b = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        solution(a, b);
    }
}
