//연습문제 > 올바른 괄호
package programmers_prac;

public class lessons12909 {
	static boolean solution(String s) {
		boolean answer = true;

		StringBuilder sb = new StringBuilder(s);

		// 좌괄호 개수를 임시저장할 변수
		int leftParentheses = 0;

		// 가리킬 문자의 index
		int index = 0;
		while (index < sb.length()) {
			// 현재문자
			char nowParentheses = sb.charAt(index);

			if (nowParentheses == '(') {
				leftParentheses++;
			} else {
				leftParentheses--;
			}
			if (leftParentheses < 0) {
				break;
			}

			index++;
		}
		if (leftParentheses != 0) {
			answer = false;
		}
		return answer;
	}

	public static void main(String[] args) {
		solution("(()(");

	}

}
