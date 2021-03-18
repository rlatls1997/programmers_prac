//해시 > 완주하지 못한 선수
package programmers_prac;

import java.util.HashMap;

public class lessons42676 {
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        //map에 참가자 리스트를 넣는 과정
        for(String part : participant) {
        	//getOrDefault메소드는 part라는 key값을 조회해서 value를 얻는다.
        	//part라는 key값이 없을 경우에는 0을 대입한다.
        		//즉 part라는 key값이 없을 경우에는 <part, 1> 쌍이 대입된다.
        	//part라는 key값이 있을 경우에는 얻은 value값에 1을 더한다.
        	map.put(part, map.getOrDefault(part, 0) + 1);
        }
        for(String comp : completion) {
        	map.put(comp, map.get(comp) -1);
        }
        //map.keySet()은 key값들만 모은 set를 반환하는 메소드
        for(String key : map.keySet()) {
        	if(map.get(key) != 0) {
        		answer = key;
        	}

        }

        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
