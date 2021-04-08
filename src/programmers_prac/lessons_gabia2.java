//gabia코테2
package programmers_prac;

import java.util.HashSet;
import java.util.Set;

public class lessons_gabia2 {
	public static int solution(String s) {
		int answer = 0;

		Set<String> set = new HashSet<String>();
		StringBuilder sb = new StringBuilder(s);

		//부분문자열의 길이
		int length = 1;
		while(length <= sb.length()) {

			for(int i = 0; i<sb.length()-length+1; i++) {
				//부분문자열 get
				String mini = sb.substring(i, i+length);

				//부분문자열 검사를 위한 StringBuilder
				StringBuilder sb1 = new StringBuilder(mini);
				//부분문자열이 좋은 문자열인지 검사하기 위한 set
				Set<Character> set1 = new HashSet<Character>();
				//좋은 부분문자열일 경우 true
				boolean isGood = true;

				int index1 = 0;
				while(index1 < sb1.length()) {
					char miniChar= sb1.charAt(index1);
					if(set1.contains(miniChar)) {
						isGood=false;
						break;
					}
					set1.add(miniChar);
					index1++;
				}
				if(isGood) {
					set.add(mini);
				}
			}
			length++;
		}
		answer = set.size();
		for(String a : set) {
			System.out.println(a);
		}
		return answer;

	}
	public static void main(String[] args) {
		System.out.println(solution("zxzxz"));

	}

}
