//연습문제 > 가장 긴 펠린드롬
package programmers_prac;

public class lessons12904 {
	public static int solution(String s) {
		int answer = 1;

		StringBuilder sb = new StringBuilder(s);

		// 현재 위치의 문자를 기준으로 펠린드롬 탐색하기
		for (int i = 0; i < sb.length(); i++) {
			// 현재 문자의 왼쪽 문자
			char leftChar = '0';
			// 왼쪽 문자가 있을 경우에만 해당 문자로 초기화
			if (i > 0) {
				leftChar = sb.charAt(i - 1);
			}
			// 왼쪽 문자가 기준 문자와 같을 경우
			if (leftChar == sb.charAt(i)) {
				int length = getPalindromeLength(sb, i - 2, i + 1, 2);
				if (length > answer) {
					answer = length;
				}
			}
			// 왼쪽문자가 기준문자와 같지 않은 경우
			int length = getPalindromeLength(sb, i - 1, i + 1, 1);
			if (length > answer) {
				answer = length;
			}
		}
		return answer;
	}
	public static int getPalindromeLength(StringBuilder sb, int leftIndex, int rightIndex, int length) {
		int longestLength = length;

		while (leftIndex >= 0 && rightIndex <= sb.length() - 1) {
			if (sb.charAt(leftIndex) != sb.charAt(rightIndex)) {
				break;
			}
			leftIndex--;
			rightIndex++;
			longestLength += 2;
		}
		return longestLength;
	}
	public static void main(String[] args) {
		solution("aaabccc");
	}
}
