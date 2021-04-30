//2019 카카오 개발자 겨울 인턴십 > 튜플
package programmers_prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class lessons64065 {
	public static int[] solution(String s) {
		int[] answer = {};

		String subString = s.substring(2, s.length() - 2);
		String[] elements = subString.split("\\},\\{");

		answer = new int[elements.length];

		Arrays.sort(elements, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length())
					return -1;
				return 1;
			}
		});
		answer[0] = Integer.parseInt(elements[0]);
		Set<Integer> set = new HashSet<>();
		set.add(answer[0]);

		for (int i = 1; i < elements.length; i++) {
			String[] tmpArr = elements[i].split(",");
			for (String element : tmpArr) {
				int intElement = Integer.parseInt(element);
				if (!set.contains(intElement)) {
					set.add(intElement);
					answer[i] = intElement;
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
	}

}
