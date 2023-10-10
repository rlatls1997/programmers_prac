package baekjoon_prac;

import java.util.Scanner;
import java.util.Stack;

//11899
//괄호 끼워넣기
public class boj11899 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String bracketsString = s.next();

		Stack<String> bracketStack = new Stack<>();

		for (char bracket : bracketsString.toCharArray()) {
			String bracketString = bracket + "";

			if (bracketStack.isEmpty()) {
				bracketStack.push(bracketString);
				continue;
			}

			String peekBracketString = bracketStack.peek();

			if (peekBracketString.equals("(")) {
				if (bracketString.equals(")")) {
					bracketStack.pop();
				} else {
					bracketStack.push(bracketString);
				}
			} else {
				bracketStack.push(bracketString);
			}
		}

		System.out.print(bracketStack.size());
	}
}
