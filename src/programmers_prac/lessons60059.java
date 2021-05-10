//2020 KAKAO BLIND RECRUITMENT > 자물쇠와 열쇠
package programmers_prac;

public class lessons60059 {
	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;

		for (int i = 0; i < 4; i++) {
			if (checkKey(key, lock)) {
				answer = true;
				break;
			}
			turn90(key);
		}
		return answer;
	}

	public static boolean checkKey(int[][] key, int[][] lock) {
		boolean correct = false;

		int index1 = -key.length + 1;

		for (int i = 0; i < lock.length + key.length - 1; i++) {
			int index2 = -key.length + 1;
			for (int j = 0; j < lock.length + key.length - 1; j++) {
				if (checkCorrect(key, lock, index1, index2)) {
					correct = true;
					break;
				}
				index2++;
			}
			index1++;
		}
		return correct;
	}

	public static boolean checkCorrect(int[][] key, int[][] lock, int index1, int index2) {
		boolean correct = true;

		int[][] lockTmp = new int[lock.length][lock.length];
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				lockTmp[i][j] = lock[i][j];
			}
		}
		for (int k = 0; k < key.length; k++) {
			for (int q = 0; q < key.length; q++) {
				if (k + index1 >= 0 && k + index1 < lock.length && q + index2 >= 0 && q + index2 < lock.length) {
					lockTmp[k + index1][q + index2] += key[k][q];
				}
			}
		}
		for (int[] row : lockTmp) {
			for (int column : row) {
				if (column != 1) {
					correct = false;
				}
			}
		}
		return correct;
	}

	public static void turn90(int[][] key) {
		int[][] tmp = new int[key.length][key.length];

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				tmp[j][key.length - 1 - i] = key[i][j];
			}
		}
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				key[i][j] = tmp[i][j];
			}
		}
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] arr1 = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(arr, arr1));
	}
}
