package baekjoon_prac;

//17219
//비밀번호 찾기
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj17219 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();

		Map<String, String> siteAndPasswordMap = new HashMap<>();

		for (int i = 0; i < n + m; i++) {
			String site = s.next();

			if (i < n) {
				String password = s.next();
				siteAndPasswordMap.put(site, password);
			} else if (i == n + m - 1) {
				System.out.print(siteAndPasswordMap.get(site));
			} else {
				System.out.println(siteAndPasswordMap.get(site));
			}
		}
	}
}
