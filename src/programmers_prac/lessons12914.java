//연습문제 > 멀리뛰기
package programmers_prac;

import java.util.HashMap;

public class lessons12914 {
	public long solution(int n) {
		long answer = 0;
		return fibo(n);
	}

	public static long fibo(int n) {
		HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
		hm.put(1, (long) 1);
		hm.put(2, (long) 2);
		for (int i = 3; i <= n; i++) {
			long value = (hm.get(i - 2) + hm.get(i - 1))%1234567;
			hm.put(i, value);
		}
		return hm.get(n);
	}

	public static void main(String[] args) {

	}

}
