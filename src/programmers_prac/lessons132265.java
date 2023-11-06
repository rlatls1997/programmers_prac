package programmers_prac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 연습문제
// 롤케이크 자르기
public class lessons132265 {
	public int solution(int[] topping) {
		return getWaysToCutFairly(topping);
	}

	private int getWaysToCutFairly(int[] toppings) {
		Map<Integer, Long> left = new HashMap<>();
		Map<Integer, Long> right = Arrays.stream(toppings)
			.boxed()
			.collect(Collectors.groupingBy(topping -> topping, Collectors.counting()));

		boolean findSameOnce = false;
		int waysToCutFairly = 0;

		for (int topping : toppings) {
			left.put(topping, left.getOrDefault(topping, 0L) + 1);

			Long rightToppingCount = right.get(topping);

			if (rightToppingCount == 1) {
				right.remove(topping);
			} else {
				right.put(topping, rightToppingCount - 1);
			}

			if (left.size() == right.size()) {
				waysToCutFairly++;
				findSameOnce = true;
			} else if (findSameOnce) {
				return waysToCutFairly;
			}
		}

		return waysToCutFairly;
	}
}
