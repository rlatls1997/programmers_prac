//스택/큐 > 프린터
package programmers_prac;

import java.util.LinkedList;

public class lessons42857 {
	public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> ls = new LinkedList<Integer>();
        for(int a : priorities) {
        	ls.add(a);
        }
        int nowLoc = location;	//목표의 현재 위치
        int goal = priorities[location];	//목표의 우선순위 값

        while(ls.size() < 1) {
        	int peek = ls.pollFirst();
        	nowLoc--;
        	boolean isPoll = true;
        	for(int a : ls) {
        		if(peek < a) {
        			if(peek == goal && nowLoc == 0){
        				nowLoc = ls.size() -1;
        			}
        			ls.add(peek);
        			isPoll = false;
        			break;
        		}
        	}
        	if(isPoll) {

        		answer++;
        		if(peek == goal && nowLoc == 0) {
        			break;
        		}
        	}

        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
