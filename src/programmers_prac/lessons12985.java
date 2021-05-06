//2017 팁스타운 > 예상 대진표
package programmers_prac;

public class lessons12985 {
	public static int solution(int n, int a, int b) {
		int r = 1;
		if(a > b) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		while (n != 2) {
			if (a <= n/2 && b > n/2) {
				break;
			}
			if(a > n/2 && b > n/2) {
				int tmp = b;
				b = n+1-a;
				a = n+1-tmp;
			}
			n /=2;
		}
		while(Math.pow(2, r) != n) {
			r++;
		}
		return r;
	}

	public static void main(String[] args) {
		solution(8, 5, 7);

	}

}
