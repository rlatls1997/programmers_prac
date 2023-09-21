//연습문제 > 할인 행사
package programmers_prac;

import java.util.HashMap;
import java.util.Map;

public class lessons131127 {
    private Map<String, Integer> makeShoppingBasket(String[] want, int[] number) {
        Map<String, Integer> shoppingBasket = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            shoppingBasket.put(want[i], number[i]);
        }

        return shoppingBasket;
    }

    private boolean canPurchaseAll(Map<String, Integer> shoppingBasket) {
        return shoppingBasket.values().stream().allMatch(value -> value == 0);
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> shoppingBasket = makeShoppingBasket(want, number);

        for (int i = 0; i < discount.length; i++) {
            shoppingBasket.computeIfPresent(discount[i], (key, value) -> value - 1);

            if (i >= 10) {
                shoppingBasket.computeIfPresent(discount[i - 10], (key, value) -> value + 1);
            }

            if (canPurchaseAll(shoppingBasket)) {
                answer++;
            }
        }

        return answer;
    }
}
