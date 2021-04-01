//해시 > 전화번호 목록
package programmers_prac;

import java.util.Collections;
import java.util.LinkedList;

public class lessons42577 {
	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		LinkedList<StringBuilder> ar = new LinkedList<StringBuilder>();

		for (String a : phone_book) {
			StringBuilder sb = new StringBuilder(a);
			ar.add(sb);
		}

		Collections.sort(ar);


		while (ar.size() != 1) {
			StringBuilder a1 = ar.poll();
			String a = a1.toString();

			StringBuilder a2 = ar.peek();
			String b = a2.toString();

			if(a.length() < b.length() && a.equals(b.substring(0,a.length()))) {
				answer = false;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] arr = { "1333", "134", "2" };
		System.out.println(solution(arr));

	}

}
