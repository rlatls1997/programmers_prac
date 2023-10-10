package baekjoon_prac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//14425
//문자열 집합
public class boj14425 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();

		Set<String> stringSet = new HashSet<>();

		int count = 0;

		for (int i = 0; i < n + m; i++) {
			String str = s.next();

			if (i < n) {
				stringSet.add(str);
			} else if (stringSet.contains(str)) {
				count++;
			}
		}

		System.out.print(count);
	}
}
