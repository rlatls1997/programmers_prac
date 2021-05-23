//2018 KAKAO BLIND RECRUITMENT > [1차]뉴스 클러스터링
package programmers_prac;

import java.util.ArrayList;
import java.util.List;

public class lessons17677 {
	public static  int solution(String str1, String str2) {
		String str1ToUpperCase = str1.toUpperCase();
		String str2ToUpperCase = str2.toUpperCase();

		List<String> str1Set = new ArrayList<>();
		List<String> str2Set = new ArrayList<>();
		List<String> intersection = new ArrayList<>();
		List<String> union = new ArrayList<>();

		char [] str1CharArr = str1ToUpperCase.toCharArray();
		char [] str2CharArr = str2ToUpperCase.toCharArray();

		for (int i = 0; i < str1CharArr.length - 1; i++) {
			if(!Character.isAlphabetic(str1CharArr[i])|| !Character.isAlphabetic(str1CharArr[i+1])) {
				continue;
			}
			str1Set.add(str1CharArr[i]+""+str1CharArr[i+1]);
		}
		for(int i = 0; i<str2CharArr.length -1; i++) {
			if(!Character.isAlphabetic(str2CharArr[i])|| !Character.isAlphabetic(str2CharArr[i+1])) {
				continue;
			}
			str2Set.add(str2CharArr[i]+""+str2CharArr[i+1]);
		}

		str1Set.stream().forEach((element)->{if(str2Set.contains(element)) {intersection.add(element); str2Set.remove(element);}});
		str1Set.stream().forEach((element)->{union.add(element);});
		str2Set.stream().forEach((element)->{union.add(element);});

		return (union.isEmpty())? 65536 : intersection.size() * 65536 / union.size();
	}

	public static void main(String[] args) {
		solution("aaabbbb", "aaaabbb");
	}
}