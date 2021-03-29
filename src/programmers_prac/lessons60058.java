//2020kakao blind recruitment_괄호변환
package programmers_prac;

public class lessons60058 {
	public static String solution(String p) {
		String answer = "";

		if (p == null) {
			return "";
		}
		// 문자열 정렬메소드 수행
		p = recursive(p);
		answer = p;

		return answer;
	}

	public static String recursive(String w) {
		String result = "";

		StringBuilder sb = new StringBuilder(w);
		// 문자열 w를 u,v로 분리
		String u;
		String v;
		if(w.length() == 0)
			return "";

		// 두 문자열 u, v로 분리했을 때 u가 올바른 괄호 문자열인경우
		if (sb.charAt(0) == '(') {
			int end = 1;
			int numOfLeft = 1;
			int numOfRight = 0;

			// u가 올바른 괄호문자열이 될 때까지 반복
			while (numOfLeft != numOfRight) {
				// 왼쪽 괄호일 경우
				if (sb.charAt(end) == '(') {
					end++;
					numOfLeft++;
				}

				// 오른쪽 괄호일 경우
				else if (sb.charAt(end) == ')') {
					end++;
					numOfRight++;
				}
			}
			// 문자열 u, v 저장
			u = sb.substring(0, end);
			v = sb.substring(end, sb.length());

			// 문자열 v에 대해 재귀적 실행
			if (v != "")
				v = recursive(v);

			// 수행한 결과를 u에 붙힌 후 리턴
			result = u + v;

		}

		// 두 문자열 u, v로 분리했을 때 u가 올바른 괄호 문자열이 아닌 경우
		if (sb.charAt(0) == ')') {
			int end = 1;
			int numOfLeft = 0;
			int numOfRight = 1;

			// u가 균형잡힌 문자열이 될 때까지 반복
			while (numOfLeft != numOfRight) {
				// 왼쪽 괄호일 경우
				if (sb.charAt(end) == ')') {
					end++;
					numOfRight++;
				}

				// 오른쪽 괄호일 경우
				else if (sb.charAt(end) == '(') {
					end++;
					numOfLeft++;
				}
			}
			// 문자열 u, v 저장
			u = sb.substring(0, end);
			v = sb.substring(end, sb.length());

			// 문자열 v에 대해 재귀적 실행
			if (v != "")
				v = recursive(v);

			// 첫번째 문자가 (가 붙은 빈 문자열
			String blank = "(";

			// 빈 문자열에 재귀호출이 수행된 v 붙이고 ) 붙이기
			blank = blank + v + ")";

			// 문자열 u에 대하여 첫문자, 마지막문자 제거 후 (문자는 )로, )문자는 (로 바꾸기
			StringBuilder newU = new StringBuilder(u);
			newU.deleteCharAt(newU.length() - 1);
			newU.deleteCharAt(0);

			if (newU.length() != 0) {
				for (int i = 0; i < newU.length(); i++) {
					if (newU.charAt(i) == '(') {
						newU.replace(i, i + 1, ")");

					} else {
						newU.replace(i, i + 1, "(");
					}

				}
			}

			u = newU.toString();

			// 수행한 결과를 리턴
			result = blank + u;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
	}
}
