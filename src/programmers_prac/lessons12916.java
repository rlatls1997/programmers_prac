package programmers_prac;
//연습문제 > 문자열 내 p와 y의 개수
public class lessons12916 {
	boolean solution(String s) {
		int count = 0;

		for(char a : s.toCharArray()) {
			if(a == 'p' || a == 'P')
				count++;
			if(a == 'y' || a == 'Y')
				count--;
		}

		if(count == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
