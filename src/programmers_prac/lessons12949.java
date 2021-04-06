//연습문제 > 행렬의 곱셈
package programmers_prac;

public class lessons12949 {
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = {};

		int[][] arrFirst = {};
		int[][] arrSecond = {};
		// arr1 = x*y행렬일 때 arr2 = y*z행렬이어야만 곱할 수 있으므로 조건 맞춰주기
		if (arr1[0].length != arr2.length) {
			arrFirst = arr2;
			arrSecond = arr1;
		} else {
			arrFirst = arr1;
			arrSecond = arr2;
		}

		// 배열 answer크기설정
		answer = new int[arrFirst.length][arrSecond[0].length];

		// arr1 = x*y, arr2 = y*z 일 때
		// x만큼 반복
		for (int i = 0; i < arrFirst.length; i++) {
			// z만큼 반복
			for (int j = 0; j < arrSecond[0].length; j++) {
				// 결과배열에 들어갈 원소값
				int element = 0;
				// y만큼 반복하여 원소 구하기
				for (int k = 0; k < arrSecond.length; k++) {
					element += arrFirst[i][k] * arrSecond[k][j];
				}
				answer[i][j] = element;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] arr1 = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
		solution(arr, arr1);

	}
}
