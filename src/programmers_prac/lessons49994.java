//sumer/winter coding(~2018) > 방문길이
package programmers_prac;

import java.util.HashSet;

public class lessons49994 {
	public static int solution(String dirs) {
		int answer = 0;
		char[] commands = { 'U', 'D', 'R', 'L' };

		// 지나간 경로를 담을 hashset, 경로가 (1,1), (1,2)일 경우 "1112", "1211" 두 방향의 경로를 저장
		HashSet<String> hs = new HashSet<String>();
		// 입력 dirs의 stringbuilder
		StringBuilder dir = new StringBuilder(dirs);
		// 현재좌표
		int[] now = { 0, 0 };

		// dir의 모든 문자에 대해 검사
		for (int i = 0; i < dir.length(); i++) {
			// 입력값
			char command = dir.charAt(i);
			// 출발한 좌표
			String start = now[0] + "" + now[1];

			// up일 때
			if (now[1] < 5 && command == commands[0]) {
				now[1]++;
			}
			// down일 때
			if (now[1] > -5 && command == commands[1]) {
				now[1]--;
			}
			// right일 때
			if (now[0] < 5 && command == commands[2]) {
				now[0]++;
			}
			// left일 때
			if (now[0] > -5 && command == commands[3]) {
				now[0]--;
			}
			// 도착한 좌표
			String end = now[0] + "" + now[1];
			if (!start.equals(end)) {
				hs.add(start + end);
				hs.add(end + start);
			}

		}
		answer = hs.size() / 2;
		return answer;
	}

	public static void main(String[] args) {
		solution("LULLLLLLU");
	}

}
