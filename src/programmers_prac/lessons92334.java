package programmers_prac;
//2022 KAKAO BLIND RECRUITMENT
//신고 결과 받기
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class lessons92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[][] in = new int[id_list.length][id_list.length];
        Map<String, Integer> id = new HashMap<>();
        Map<Integer, Integer> t = new HashMap<>();

        Arrays.stream(id_list).forEach(el -> id.put(el, id.size()));
        Arrays.stream(report).forEach(el -> in[id.get(el.substring(0, el.indexOf(" ")))][id.get(el.substring(el.indexOf(" ") + 1))] = 1);
        IntStream.range(0, in.length).forEach(i -> t.put(i, Arrays.stream(in).mapToInt(ints -> ints[i]).sum()));
        return Arrays.stream(in).mapToInt(el -> IntStream.range(0, el.length).map(i -> (el[i] == 1 && t.get(i) >= k) ? 1 : 0).sum()).toArray();
    }
}
