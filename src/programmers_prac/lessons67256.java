package programmers_prac;
//2020카카오 인턴십 > 키패드 누르기

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lessons67256 {
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		Map<Integer, Integer[]> numLoc = new HashMap<>();
		Set<Integer> forLeft = new HashSet<>();
		Set<Integer> forBoth = new HashSet<>();
		Set<Integer> forRight = new HashSet<>();
		char whenSameDistance = (hand.equals("right"))? 'R' : 'L';

		Integer[] locationZero = new Integer[2];
		locationZero[0] = 4;
		locationZero[1] = 2;
		numLoc.put(0, locationZero);
		forBoth.add(0);
		int inputNum = 1;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				Integer[] location = new Integer[2];
				location[0] = i;
				location[1] = j;
				numLoc.put(inputNum, location);

				if (j == 1) {
					forLeft.add(inputNum);
				}
				if (j == 2) {
					forBoth.add(inputNum);
				}
				if (j == 3) {
					forRight.add(inputNum);
				}
				inputNum += 1;
			}
		}
		int [] leftHand = {4, 1};
		int [] rightHand = {4, 3};

		for(int num : numbers) {
			char tmp = 'N';
			if(forLeft.contains(num)) {
				tmp = 'L';
			}
			if(forRight.contains(num)) {
				tmp = 'R';
			}
			if(forBoth.contains(num)) {
				int distanceToLeftHand = Math.abs(numLoc.get(num)[0] - leftHand[0])
						+ Math.abs(numLoc.get(num)[1] - leftHand[1]);
				int distanceToRightHand = Math.abs(numLoc.get(num)[0] - rightHand[0])
						+ Math.abs(numLoc.get(num)[1] - rightHand[1]);
				if(distanceToLeftHand == distanceToRightHand) {
					tmp = whenSameDistance;
				}
				if(distanceToLeftHand < distanceToRightHand) {
					tmp = 'L';
				}
				if(distanceToLeftHand > distanceToRightHand) {
					tmp = 'R';
				}

			}
			if(tmp == 'L') {
				leftHand[0] = numLoc.get(num)[0];
				leftHand[1] = numLoc.get(num)[1];
			}
			else {
				rightHand[0] = numLoc.get(num)[0];
				rightHand[1] = numLoc.get(num)[1];
			}
			answer += tmp;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };

		solution(arr, "right");

	}

}
