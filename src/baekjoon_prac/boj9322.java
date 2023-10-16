package baekjoon_prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 9322 > 철벽 보안 알고리즘
public class boj9322 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int testCase = s.nextInt();

		for (int i = 0; i < testCase; i++) {
			s.nextInt();
			s.nextLine();

			String publicKey1 = s.nextLine();
			String publicKey2 = s.nextLine();
			String encryptedString = s.nextLine();

			Map<Integer, Integer> decryptRules = makeDecryptRules(publicKey1, publicKey2);
			String originString = makeOriginString(decryptRules, encryptedString);

			System.out.println(originString);
		}
	}

	private static Map<Integer, Integer> makeDecryptRules(String publicKey1, String publicKey2) {
		String[] publicKey1Elements = publicKey1.split(" ");
		String[] publicKey2Elements = publicKey2.split(" ");

		Map<Integer, Integer> decryptRuleMap = new HashMap<>();

		for (int i = 0; i < publicKey2Elements.length; i++) {
			int originLocation = -1;

			for (int j = 0; j < publicKey1Elements.length; j++) {
				if (publicKey2Elements[i].equals(publicKey1Elements[j])) {
					originLocation = j;
				}
			}
			decryptRuleMap.put(i, originLocation);
		}

		return decryptRuleMap;
	}

	private static String makeOriginString(Map<Integer, Integer> decryptRules, String encryptedString) {
		String[] encryptedStringElements = encryptedString.split(" ");
		String[] originStringElements = new String[encryptedStringElements.length];

		for (int i = 0; i < encryptedStringElements.length; i++) {
			int originIndex = decryptRules.get(i);

			originStringElements[originIndex] = encryptedStringElements[i];
		}

		return String.join(" ", originStringElements);
	}
}
