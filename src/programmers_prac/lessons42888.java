//2019 KAKAO BLIND RECRUITMENT > 오픈채팅방
package programmers_prac;

import java.util.HashMap;
import java.util.StringTokenizer;

public class lessons42888 {
	public static String[] solution(String[] record) {
		String[] answer = {};

		HashMap<String, String> hm = new HashMap<String, String>();

		// answer의 총 원소의 개수
		int answerLength = 0;

		for (String memory : record) {
			StringTokenizer st = new StringTokenizer(memory);
			// 몇번째 토큰인지 나타냄
			int index = 0;
			// userId
			String uid = "";
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				if (index == 0) {
					// 닉네임 변경 외의 명령인 경우
					if (!token.equals("Change")) {
						answerLength++;
					}
				}
				if (index == 1) {
					uid = token;
				}
				if (index == 2) {
					hm.put(uid, token);
				}
				index++;
			}
		}

		// 답변배열 초기화
		answer = new String[answerLength];
		// 삽입위치
		int location = 0;

		for (String memory : record) {
			StringTokenizer st = new StringTokenizer(memory);
			// 몇 번째 토큰인지 나타냄
			int index = 0;
			// 명령어
			String command = "";
			// uid
			String uid = "";
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				if (index == 0) {
					command = token;
				}
				if (index == 1) {
					uid = token;
				}
				index++;
			}
			// 명령이 Enter, Leave일 경우에만 answer에 추가
			if (command.equals("Enter")) {
				answer[location] = hm.get(uid) + "님이 들어왔습니다.";
				location++;
			} else if (command.equals("Leave")) {
				answer[location] = hm.get(uid) + "님이 나갔습니다.";
				location++;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		String arr[] = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		solution(arr);

	}
}
