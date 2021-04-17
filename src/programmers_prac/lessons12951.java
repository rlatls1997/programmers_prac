// 연습문제 > JadenCase문자열 만들기
package programmers_prac;

public class lessons12951 {
	public String solution(String s) {
		String answer = "";
		StringBuilder sb = new StringBuilder(s);

		int index = 0;
		// 이전문자가 공백문자인가?
		boolean preCharisBlank = true;

		while (index < sb.length()) {
			char nowChar = sb.charAt(index);

			if (nowChar == ' ') {
				preCharisBlank = true;
				index++;
				continue;
			} else {
				// 단어의 첫 문자일 경우, 소문자 => 대문자
				if (preCharisBlank) {
					if ((nowChar <= 122) && (nowChar >= 97)) {
						char change = Character.toUpperCase(nowChar);
						sb.deleteCharAt(index);
						sb.insert(index, change);
					}
					preCharisBlank = false;
				}
				// 단어의 첫 문자가 아닐 경우, 대문자 => 소문자
				else {
					if ((nowChar <= 90) && (nowChar >= 65)) {
						char change = Character.toLowerCase(nowChar);
						sb.deleteCharAt(index);
						sb.insert(index, change);
					}
				}

			}
			index++;
		}
		answer = sb.toString();
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
