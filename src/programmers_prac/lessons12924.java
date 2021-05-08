//연습문제 > 숫자의 표현
package programmers_prac;

public class lessons12924 {
	public static int solution(int n) {
		int answer = 1;

		for(int i = 1; i<n/2+1; i++) {
			int sum = 0;
			int p = i;
			while(sum < n) {
				sum += p;
				p++;
			}
			if(n == sum) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(16);
	}

}
