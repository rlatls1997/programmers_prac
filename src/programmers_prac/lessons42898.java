//동적계획법(Dynamic Programming) > 등굣길
package programmers_prac;

public class lessons42898 {
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		//물웅덩이 상수
		final int PUDDLE = -1;
		int[][] course = new int[m][n];

		// 물웅덩이 부분 초기화
		for (int [] puddle : puddles) {
			if(puddle.length != 0) {
				course[puddle[0] -1][puddle[1] -1] = PUDDLE;
			}
		}
		// 집 초기화
		course[0][0] = 1;

		for (int i = 0; i < course.length; i++) {
			for (int j = 0; j < course[i].length; j++) {
				if(i == 0 && j == 0)
					continue;
				//물웅덩이가 아닌 경우 경로구하기
				if (course[i][j] != PUDDLE) {
					int route = 0;
					// 위에서 오는 경로가 있는지 확인, 위쪽이 물웅덩이가 아니라면
					if (i > 0 && course[i - 1][j] != PUDDLE) {
						route += course[i - 1][j];
					}
					// 왼쪽에서 오는 경로가 있는지 확인, 왼쪽이 물웅덩이가 아니라면
					if (j > 0 && course[i][j - 1] != PUDDLE) {
						route += course[i][j - 1];
					}
					course[i][j] = route % 1000000007;
				}
			}

		}
		answer = course[m - 1][n - 1];
		return answer;
	}

	public static void main(String[] args) {
		int [][] arr = {{}};
		solution(4,3,arr);
	}
}
