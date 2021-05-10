//summer/winter coding(~2018) > 점프와 순간이동
package programmers_prac;

public class lessons12980 {
	public int solution(int n) {
		int ans = 1;

		while (n != 1) {
			if (n % 2 == 1) {
				ans++;
			}
			n /= 2;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
