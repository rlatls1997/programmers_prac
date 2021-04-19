//연습문제 > 다음 큰 숫자
package programmers_prac;

public class lessons12911 {
	public int solution(int n) {
        int i = 1;
        while(true) {
        	if(Integer.bitCount(n) == Integer.bitCount(n+i)) {
        		break;
        	}
        	i++;
        }
        return n+i;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
