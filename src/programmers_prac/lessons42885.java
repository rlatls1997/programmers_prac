//탐욕법 > 구명보트
package programmers_prac;

//탐욕법 > 구명보트
import java.util.Arrays;
import java.util.LinkedList;

public class lessons42885 {
	public static int solution(int[] people, int limit) {
		int answer = 0;

		//오름차순정렬
		Arrays.sort(people);

		// 리스트에 people배열 삽입
		LinkedList<Integer> weightOfOne = new LinkedList<Integer>();


		for (int weight : people) {
			weightOfOne.add(weight);
		}


		// 무인도에 남는 사람이 없을때까지 반복
		while (weightOfOne.size() > 0) {
			answer++;

			// 남은사람 중 가장 무거운 사람
			int heavy = weightOfOne.pollLast();
			/*
			int heavy = weightOfOne.get(weightOfOne.size()-1);
			weightOfOne.remove(weightOfOne.size()-1);
			 */

			// 가장 가벼운 사람과 무거운 사람의 몸무게 합
			int sum = heavy;

			// 남은사람이 남아있는 경우
			if (weightOfOne.size() > 0) {
				// 남은사람 중 가장 가벼운 사람
				int light = weightOfOne.get(0);
				sum = heavy + light;
			}

			// 합이 한계보다 적으면 같은배에 태우기
			if (sum <= limit && weightOfOne.size()>0) {
				weightOfOne.remove(0);
			}

			// 가장 무거운 사람이 제한무게의 절반이하인 경우
			if (heavy <= limit / 2.0) {
				break;
			}
		}
		answer += Math.ceil(weightOfOne.size() / 2.0);
		return answer;
	}

	public static void main(String[] args) {
		int [] arr = {7,8,5};
		solution(arr, 10);
	}

}
