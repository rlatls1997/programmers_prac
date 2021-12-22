package programmers_prac;
//월간 코드 챌린지 시즌1
//쿼드압축 후 개수 세기
public class lessons68936 {
    public int[] solution(int[][] arr) {
        compactRect(arr);
        return countZeroAndOne(arr);
    }

    public void compactRect(int[][] arr) {
        for (int k = arr.length; k >= 2; k /= 2) {
            int width = k;
            for (int i = 0; i < arr.length; i += width) {
                for (int j = 0; j < arr.length; j += width) {
                    if (canCompact(i, j, width, arr)) {
                        compact(i, j, width, arr);
                    }
                }
            }
        }
    }

    public boolean canCompact(int col, int row, int width, int[][] arr) {
        int value = arr[col][row];
        for (int i = col; i < col + width; i++) {
            for (int j = row; j < row + width; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }

    public void compact(int col, int row, int width, int[][] arr) {
        int value = arr[col][row];
        for (int i = col; i < col + width; i++) {
            for (int j = row; j < row + width; j++) {
                arr[i][j] = -1;
            }
        }
        arr[col][row] = value;
    }

    public int[] countZeroAndOne(int[][] arr) {
        int countZero = 0;
        int countOne = 0;
        for (int[] row : arr) {
            for (int element : row) {
                if (element == 0) {
                    countZero++;
                }
                if (element == 1) {
                    countOne++;
                }
            }
        }
        return new int[]{countZero, countOne};
    }

    public void print(int[][] arr) {
        for (int[] ar : arr) {
            System.out.println();
            for (int a : ar) {
                System.out.print(a + ", ");
            }
        }
    }
}
