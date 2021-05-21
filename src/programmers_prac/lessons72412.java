//2021 KAKAO BLIND RECRUITMENT > 순위검색
package programmers_prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class lessons72412 {
	public static void inputInfos(Map<String, ArrayList<Integer>> infoMap, String info) {
		String[] infoArr = info.split(" ");
		infoMap.get(infoArr[0] + infoArr[1] + infoArr[2] + infoArr[3]).add(Integer.parseInt(infoArr[4]));
		infoMap.get("-" + infoArr[1] + infoArr[2] + infoArr[3]).add(Integer.parseInt(infoArr[4]));
		infoMap.get(infoArr[0] + "-" + infoArr[2] + infoArr[3]).add(Integer.parseInt(infoArr[4]));
		infoMap.get(infoArr[0] + infoArr[1] + "-" + infoArr[3]).add(Integer.parseInt(infoArr[4]));
		infoMap.get(infoArr[0] + infoArr[1] + infoArr[2] + "-").add(Integer.parseInt(infoArr[4]));
		infoMap.get("-" + "-" + infoArr[2] + infoArr[3]).add(Integer.parseInt(infoArr[4]));
		infoMap.get("-" + infoArr[1] + "-" + infoArr[3]).add(Integer.parseInt(infoArr[4]));
		infoMap.get("-" + infoArr[1] + infoArr[2] + "-").add(Integer.parseInt(infoArr[4]));
		infoMap.get(infoArr[0] + "-" + "-" + infoArr[3]).add(Integer.parseInt(infoArr[4]));
		infoMap.get(infoArr[0] + "-" + infoArr[2] + "-").add(Integer.parseInt(infoArr[4]));
		infoMap.get(infoArr[0] + infoArr[1] + "-" + "-").add(Integer.parseInt(infoArr[4]));
		infoMap.get("-" + "-" + "-" + infoArr[3]).add(Integer.parseInt(infoArr[4]));
		infoMap.get("-" + "-" + infoArr[2] + "-").add(Integer.parseInt(infoArr[4]));
		infoMap.get("-" + infoArr[1] + "-" + "-").add(Integer.parseInt(infoArr[4]));
		infoMap.get(infoArr[0] + "-" + "-" + "-").add(Integer.parseInt(infoArr[4]));
		infoMap.get("-" + "-" + "-" + "-").add(Integer.parseInt(infoArr[4]));
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		String[] language = { "cpp", "java", "python", "-" };
		String[] position = { "backend", "frontend", "-" };
		String[] career = { "junior", "senior", "-" };
		String[] soulfood = { "chicken", "pizza", "-" };

		Map<String, ArrayList<Integer>> infoMap = new HashMap<>();
		for (int i = 0; i < language.length; i++) {
			for (int j = 0; j < position.length; j++) {
				for (int k = 0; k < career.length; k++) {
					for (int l = 0; l < soulfood.length; l++) {
						infoMap.put(language[i] + position[j] + career[k] + soulfood[l], new ArrayList<Integer>());
					}
				}
			}
		}
		for (String information : info) {
			inputInfos(infoMap, information);
		}
		Set<String> keys = infoMap.keySet();

		for (String key : keys) {
			Collections.sort(infoMap.get(key));
		}
		int index = 0;
		for (String q : query) {
			String[] queryArr = q.split(" ");
			String key = queryArr[0] + queryArr[2] + queryArr[4] + queryArr[6];

			int countNum = Collections.binarySearch(infoMap.get(key), Integer.parseInt(queryArr[7]));

			if (countNum >= 0) {
				for (int i = countNum - 1; i >= 0; i--) {
					if (infoMap.get(key).get(i) < Integer.parseInt(queryArr[7])) {
						break;
					} else {
						countNum = i;
					}
				}
				countNum = infoMap.get(key).size() - countNum;
			} else {
				countNum = infoMap.get(key).size() + countNum + 1;
			}
			answer[index] = countNum;
			index++;
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] arr = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] arr1 = { "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250", "- and backend and senior and - 150",
				"- and - and - and chicken 100", "- and - and - and - 150" };
		solution(arr, arr1);
	}

}
