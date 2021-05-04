// 2017 팁스타운 > 짝지어 제거하기
package programmers_prac;

import java.util.Stack;

public class lessons12973 {

	public static int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
        	if(stack.isEmpty()) {
        		stack.add(s.charAt(i));
        	}
        	else {
        		if(stack.peek() == s.charAt(i)) {
        			stack.pop();
        		}
        		else {
        			stack.add(s.charAt(i));
        		}
        	}
        }

        if(stack.isEmpty()) {
        	return 1;
        }
        return answer;
    }

	public static void main(String[] args) {
		solution("baabaa");
	}
}
