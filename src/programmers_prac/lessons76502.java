//월간 코드 챌린지 시즌2 > 괄호 회전하기
package programmers_prac;

import java.util.LinkedList;
import java.util.Stack;

public class lessons76502 {
	public static int solution(String s) {
		int answer = 0;
		LinkedList<Character> ll = new LinkedList<>();

		for (char ch : s.toCharArray()) {
			ll.add(ch);

		}
		for (int i = 0; i < s.length(); i++) {
			if (checkCorrect(ll)) {
				answer++;
			}
			ll.add(ll.poll());
		}
		return answer;
	}

	public static boolean checkCorrect(LinkedList<Character> ll) {
		boolean correct = true;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < ll.size(); i++) {
			char poll = ll.get(i);
			if (!st.isEmpty()) {
				if (st.peek() == '(' && poll == ')') {
					st.pop();
				} else if (st.peek() == '[' && poll == ']') {
					st.pop();
				} else if (st.peek() == '{' && poll == '}') {
					st.pop();
				} else {
					st.add(poll);
				}
			}
			else {
				if(poll == ')' || poll == ']'||poll == '}') {
					correct = false;
					break;
				}
				else
					st.add(poll);
			}
		}
		if (!st.isEmpty()) {
			correct = false;
		}
		return correct;
	}

	public static void main(String[] args) {
		solution("[)(]");

	}

}
