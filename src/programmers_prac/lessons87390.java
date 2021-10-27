package programmers_prac;
//월간 코드 챌린지 시즌3 > n^2 배열 자르기
public class lessons87390 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int row = (int) (left / n);
        int column = (int) (left % n);
        int value = (row > column) ? row + 1 : column + 1;

        for (int i = 0; i < (int) (right - left + 1); i++) {
            answer[i] = value;
            column++;
            if (column > row) value++;
            if (column == n) {
                row++;
                column = 0;
                value = row + 1;
            }
        }
        return answer;
    }
}
