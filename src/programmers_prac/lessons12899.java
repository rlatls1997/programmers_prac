//연습문제 > 124나라의 숫자
package programmers_prac;

public class lessons12899 {
	public static String solution(int n) {
		String[] num = { "4", "1", "2" };
		String answer = "";

		while (n > 0) {
			System.out.println(n);
			answer = num[n % 3] + answer;
			n = (n - 1) / 3;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(22));

	}

}
