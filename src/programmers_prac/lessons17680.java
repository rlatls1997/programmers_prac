package programmers_prac;
//2018 KAKAO BLIND RECRUITMENT > [1차]캐시
import java.util.HashMap;
import java.util.Map;

public class lessons17680 {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Map<String, Integer> cache = new HashMap<>();
		if(cacheSize == 0) {
			return cities.length * 5;
		}
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toUpperCase();

			if (cache.get(city) != null) {
				answer++;
				cache.put(city, i);
			} else {
				answer += 5;
				if (cache.size() < cacheSize) {
					cache.put(city, i);
				} else {
					String delKey = "";
					int min = Integer.MAX_VALUE;
					for (String key : cache.keySet()) {
						if (cache.get(key) < min) {
							min = cache.get(key);
							delKey = key;
						}
					}
					cache.remove(delKey);
					cache.put(city, i);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
