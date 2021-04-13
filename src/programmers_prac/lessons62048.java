//Summer/Winter Coding(2019) > 멀쩡한 사각형
package programmers_prac;

public class lessons62048 {
	public static long solution(int w, int h) {
		long answer = 1;

		// 가로로 긴 직사각형으로 생각하기
		if (h > w) {
			int temp = h;
			h = w;
			w = temp;
		}

		// 가로, 세로가 같은 경우
		if (h == w) {
			return (long) h * (w - 1);
		}

		// 가로, 세로가 다른경우
		double x = 0;
		double y = 1;

		//y-1일 때의 x좌표
		double preX = 0;

		// 사용 불가능한 박스의 총 개수
		long sum = 0;

		while (y <= h) {
			preX = x;
			x = (w * y) / h;

			// y-1 ~ y 범위내에서 사용 불가능한 박스의 개수
			sum += Math.ceil(x) - Math.floor(preX);
			y++;
		}
		answer = (long) w * (long) h - sum;
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(12, 12));

	}

}
