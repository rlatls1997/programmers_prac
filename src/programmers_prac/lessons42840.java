//완전탐색 > 모의고사
package programmers_prac;

public class lessons42840 {
	public static int[] solution(int[] answers) {
		int[] answer = {};

		int a1 = 0;
		int a2 = 0;
		int a3 = 0;

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] arr3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		for (int i = 0; i < answers.length; i++) {
			if (arr1[i % 5] == answers[i])
				a1++;
			if (arr2[i % 8] == answers[i])
				a2++;
			if (arr3[i % 10] == answers[i])
				a3++;
		}
		if (a1 == a2 && a2 == a3) {
			answer = new int[3];
			answer[0] = 1;
			answer[1] = 2;
			answer[2] = 3;
		} else if (a1 > a2 && a1 > a3) {
			answer = new int[1];
			answer[0] = 1;
		} else if (a2 > a1 && a2 > a3) {
			answer = new int[1];
			answer[0] = 2;
		} else if (a3 > a2 && a3 > a1) {
			answer = new int[1];
			answer[0] = 3;
		} else if (a1 == a2 && a1 > a3) {
			answer = new int[2];
			answer[0] = 1;
			answer[1] = 2;
		} else if (a2 == a3 && a2 > a1) {
			answer = new int[2];
			answer[0] = 2;
			answer[1] = 3;
		} else if (a1 == a3 && a1 > a2) {
			answer = new int[2];
			answer[0] = 1;
			answer[1] = 3;
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
