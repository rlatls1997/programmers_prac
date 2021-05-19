//연습문제 > 문자열 내 마음대로 정렬하기
package programmers_prac;

import java.util.Arrays;
import java.util.Comparator;

public class lessons12915 {
	public static String[] solution(String[] strings, int n) {
		String[] answer = {};

		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.charAt(n) > o2.charAt(n)) {
					return 1;
				}
				if (o1.charAt(n) < o2.charAt(n)) {
					return -1;
				}
				if (o1.charAt(n) == o2.charAt(n)) {
					if (o1.compareTo(o2) >= 1) {
						return 1;
					} else {
						return -1;
					}
				}
				return 0;
			}
		});
		for (String a : strings) {
			System.out.println(a);
		}
		return strings;
	}

	public static void main(String[] args) {
		String[] a = { "aba", "abad", "abc", "acca", "abca" };
		solution(a, 2);
	}

}
