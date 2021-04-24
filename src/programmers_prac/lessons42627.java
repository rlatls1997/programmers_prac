package programmers_prac;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class lessons42627 {
	public static int solution(int[][] jobs) {
		int answer = 0;
		// LinkedList에 job배열 담기
		LinkedList<int[]> ll = new LinkedList<int[]>();
		for (int[] job : jobs) {
			ll.add(job);
		}
		// 수행시간 오름차순으로 정렬
		Collections.sort(ll, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] <= o2[1]) {
					return -1;
				}
				return 1;
			}
		});
		// 현재 시점
		int nowTime = 0;
		// 유휴상태 확인
		boolean working = false;

		while (ll.size() > 0) {
			// 다음 수행할 작업이 담긴 위치
			int index = 0;
			// 수행할 작업이 있는지 검사
			boolean canWork = false;
			// 하드디스크가 작업을 수행하고 있지 않을 때
			if (!working) {
				int requestedTime = Integer.MAX_VALUE;
				int minimumInsertedTimeJobIndex = 0;
				for (int[] job : ll) {
					// 요청 시각이 현재 시각 이하인 경우
					if (nowTime >= job[0]) {
						// 작업의 요청 시각이 다른 작업들보다 더 빠른경우
						if (requestedTime > job[0]) {
							index = minimumInsertedTimeJobIndex;
							requestedTime = job[0];
						}
						canWork = true;
						working = true;
					}
					minimumInsertedTimeJobIndex++;
				}
			}
			// 하드디스크가 작업을 수행하고 있을 때
			// 바로 이어서 할 수 있는 작업이 있는지 검사
			else {
				int minimumWorkingTimeJobIndex = 0;
				for (int[] job : ll) {
					// 요청 시각이 현재 시각 이하인 경우
					if (nowTime >= job[0]) {
						canWork = true;
						working = true;
						index = minimumWorkingTimeJobIndex;
						break;
					}
					minimumWorkingTimeJobIndex++;
				}
			}
			// 수행할 수 있는 작업이 없는 경우
			if (!canWork) {
				working = false;
				nowTime++;
				continue;
			}
			// 수행할 수 있는 작업이 있는 경우
			int[] job = ll.get(index);
			ll.remove(index);

			nowTime += job[1];
			//작업의 소요시간 구하기
			answer += nowTime - job[0];

		}
		//작업 별 소요시간의 평균 구하기
		answer /= jobs.length;
		return answer;

	}
	public static void main(String[] args) {
		int[][] arr = { { 0, 10 }, { 2, 12 }, { 9, 19 }, { 15, 17 } };

		System.out.println((solution(arr)));
	}
}
