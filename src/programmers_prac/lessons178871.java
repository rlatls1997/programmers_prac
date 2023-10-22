package programmers_prac;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 연습문제 > 달리기 경주
public class lessons178871 {
	public String[] solution(String[] players, String[] callings) {
		Map<Integer, String> rankAndPlayerMap = new HashMap<>();
		Map<String, Integer> playerAndRankMap = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			rankAndPlayerMap.put(i, players[i]);
			playerAndRankMap.put(players[i], i);
		}

		for (String calledPlayer : callings) {
			int currentRank = playerAndRankMap.get(calledPlayer);
			int nextRank = currentRank - 1;

			playerAndRankMap.put(calledPlayer, nextRank);
			String forwardPlayer = rankAndPlayerMap.get(nextRank);

			playerAndRankMap.put(forwardPlayer, currentRank);
			rankAndPlayerMap.put(currentRank, forwardPlayer);
			rankAndPlayerMap.put(nextRank, calledPlayer);
		}

		return rankAndPlayerMap.keySet().stream()
			.sorted()
			.map(rankAndPlayerMap::get)
			.collect(Collectors.toList())
			.toArray(new String[players.length]);
	}
}
