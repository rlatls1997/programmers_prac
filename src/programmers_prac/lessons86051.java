package programmers_prac;
//월간코드챌린지시즌3_업는숫자더하기
import java.util.*;
import java.util.stream.Collectors;

public class lessons86051 {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        for (int i = 0; i < 10; i++) answer += (!list.contains(i)) ? i : 0;
        return answer;
    }
}
