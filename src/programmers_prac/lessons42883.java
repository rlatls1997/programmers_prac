//탐욕법 > 큰 수 만들기
//ide에선 잘 되나 programmers에선 12번 런타임에러
package programmers_prac;

public class lessons42883 {
	public static String solution(String number, int k) {
		String answer = "";

		StringBuilder numbers = new StringBuilder(number);
		StringBuilder result = new StringBuilder();

		int size = numbers.length() - k;

		// 지워야할 개수
		int canRemove = k;
		// 지운 개수
		int removed = 0;

		// 제거해야할 수가 남아있는 경우 반복
		while (removed != k) {
			if(numbers.length() == k-removed) {
				break;
			}
			// 제거해야할 수가 k개일 때 k+1번째 수

			int getChar = numbers.charAt(k - removed);

			// 0~canRemove까지의 인덱스중 가장 큰 수
			char max = numbers.charAt(0);
			// 최댓값의 위치
			int maxIndex = 0;

			// 검사하는동안 계속 같은값이 나왔는지 확인


			for (int i = 0; i < k - removed; i++) {
				if (numbers.charAt(i) > max) {
					max = numbers.charAt(i);
					maxIndex = i;
				}
			}

			// getChar가 max보다 큰 경우
			// 앞의 수들은 전부 필요없으므로 제거
			// 이 경우 반복문이 끝나게 되어있음
			if (getChar > max) {
				numbers.delete(0, k - removed);
				result.append(numbers.toString());
				removed += (k - removed);
			}
			// 반대의경우
			// 최댓값까지 포함하여 문자열 제거 후 해당 문자만 result에 append
			else {
				numbers.delete(0, maxIndex + 1);
				result.append(max);
				removed += maxIndex;

			}

		}
		answer = result.toString();

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("1924", 2));

	}

}
