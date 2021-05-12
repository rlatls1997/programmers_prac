//2021 Dev-Matching:웹 백엔드 개발자(상반기) > 로또의 최고 순위와 최저 순위
package programmers_prac;

import java.util.HashSet;
import java.util.Set;

public class lessons77484 {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int correct = 0;
		int zero = 0;

		Set<Integer> winSet = new HashSet<>();
		for(int num : win_nums) {
			winSet.add(num);
		}
		for(int i = 0; i<lottos.length; i++) {
			if(winSet.contains(lottos[i])) {
				correct++;
			}
			if(lottos[i] == 0) {
				zero++;
			}
		}
		answer[0] = (correct + zero > 1)? 7-correct-zero: 6;
		answer[1] = (correct > 1)? 7-correct: 6;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
