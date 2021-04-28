//월간 코드 챌린지 시즌1 > 이진 변환 반복하기
package programmers_prac;

public class lessons70129 {
	public static int[] solution(String s) {
		int[] answer = new int[2];

		int removedZero = 0;
		int time = 0;

		while(!s.equals("1")) {
			StringBuilder sb = new StringBuilder(s);

			String sub = "";
			int index = 0;
			while(index < sb.length()) {
				if(sb.charAt(index) == '1') {
					sub+=1;
				}
				index++;
			}
			removedZero += sb.length() - sub.length();
			s = Integer.toBinaryString(sub.length());
			time++;
		}
		answer[0] = time;
		answer[1] = removedZero;
		return answer;
	}

	public static void main(String[] args) {
		solution("0111010");
	}
}
