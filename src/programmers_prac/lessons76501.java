package programmers_prac;
// 월간 코드 챌린지 시즌2> 음양 더하기
public class lessons76501 {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			answer += (signs[i]) ? absolutes[i] : -absolutes[i];
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
