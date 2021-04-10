//연습문제 > 최댓값과 최솟값
package programmers_prac;

import java.util.StringTokenizer;

public class lessons12939 {
	public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()) {
        	int a = Integer.parseInt(st.nextToken());

        	if(a > max) {
        		max = a;
        	}
        	if(a < min) {
        		min = a;
        	}
        }
        answer = min+" "+max;

        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
