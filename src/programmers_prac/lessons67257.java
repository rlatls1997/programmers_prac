//2020 카카오 인턴쉽 > 수식 최대화
package programmers_prac;

import java.util.ArrayList;
import java.util.LinkedList;

public class lessons67257 {
	public static long solution(String expression) {
		long answer = 0;
		long max = Long.MIN_VALUE;
		char[] calc = { '*', '+', '-' };
		char[] output = new char[calc.length];
		boolean[] visited = new boolean[calc.length];

		ArrayList<char[]> al = new ArrayList<char[]>();
		permutation(calc, output, visited, 0, calc.length, 3, al);
		for (char[] a : al) {
			max = (getResult(a, expression) > max) ? getResult(a, expression) : max;
		}
		answer = max;
		return answer;
	}

	public static long getResult(char[] a, String expression) {
		long answer = 0;
		String[] number = expression.split("-|\\*|\\+");
		String[] operator = expression.split("[0-9]+");
		LinkedList<Long> numberList = new LinkedList<Long>();
		LinkedList<String> operatorList = new LinkedList<String>();

		for (String num : number) {
			numberList.add(Long.parseLong(num));
		}
		for (String oper : operator) {
			operatorList.add(oper);
		}
		operatorList.pop();

		for (int i = 0; i < a.length; i++) {
			LinkedList<Integer> indexTemp = new LinkedList<Integer>();
			for (int j = 0; j < operatorList.size(); j++) {
				if (Character.toString(a[i]).equals(operatorList.get(j))) {
					indexTemp.add(j);
				}
			}
			int reducedSize = 0;
			while (indexTemp.size() != 0) {
				int operIndex = indexTemp.poll();
				long result = 0;
				if (a[i] == '+') {
					result = numberList.get(operIndex - reducedSize) + numberList.get(operIndex + 1 - reducedSize);
				}
				if (a[i] == '-') {
					result = numberList.get(operIndex - reducedSize) - numberList.get(operIndex + 1 - reducedSize);
				}
				if (a[i] == '*') {
					result = numberList.get(operIndex - reducedSize) * numberList.get(operIndex + 1 - reducedSize);
				}
				numberList.remove(operIndex + 1 - reducedSize);
				numberList.remove(operIndex - reducedSize);
				numberList.add(operIndex - reducedSize, result);
				operatorList.remove(operIndex - reducedSize);
				reducedSize++;
			}
		}
		answer = Math.abs(numberList.pop());
		return answer;
	}

	public static void permutation(char[] arr, char[] output, boolean[] visited, int depth, int n, int r,
			ArrayList<char[]> al) {
		if (depth == r) {
			print(output, r, al);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(arr, output, visited, depth + 1, n, r, al);
				visited[i] = false;
			}
		}
	}

	static void print(char[] arr, int r, ArrayList<char[]> al) {
		char[] charArr = new char[r];
		for (int i = 0; i < r; i++) {
			charArr[i] = arr[i];
		}
		al.add(charArr);
	}

	public static void main(String[] args) {
		solution("100-200*300-500+20");

	}

}
