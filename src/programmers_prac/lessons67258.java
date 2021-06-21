package programmers_prac;
//2020카카오 인턴십
//보석 쇼핑
import java.util.*;

public class lessons67258 {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int length = Integer.MAX_VALUE;
        Set<String> gemsSet = new HashSet<>();

        for (String gem : gems) {
            gemsSet.add(gem);
        }
        int start = 0;
        int end = 0;
        Map<String, Integer> gemsInRange = new HashMap<>();

        while (end <= gems.length) {
            if (gemsSet.size() == gemsInRange.size()) {
                gemsInRange.put(gems[start], gemsInRange.getOrDefault(gems[start], 0) - 1);
                if (gemsInRange.get(gems[start]) == 0) {
                    gemsInRange.remove(gems[start]);
                }
                start++;
            } else {
                if (end == gems.length) {
                    break;
                }
                gemsInRange.put(gems[end], gemsInRange.getOrDefault(gems[end], 0) + 1);
                end++;
            }
            if (gemsSet.size() == gemsInRange.size() && end + 1 - start < length) {
                length = end + 1 - start;
                answer[0] = start + 1;
                answer[1] = end;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"A", "A", "A", "A", "B"};
        solution(arr);
    }
}