//정렬 > k번째 수
package programmers_prac;

import java.util.ArrayList;
import java.util.Collections;

public class lessons42748 {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		ArrayList<Integer> result = new ArrayList<Integer>();

		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i<commands.length; i++) {
			result.clear();
			int start = commands[i][0];
			int last = commands[i][1];
			int getIndex = commands[i][2] -1;


			for(int j = start - 1; j<last; j++) {
				result.add(array[j]);
			}
			Collections.sort(result);
			al.add(result.get(getIndex));


		}
		answer = new int[al.size()];
		int i = 0;
		for(int a : al) {
			answer[i] = a;
			i++;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
