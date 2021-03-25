//스택/큐 > 프린터
package programmers_prac;

import java.util.LinkedList;

public class lessons42857 {
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		LinkedList<Integer> ls = new LinkedList<Integer>();
		for (int a : priorities) {
			ls.add(a);
		}
		int nowLoc = location; // 목표의 현재 위치
		int goal = priorities[location]; // 목표의 우선순위 값

		// q에 원소가 남아있는동안 반복
		while (ls.size() >= 1) {
			int peek = ls.poll(); // 맨 앞 원소 poll
			nowLoc--;
			boolean isPoll = true;

			//리스트의 모든 원소에 대해 검사
			for (int a : ls) {
				//방금 poll한 원소보다 큰 원소가 나올 경우
				if (peek < a) {
					//poll한것을 다시 add
					ls.add(peek);
					//근데 방금 poll한 원소가 찾는 원소일 경우 찾는 원소의 현재 위치를 수정
					if (peek == goal && nowLoc == -1) {
						nowLoc = ls.size() - 1;
					}
					isPoll = false;
					break;
				}
			}

			// 맨 앞 원소가 우선순위가 가장 큰 원소일경우 리스트 뒤에 붙이지 않고 poll
			if (isPoll) {
				answer++;
				// 내가 찾는 원소일경우 break;
				if (peek == goal && nowLoc == -1) {
					break;
				}
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		int[] arr2 = { 1, 1, 9, 1, 1, 1 };
		int[] arr1 = { 2, 1, 3, 2 };
		solution(arr1, 2);
		solution(arr2, 0);

	}

}
