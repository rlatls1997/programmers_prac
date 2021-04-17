package programmers_prac;

public class lessons42842 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		for (int i = 1; i <= yellow + 1 / 2; i++) {
			// i가 yellow의 약수일 경우
			if (yellow % i == 0) {
				// 노란색 격자사각형의 가로길이
				int width = yellow / i;
				// 이 때 필요한 갈색사각형의 개수
				int needNums = 2 * i + 2 * width + 4;
				if (brown == needNums) {
					answer[0] = width + 2;
					answer[1] = i + 2;
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
