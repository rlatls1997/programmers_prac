package didntCompelete;
//해시 > 위장
import java.util.HashMap;
import java.util.Map;

public class lessons42578 {
	public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();


        for(String [] cloth : clothes) {
        	hm.put(cloth[1], hm.getOrDefault(cloth[1], 0)+1);
        }
        for(int value : hm.values()) {
        	answer *= value+1;
        }
        return answer-1;
    }


	public static void main(String[] args) {
		String[][] arr = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(arr));

	}

}
