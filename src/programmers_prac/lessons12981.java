//summer/winter coding(~2018) > 영어 끝말잇기
package programmers_prac;

import java.util.HashSet;

public class lessons12981 {

	public int[] solution(int n, String[] words) {
		int[] answer = {};
		answer = new int[2];
		//이미 말한 단어를 저장
		HashSet<String> hs = new HashSet<String>();
		StringBuilder sb = new StringBuilder(words[0]);

		//i번째 사람
		int i = 1;
		//k번째 턴
		int k = 1;
		//탈락한 사람이 있으면 true
		boolean isFail = false;
		//턴이 한차례 지났는지 체크 지났으면 true
		boolean passCycle = false;
		//이전 단어의 마지막 글자
		char lastChar = sb.charAt(0);

		for(String word : words) {
			StringBuilder sb1 = new StringBuilder(word);
			//이전 단어와 이어지지 않거나 이미 불린 단어인 경우
			if(lastChar != sb1.charAt(0) || hs.contains(word)) {
				isFail = true;
				break;
			}
			//적합한 단어를 부른 경우
			hs.add(word);
			lastChar = sb1.charAt(sb1.length()-1);
			if(i == n) {
				i = 1;
				passCycle = true;
			}
			else {
				i++;
			}
			if(passCycle) {
				k++;
				passCycle = false;
			}
		}
		//중간에 틀린 사람이 있을 경우
		if(isFail) {
			answer[0] = i;
			answer[1] = k;
			return answer;
		}
		//아무도 틀린 사람이 없을 경우
		answer[0] = 0;
		answer[0] = 0;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
