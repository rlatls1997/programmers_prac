// 2023 KAKAO BLIND RECRUITMENT
// 택배 배달과 수거하기
package programmers_prac;

public class lessons150369 {

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int i = n - 1;
		int j = n - 1;

		while (i >= 0 || j >= 0) {
			int deliveryCap = cap;
			int pickupCap = cap;
			int distance = 0;

			while (i >= 0) {
				if (deliveries[i] <= 0) {
					i--;
					continue;
				}

				distance = Math.max(i + 1, distance);

				int temp = deliveries[i];
				deliveries[i] -= deliveryCap;
				deliveryCap -= temp;

				if (deliveryCap <= 0) {
					break;
				}
			}

			while (j >= 0) {
				if (pickups[j] <= 0) {
					j--;
					continue;
				}

				distance = Math.max(j + 1, distance);

				int temp = pickups[j];
				pickups[j] -= pickupCap;
				pickupCap -= temp;

				if (pickupCap <= 0) {
					break;
				}
			}

			answer += 2L * distance;
		}

		return answer;
	}
}
