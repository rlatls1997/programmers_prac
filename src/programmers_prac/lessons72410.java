//2021 kakao blind recruitment > 신규 아이디 추천
package programmers_prac;

public class lessons72410 {

	public static String solution(String new_id) {
		String answer = "";
		StringBuilder sb = new StringBuilder(new_id);


			// 1단계, 대문자를 소문자로
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) >= 65 && sb.charAt(i) <= 90) {
					int a = sb.charAt(i);
					a += 32;
					sb.setCharAt(i, (char) a);
				}
			}
			// 2단계 소문자, 숫자, '-', '_', '.' 를 제외한 모든 문자 제거
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) != '_' && sb.charAt(i) != '-' && sb.charAt(i) != '.'
						&& !(sb.charAt(i) >= 48 && sb.charAt(i) <= 57)
						&& !(sb.charAt(i) >= 97 && sb.charAt(i) <= 122)) {
					sb.deleteCharAt(i);
					--i;
				}
			}
			// 3단계 '...'와 '..'를 '.'로 치환
			int start;
			int end;
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == '.') {
					start = i;
					end = i + 1;

					while (end < (sb.length() - 1) && sb.charAt(end) == '.') {
						end++;
					}
					sb.replace(start, end, ".");

					start = 0;
					end = 0;
				}
			}
			// 4단계 아이디의 처음과 마지막에 위치한 '.'를 제거
			if (sb.length() != 0 && sb.charAt(0) == '.')
				sb.deleteCharAt(0);

			if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.')
				sb.deleteCharAt(sb.length() - 1);
			// 5단계 아이디가 빈 문자열이라면 "a"를 대입
			if (sb.length() == 0)
				sb.append("a");
			// 6단계 아이디가 16자리 이상일 경우 index0~15까지의 문자열을 제외하고 모두 제거
				//제거 후 .가 끝에 위치한다면 . 도 제거
			if (sb.length() > 15)
				sb.delete(15, sb.length());
			if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.')
				sb.deleteCharAt(sb.length() - 1);
			// 7단계 아이디가 2자리 이하일경우 마지막 문자를 아이디의 길이가 3이 될 때가지 반복
			while (sb.length() < 3) {
				char a = sb.charAt(sb.length() - 1);
				sb.append(a);
			}


		answer = sb.toString();
		return answer;

	}

	public static void main(String[] args) {
		System.out.println(solution("abcdefghijklmn.p"));
	}

}
