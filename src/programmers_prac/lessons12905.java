package programmers_prac;

//연습문제_가장 큰 정사각형 찾기
public class lessons12905 {
    public int solution(int[][] board) {
        int width = 1;
        boolean zero = true;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    zero = false;
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                    width = Math.max(width, board[i][j]);
                }
            }
        }
        return (zero && board[0][0] == 0 && board[1][0] == 0 && board[0][1] == 0) ? 0 : width * width;
    }
}
