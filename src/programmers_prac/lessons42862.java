//탐욕법(Greedy) > 체육복
package programmers_prac;

public class lessons42862 {
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if(reserve[j] == lost[i]) {
					reserve[j] = -1;
					lost[i] = -1;
				}
			}
		}
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (reserve[j] >= lost[i] - 1 && reserve[j] <= lost[i] + 1) {
					reserve[j] = -1;
					lost[i] = -1;
				}
			}
		}
		for (int student : lost) {
			if (student != -1) {
				n--;
			}
		}
		answer = n;
		return answer;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2 };
		int[] arr1 = { 2, 4, 3 };
		System.out.println(solution(4, arr, arr1));
	}
}
