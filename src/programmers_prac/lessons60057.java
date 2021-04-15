//2020 kakao blind recruitment > 문자열 압축
package programmers_prac;

public class lessons60057 {
	public static int solution(String s) {
		StringBuilder sb = new StringBuilder(s);
		int answer = sb.length();
		// 자를 문자열의 길이
		int length = 1;
		while (length <= sb.length() / 2) {
			// 부분문자열의 start부분
			int index = length;
			// 현재 부분문자열이 연속으로 나타나는 횟수
			int time = 1;
			// 압축된 문자열
			String compactString = "";
			// 자를 문자열
			String substring = sb.substring(0, length);
			// 자를 다음 문자열
			String nextSubstring = "";
			while (index + length <= sb.length()) {
				nextSubstring = sb.substring(index, index + length);
				// 같은 문자열일 경우 time 증가
				if (substring.equals(nextSubstring)) {
					time++;
					// 더 비교할 부분문자열이 남아있지 않을 때
					if (sb.length() - (index + length) < length) {
						// 일치하는 부분문자열이 2번이상 나온 경우
						if (time > 1) {
							compactString += time + substring;
							time = 1;
						}
						// 일치하는 부분문자열이 1번 나온 경우
						else {
							compactString += substring;
						}
						compactString += sb.substring(index + length, sb.length());
					}
				}
				// 다른 문자열이거나 비교 가능한 마지막 부분문자열일 경우
				if (!substring.equals(nextSubstring)) {
					// 일치하는 부분문자열이 2번이상 나온 경우
					if (time > 1) {
						compactString += time + substring;
						time = 1;
					}
					// 일치하는 부분문자열이 1번 나온 경우
					else {
						compactString += substring;
					}
					substring = nextSubstring;
					// 문자열이 다르고 더 비교할 부분문자열이 남아있지 않을 때
					if (sb.length() - (index) < 2 * length) {
						compactString += sb.substring(index, sb.length());
						break;
					}
				}
				index += length;
			}
			// compactString의 length값이 최소라면 answer에 대입
			if (compactString.length() != 0 && compactString.length() < answer) {
				answer = compactString.length();
			}
			length++;
		}
		return answer;
	}

	public static void main(String[] args) {
		solution("xababcdcdababcdcd");
	}

}
