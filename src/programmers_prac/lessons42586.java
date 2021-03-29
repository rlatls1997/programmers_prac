//스택/큐 > 기능개발
package programmers_prac;

import java.util.ArrayList;

public class lessons42586 {
	 public int[] solution(int[] progresses, int[] speeds) {
	        int [] answer = {};

	        //작업 진전도 arraylist
	        ArrayList<Integer> prg = new ArrayList<Integer>();
	        for(int a : progresses) {
	        	prg.add(a);
	        }

	        //각 작업에 대한 속도 arrayList
	        ArrayList<Integer> spd = new ArrayList<Integer>();
	        for(int a : speeds) {
	        	spd.add(a);
	        }
	        //배포가 진행딜 때 몇개의 작업이 함께 배포되는지 저장하는 arrayList
	        ArrayList<Integer> finish = new ArrayList<Integer>();

	        //prg의 원소가 남아있으면 계속
	        while(prg.size() > 0) {
	        	//배포되는 경우에 함께 배포되는 작업개수 측정
	        	int finished = 0;

	        	//먼저 빼내야할 작업의 진전도가 100이상이 될 때까지 다른 원소에도 진전도 더해주기
	        	while(prg.get(0) < 100) {
	        		for(int i = 0; i<prg.size(); i++) {
	        			prg.set(i, prg.get(i)+spd.get(i));
	        		}
	        	}

	        	//진전도가 100이상인 원소가 어디까지 있는지 확인
	        	int index = 0;
	        	while(index < prg.size() && prg.get(index) >= 100) {
	        		index++;
	        	}

	        	//진전도가 100 이상인 원소들 제거
	        	for(int i = index-1; i>= 0; i--) {
	        		prg.remove(i);
	        		spd.remove(i);
	        	}

	        	finish.add(index);

	        }


	        answer = new int[finish.size()];

	        for(int i = 0; i<finish.size(); i++) {
	        	answer[i] = finish.get(i);
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
