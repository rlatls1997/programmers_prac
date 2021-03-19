//스택/큐 > 주식가격
package programmers_prac;

import java.util.ArrayList;

public class lessons42584 {
	public int[] solution(int[] prices) {
		int[] answer = {};

		answer = new int[prices.length];
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int a : prices) {
			al.add(a);
		}
		for(int i = 0; i<al.size(); i++) {
			int sec = 1;
			int comp = i+1;
			if(i == al.size() -1) {
				answer[i] = 0;
			}
			else {
			while((comp) < (al.size()-1) &&(al.get(i) <= al.get(comp))) {
				sec++;
				comp++;
			}
			answer[i] = sec;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
