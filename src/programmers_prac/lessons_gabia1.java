//가비아 코테 1
package programmers_prac;

public class lessons_gabia1 {
	public static int solution(int n) {
		int answer = 2;

		StringBuilder sb = new StringBuilder(""+factorial(n));

		int index = sb.length() -1;
		int tails = 0;
		while(sb.charAt(index) == '0') {
			tails++;
			index--;
		}
		answer = tails;
		System.out.println(sb.toString());
		return answer;
	}
	public static long factorial(int n) {
		long result = 1;
		for(int i = 1; i<n+1; i++) {
			result *= i;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(solution(5));
	}
}
