//연습문제 > 124나라의 숫자
package programmers_prac;

public class lessons12899 {
	public static String solution(int n) {
		String answer = "";

		// n이 124로 표현할 때 몇자리가 나오는지 구하기
		int divider = 3;
		// n을 124로 바꿨을 때 자릿수
		int digit = 1;

		int newDivider = 3;
		int previewDivider = 0;

		while (divider < n) {
			digit++;
			newDivider = (int) Math.pow(3, digit);
			if (divider != 0)
				previewDivider = divider;
			divider += newDivider;
		}
		// n을 124로 바꿨을 때의 수
		StringBuilder sb = new StringBuilder();

		// 자릿수 -1일 때 44...4의 경우 n의 값
		recursion(sb, divider, previewDivider, n, digit);

		answer = sb.toString();
		return answer;
	}

	//sb, divider: 124수를 구하기 위한
	public static void recursion(StringBuilder sb, int divider, int previewDivider, int n, int digit) {
		if (sb.length() == digit)
			return;
		//새로운 검사 범위
		int newDivider;
		int newPreviewDivider;

		if (previewDivider + (divider - previewDivider) * ((double) 1 / 3) >= n) {
			newPreviewDivider = previewDivider;
			newDivider = (int) (previewDivider + (divider - previewDivider) * ((double) 1 / 3));
			sb.append(1);
			recursion(sb, newDivider, newPreviewDivider, n, digit);

		} else if (previewDivider + (divider - previewDivider) * ((double) 2 / 3) >= n) {
			newPreviewDivider = (int) (previewDivider + (divider - previewDivider) * ((double) 1 / 3));
			newDivider = (int) (previewDivider + (divider - previewDivider) * ((double) 2 / 3));
			sb.append(2);
			recursion(sb, newDivider, newPreviewDivider, n, digit);
		} else {
			newPreviewDivider = (int) (previewDivider + (divider - previewDivider) * ((double) 2 / 3));
			newDivider = divider;
			sb.append(4);
			recursion(sb, newDivider, newPreviewDivider, n, digit);
		}

	}

	public static void main(String[] args) {
		System.out.println(solution(22));

	}

}
