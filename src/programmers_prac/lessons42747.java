//정렬 > H-index
package programmers_prac;

import java.util.Arrays;

public class lessons42747 {
	public int solution(int[] citations) {
		int answer = 0;

		//오름차순 정렬
		Arrays.sort(citations);

		//인용된 횟수, 최촛값은 논문들 중 가장 인용된 횟수가 많은 논문의 인용된 횟수
		int time = citations[citations.length-1];

		//인용된 횟수가 0이 될 때까지
		while(time != 0) {
			//인용된 횟수 time 이상인 인용횟수를 가진 논문 중 가장 가까이 있는 논문의 위치
			int index1 = 0;

			for(int i = 0; i<citations.length; i++) {
				if(time <= citations[i]) {
					index1 = i;
					break;
				}
			}

			//time이상의 인용횟수를 가진 논문의 개수
			int nums = citations.length - (index1);

			//논문의 개수가 time이상이라면 break
			if(nums >= time) {
				answer = time;
				break;
			}

			//아닐경우 인요횟수를 줄이고 재탐색
			time--;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
