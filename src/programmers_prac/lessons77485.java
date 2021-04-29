//2021 Dev-Matching: 웹 백엔드 개발자(상반기) > 행렬 테두리 회전하기
package programmers_prac;

public class lessons77485 {
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] arr = new int[rows][columns];

		int num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = num;
				num++;
			}
		}
		int location = 0;
		for (int[] query : queries) {
			int x1 = query[0] - 1;
			int y1 = query[1] - 1;
			int x2 = query[2] - 1;
			int y2 = query[3] - 1;

			int tmp = arr[x1][y1];
			int min = tmp;

			for (int i = x1; i < x2; i++) {
				arr[i][y1] = arr[i + 1][y1];
				if (arr[i][y1] < min) {
					min = arr[i][y1];
				}
			}
			for (int i = y1; i < y2; i++) {
				arr[x2][i] = arr[x2][i + 1];
				if (arr[x2][i] < min) {
					min = arr[x2][i];
				}
			}
			for (int i = x2; i > x1; i--) {
				arr[i][y2] = arr[i-1][y2];
				if (arr[i][y2] < min) {
					min = arr[i][y2];
				}
			}
			for( int i = y2; i > y1; i--) {
				arr[x1][i] = arr[x1][i-1];
				if (arr[x1][i] < min) {
					min = arr[x1][i];
				}
			}
			arr[x1][y1+1] = tmp;

			answer[location] = min;
			location++;
		}
		return answer;
	}

	public static void main(String[] args) {
		int [][] arr = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		solution(3,3,arr);

	}

}
