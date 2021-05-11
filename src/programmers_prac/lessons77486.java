//2021 Dev-Matching: 웹 백엔드 개발자(상반기) > 다단계 칫솔 판매
package programmers_prac;

import java.util.HashMap;
import java.util.Map;

public class lessons77486 {
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];

		Map<String, Integer> stack = new HashMap<>();
		Map<String, String> boss = new HashMap<>();

		for (int i = 0; i < enroll.length; i++) {
			stack.put(enroll[i], 0);
			boss.put(enroll[i], referral[i]);
		}

		for (int i = 0; i < seller.length; i++) {
			String person = seller[i];
			int money = amount[i] * 100;
			String nextBoss = boss.get(person);


			while(!person.equals("-")) {
				stack.put(person, stack.get(person) + (int) (money - Math.floor(money * 0.1)));

				money = (int) Math.floor(money * 0.1);
				person = nextBoss;
				nextBoss = boss.get(person);
			}
		}
		for (int i = 0; i < answer.length; i++) {
			answer[i] = stack.get(enroll[i]);
		}
		return answer;
	}

	public static void main(String[] args) {
		String [] arr = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String [] arr1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String [] s = {"young", "john", "tod", "emily", "mary"};
		int [] a = {12, 4, 2, 5, 10};
		solution(arr, arr1, s,a );
	}

}
