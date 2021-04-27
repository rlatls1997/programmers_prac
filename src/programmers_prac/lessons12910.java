//연습문제 > 나누어 떨어지는 숫자 배열
package programmers_prac;

import java.util.ArrayList;

public class lessons12910 {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = {-1};
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int a : arr) {
			if(a % divisor == 0) {
				ar.add(a);
			}
		}
		if(!ar.isEmpty()) {
			return ar.stream().mapToInt(Integer::intValue).sorted().toArray();
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
