//연습문제 > 햄버거 만들기
package programmers_prac;

import java.util.*;

public class lessons133502 {

    private final int[] BURGER_RECIPE = new int[]{1, 2, 3, 1};

    private boolean canMakeBurger(Stack<Integer> ingredientsStack) {
        int ingredientsSize = ingredientsStack.size();

        // 재료가 충분하지 않으면 버거를 만들 수 없으므로 return false;
        if (ingredientsSize < 4) {
            return false;
        }

        // 버거의 재료 순서와 스택의 (맨 위 재료 - 4번째) ~ 맨 위 재료가 일치하지 않으면 버거를 만들 수 없으므로 return false;
        for (int i = 0; i < BURGER_RECIPE.length; i++) {
            int ingredient = ingredientsStack.get(ingredientsSize - BURGER_RECIPE.length + i);

            if (ingredient != BURGER_RECIPE[i]) {
                return false;
            }
        }

        // 재료도 충분하고 재료 순서도 일치한다면 return true;
        return true;
    }

    public int solution(int[] ingredients) {
        int burgers = 0;
        Stack<Integer> ingredientsStack = new Stack<>();

        for (int ingredient : ingredients) {
            // 1. 재료를 하나씩 스택에 추가한다.
            ingredientsStack.push(ingredient);

            // 2. 버거를 만들 수 있으면 버거를 만든다. (스택의 꼭대기부터 버거재료 갯수(4개)만큼 재료 제거)
            if (canMakeBurger(ingredientsStack)) {
                for (int i = 0; i < BURGER_RECIPE.length; i++) {
                    ingredientsStack.pop();
                }

                burgers += 1;
            }
        }

        return burgers;
    }
}
