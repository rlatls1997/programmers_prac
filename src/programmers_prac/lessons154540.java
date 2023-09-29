// 연습문제 > 무인도 여행
package programmers_prac;

import java.util.ArrayList;
import java.util.List;

public class lessons154540 {
	public int[] solution(String[] maps) {
		char[][] islandMap = new char[maps.length][];

		for (int i = 0; i < maps.length; i++) {
			islandMap[i] = maps[i].toCharArray();
		}

		List<Integer> foodInfo = new ArrayList<>();

		for (int i = 0; i < islandMap.length; i++) {
			for (int j = 0; j < islandMap[i].length; j++) {
				int food = findIslandAndGetFood(islandMap, i, j);

				if (food != 0) {
					foodInfo.add(food);
				}
			}
		}

		return foodInfo.isEmpty() ? new int[] {-1} : foodInfo.stream()
			.mapToInt(i -> i)
			.sorted()
			.toArray();
	}

	private int findIslandAndGetFood(char[][] islandMap, int row, int col) {
		if (row < 0 || row == islandMap.length || col < 0 || col == islandMap[0].length) {
			return 0;
		}

		if (islandMap[row][col] == 'X') {
			return 0;
		}

		int food = Integer.parseInt(islandMap[row][col] + "");
		islandMap[row][col] = 'X';

		food += findIslandAndGetFood(islandMap, row + 1, col);
		food += findIslandAndGetFood(islandMap, row - 1, col);
		food += findIslandAndGetFood(islandMap, row, col + 1);
		food += findIslandAndGetFood(islandMap, row, col - 1);

		return food;
	}
}
