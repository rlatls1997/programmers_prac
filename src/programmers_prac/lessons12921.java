//연습문제 > 소수찾기
package programmers_prac.didntCompelete;

public class lessons12921 {
	public static int solution(int n) {
		int answer = 0;

		for(int i = 2; i<= n; i++) {
			boolean value = true;

			for(int j = 2; j<=Math.sqrt(i); j++) {
				System.out.println(i+", "+j);
				if(i%j == 0) {
					value = false;
					break;
				}
			}
			if(value) {
				System.out.println(i);
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(10);

	}

}
