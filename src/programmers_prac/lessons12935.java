package programmers_prac;
//연습문제
//제일 작은 수 제거하기

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lessons12935 {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        List<Integer> answerArr = Arrays.stream(arr).boxed().collect(Collectors.toList());
        answerArr.remove(answerArr.indexOf(Arrays.stream(arr).min().getAsInt()));
        return (answerArr.isEmpty()) ? answer : answerArr.stream().mapToInt(Integer::intValue).toArray();
    }
}
