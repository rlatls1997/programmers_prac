//2021 KAKAO BLIND RECRUITMENT > 메뉴 리뉴얼
package programmers_prac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class lessons72411 {
	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};

		//<만들 수 있는 코스, 주문된 횟수> 쌍을 저장하는 hashMap
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		//정답을 임시저장할 linkedList
		LinkedList<String> ll = new LinkedList<String>();

		//주문된 모든 메뉴조합 탐색
		for (String order : orders) {
			StringBuilder sb = new StringBuilder(order);

			int sbLength = sb.length();
			boolean[] visited = new boolean[sbLength];

			//메뉴조합의 각 메뉴를 사전식 정렬하여 저장할 sbChar
			char[] sbChar = new char[sb.length()];
			for (int i = 0; i < sbChar.length; i++) {
				sbChar[i] = sb.charAt(i);
			}
			Arrays.sort(sbChar);

			//메뉴조합에서 course[i]개를 뽑기
			for (int i = 0; i < course.length; i++) {
				if (sbLength >= course[i]) {
					comb(sbChar, visited, 0, sbLength, course[i], hm);
				}
			}
		}
		Set<String> keys = hm.keySet();
		for (int i = 0; i < course.length; i++) {
			//n개의 메뉴조합중에서 가장 많이 주문된 메뉴조합의 주문된 건 수
			int maxCalled = 0;

			for (String key : keys) {
				if (key.length() == course[i]) {
					if (hm.get(key) > maxCalled && hm.get(key) >= 2) {
						maxCalled = hm.get(key);
					}
				}
			}

			//메뉴개수가 같은 조합중에서 최대로 많이 불린 메뉴조합만을 정답List에 add
			for (String key : keys) {
				if (hm.get(key) == maxCalled && key.length() == course[i]) {
					ll.add(key);
				}
			}
		}
		answer = ll.toArray(new String[ll.size()]);
		Arrays.sort(answer);
		return answer;
	}

	//조합, n개 중 r개를 순서에 상관 없이 뽑는 경우
	// StringBuilder sb의 각 문자의 개수 n개 중 r개의 순열을 뽑는 메소드
	static void comb(char[] sbChar, boolean[] visited, int depth, int n, int r, HashMap<String, Integer> hm) {
		if (r == 0) {
			print(sbChar, visited, n, hm);
			return;
		}
		if (depth == n) {
			return;
		}
		visited[depth] = true;
		comb(sbChar, visited, depth + 1, n, r - 1, hm);

		visited[depth] = false;
		comb(sbChar, visited, depth + 1, n, r, hm);
	}

	static void print(char[] sbChar, boolean[] visited, int n, HashMap<String, Integer> hm) {
		String menu = "";

		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				menu += sbChar[i];
			}
		}
		int countCalled = hm.getOrDefault(menu, 0);
		hm.put(menu, countCalled + 1);
	}
	/****************************************************************************************************************************/
	public static void main(String[] args) {
		String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		int[] course = { 2, 3, 5 };

		String[] arr = solution(orders, course);
		for (String a : arr) {
			System.out.println(a);
		}
	}
}