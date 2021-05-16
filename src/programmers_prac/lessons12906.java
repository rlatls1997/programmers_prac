//연습문제 > 같은 숫자는 싫어
package didntCompelete;

import java.util.ArrayList;

public class lessons12906 {
	public int[] solution(int[] arr) {
		int[] answer;
		ArrayList<Integer> al = new ArrayList<>();

		int before = 0;
		if (arr.length != 0) {
			before = arr[0];
		}
		al.add(before);
		for (int i = 1; i < arr.length; i++) {
			if (before != arr[i]) {
				al.add(arr[i]);
				before = arr[i];
			}
		}
		answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
