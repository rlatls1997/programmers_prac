//동적계획법(Dynamic Programming) > N으로 표현
package programmers_prac;

import java.util.ArrayList;

public class lessons42895 {
	// 사칙연산 값 리턴
	public static int calc(int a, int b, int type) {
		if (type == 0)
			return a + b;
		else if (type == 1)
			return a - b;
		else if (type == 2)
			return a * b;
		else {
			return a / b;
		}
	}

	public static int solution(int N, int number) {
		// N의 호출횟수에 따른 연산결과를 저장하는 ArrayList를 담고있는 ArrayList
		ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>(8);

		// 호출횟수 8까지만 검사
		for (int i = 0; i < 8; i++) {
			// N의 호출횟수에 따른 연산결고를 저장하는 ArrayList
			ArrayList<Integer> ar1 = new ArrayList<Integer>();

			// 연산자가 포함되지 않은 연산결과, 예로 N=1이고 i=0이면 1, i=3이면 111
			String basicNum = "";
			int noneCalc = 0;

			// 숫자만 있는 경우의 값 구하기
			while (noneCalc < i + 1) {
				basicNum += N;
				noneCalc++;
			}
			ar1.add(Integer.parseInt(basicNum));

			// 연산자가 포함되지 않은 결과는 따로 검사
			if (Integer.parseInt(basicNum) == number)
				return i + 1;

			// 연산자가 포함된 경우의 값 구하기
			for (int j = 0; j < i; j++) {
				int k = i - j - 1;

				for (int l = 0; l < ar.get(j).size(); l++) {

					for (int q = 0; q < ar.get(k).size(); q++) {
						int a = ar.get(j).get(l);
						int b = ar.get(k).get(q);

						for (int w = 0; w < 4; w++) {
							// 0으로 나누는 경우에는 생략
							if (w == 3 && b == 0) {
								continue;
							}
							int temp = calc(a, b, w);

							// 값이 같으면 연산에 사용된 N의 개수 리턴
							if (temp == number)
								return i + 1;
							ar1.add(temp);
						}
					}
				}
			}
			// ar에 ar1 ArrayList추가
			ar.add(i, ar1);
		}
		// 최솟값이 8보다 클 때
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, 5));
	}
}
