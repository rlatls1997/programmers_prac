//연습문제 > 최솟값 만들기
package programmers_prac;


import java.util.Collections;
import java.util.PriorityQueue;

public class lessons12941 {
	public int solution(int []A, int []B)
    {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int a : A) {
        	pq.add(a);
        }
        for(int a : B) {
        	pq1.add(a);
        }

        while(pq.size() != 0) {
        	System.out.println("pq = "+pq.peek()+", pq1 = " + pq1.peek());
        	answer += pq.poll() * pq1.poll();
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
