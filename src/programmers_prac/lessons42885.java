//탐욕법 > 구명보트
package programmers_prac;

import java.util.Collections;
import java.util.LinkedList;

public class lessons42885 {
	 public int solution(int[] people, int limit) {
	        int answer = 0;

	        //우선순위큐에 people배열 삽입
	        LinkedList<Integer> weightOfOne = new LinkedList<Integer>();


	        for(int weight : people) {
	        	weightOfOne.add(weight);
	        }
	        Collections.sort(weightOfOne);

	        //무인도에 남는 사람이 없을때까지 반복
	        while(weightOfOne.size() > 0) {
	        	 //탈출하지 못한 사람들 중 한명
		        int lowest = weightOfOne.poll();

		        //가장 작은 사람이 limit의 절반을 초과할경우
		        if(lowest  > limit / 2) {
		        	answer++;
		        	break;
		        }
		        //두 사람의 몸무게를 합쳤을 때 한계치에 가장 타이트한 사람 찾기
		        int next = 0;

		        //두 사람의 몸무게의 합
		        int sum = lowest;
		        for(int nextOne : weightOfOne) {
		        	//두 사람의 몸무게의 합이 한도치 이내이고, limit에 가장 타이트한 값이라면
		        	if(lowest + nextOne <= limit && lowest + nextOne > sum) {
		        		sum = lowest + nextOne;
		        		next = nextOne;
		        	}
		        }

		        //더해지는 사람이 있을 수 잇는 경우
		        if(weightOfOne.size()>0 && next != 0)
		        	weightOfOne.remove(weightOfOne.indexOf(next));

		        answer++;
	        }
	        answer += weightOfOne.size();
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
