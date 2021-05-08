//연습문제 > 2016년
package programmers_prac;

import java.util.HashMap;

public class lessons12901 {
	public String solution(int a, int b) {
		String answer = "";
		String[] days = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(1, 0);
		for (int i = 2; i <= a; i++) {
			if (i == 3) {
				hm.put(i, (hm.getOrDefault(i - 1, 0) + 29));
			} else {
				if (i < 10) {
					if (i % 2 == 0 || i == 9) {
						hm.put(i, (hm.getOrDefault(i - 1, 0) + 31));
					} else {
						hm.put(i, (hm.getOrDefault(i - 1, 0) + 30));
					}
				} else {
					if (i % 2 == 1) {
						hm.put(i, (hm.getOrDefault(i - 1, 0) + 31));
					} else {
						hm.put(i, (hm.getOrDefault(i - 1, 0) + 30));
					}
				}
			}
		}

		answer = days[(hm.get(a) + b) % 7];
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
