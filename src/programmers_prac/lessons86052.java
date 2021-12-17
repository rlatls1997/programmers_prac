package programmers_prac;
//월간 코드 챌린지 시즌3_빛의 경로 사이클

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lessons86052 {
    public static int[] solution(String[] grid) {
        String[][] board = gridToBoard(grid);
        List<Integer> uniqueRoutes = findNumOfCycle(board);
        uniqueRoutes.sort((o1, o2) -> o1 - o2);
        return uniqueRoutes.stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<Integer> findNumOfCycle(String[][] board) {
        int[][] toAllSides = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Set<String> routesInCycles = new HashSet<>();
        List<Integer> uniqueRoutes = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int col = i;
                int row = j;

                for (int k = 0; k < toAllSides.length; k++) {
                    Set<String> curCycle = new HashSet<>();
                    int nextCol = col + toAllSides[k][0];
                    int nextRow = row + toAllSides[k][1];

                    boolean isUnique = isUniqueCycle(col, row, nextCol, nextRow, board, routesInCycles, curCycle);
                    if (isUnique) {
                        uniqueRoutes.add(curCycle.size());
                    }
                }
            }
        }
        return uniqueRoutes;
    }

    public static boolean isUniqueCycle(int prevCol, int prevRow, int curCol, int curRow,
                                        String[][] board, Set<String> routesInCycles, Set<String> curCycle) {
        while (true) {
            String directionPrevToCur = getDirectionPrevToCur(prevCol, prevRow, curCol, curRow);
            int[] checkedCurPosition = checkPositionOverflow(curCol, curRow, board);
            int newCurCol = checkedCurPosition[0];
            int newCurRow = checkedCurPosition[1];

            String route = toStringRoute(prevCol, prevRow, newCurCol, newCurRow, directionPrevToCur);
            int[] nextPosition = getNextPosition(newCurCol, newCurRow, board, directionPrevToCur);
            curCol = nextPosition[0];
            curRow = nextPosition[1];

            if (routesInCycles.contains(route)) {
                return false;
            }
            if (curCycle.contains(route)) {
                for (String routeOfCurCycle : curCycle) {
                    routesInCycles.add(routeOfCurCycle);
                }
                return true;
            }
            curCycle.add(route);
            prevCol = newCurCol;
            prevRow = newCurRow;
        }
    }

    public static int[] getNextPosition(int col, int row, String[][] board, String directionPrevToCur) {
        String directionTo = board[col][row];

        if (directionTo.equals("L")) {
            if (directionPrevToCur.equals("U")) return new int[]{col, row + 1};
            if (directionPrevToCur.equals("D")) return new int[]{col, row - 1};
            if (directionPrevToCur.equals("L")) return new int[]{col - 1, row};
            if (directionPrevToCur.equals("R")) return new int[]{col + 1, row};
        }
        if (directionTo.equals("R")) {
            if (directionPrevToCur.equals("U")) return new int[]{col, row - 1};
            if (directionPrevToCur.equals("D")) return new int[]{col, row + 1};
            if (directionPrevToCur.equals("L")) return new int[]{col + 1, row};
            if (directionPrevToCur.equals("R")) return new int[]{col - 1, row};
        }
        if (directionTo.equals("S")) {
            if (directionPrevToCur.equals("U")) return new int[]{col + 1, row};
            if (directionPrevToCur.equals("D")) return new int[]{col - 1, row};
            if (directionPrevToCur.equals("L")) return new int[]{col, row + 1};
            if (directionPrevToCur.equals("R")) return new int[]{col, row - 1};
        }
        return new int[]{col, row};
    }

    public static int[] checkPositionOverflow(int col, int row, String[][] board) {
        if (col == -1) {
            col = board.length - 1;
        }
        if (row == -1) {
            row = board[0].length - 1;
        }
        if (col == board.length) {
            col = 0;
        }
        if (row == board[0].length) {
            row = 0;
        }
        return new int[]{col, row};
    }

    public static String getDirectionPrevToCur(int prevCol, int prevRow, int curCol, int curRow) {
        if (prevCol == curCol) {
            return (prevRow > curRow) ? "R" : "L";
        } else {
            return (prevCol > curCol) ? "D" : "U";
        }
    }

    public static String toStringRoute(int prevCol, int prevRow, int curCol, int curRow, String directionPrevToCur) {
        return prevCol + ", " + prevRow + ", " + curCol + ", " + curRow + ", " + directionPrevToCur;
    }

    public static String[][] gridToBoard(String[] grid) {
        String[][] board = new String[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            board[i] = grid[i].split("");
        }
        return board;
    }

    public static void main(String[] args) {
        String[] a = {"S"};
        solution(a);
    }
}
