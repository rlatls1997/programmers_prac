//연습문제 > 피보나치 수
package programmers_prac;

public class lessons12945 {

	public int solution(int n) {
        int answer = 0;

        int a1 = 0;
        int a2 = 1;

        int num = n;
        while(num > 1) {
        	answer = a1 + a2;
        	a1 = a2 % 1234567;
        	a2 = answer % 1234567;
        	num--;
        }
        if(n == 1) {
        	answer = 1;
        }
        answer = answer % 1234567;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
