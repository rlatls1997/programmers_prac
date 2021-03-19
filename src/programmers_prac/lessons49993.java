//summer/Winter Coding(~2018) > 스킬트리
package programmers_prac;

import java.util.ArrayList;

public class lessons49993 {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		ArrayList<StringBuilder> al = new ArrayList<StringBuilder>();
		StringBuilder skillSet = new StringBuilder(skill);

		for (String a : skill_trees) {
			StringBuilder sb = new StringBuilder(a);
			al.add(sb);
		}

		for (StringBuilder a : al) {
			// 가능한 스킬트리일 경우
			boolean ok = true;

			ArrayList<Character> includedSkill = new ArrayList<Character>();

			// 포함여부 확인, includedSkill에 저장
			for (int i = 0; i < a.length(); i++) {
				char skillOne = a.charAt(i);

				int index = 0;
				while (index < skillSet.length()) {
					if (skillOne == skillSet.charAt(index)) {
						includedSkill.add(skillOne);
						break;
					}
					index++;
				}
			}

			// 배워야할 스킬 순서와 비교
			for (int i = 0; i < includedSkill.size(); i++) {
				if (skillSet.charAt(i) != includedSkill.get(i)) {
					ok = false;
					break;
				}
			}

			// 스킬트리에 어떤 스킬목록도 포함되지 않은 경우
			if (includedSkill.size() == 0) {
				ok = true;
			}
			if (ok)
				answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
