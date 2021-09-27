package programmers_prac;
//위클리 챌린지_8주차_최소 직사각형
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class lessons86491 {
    public static int solution(int[][] sizes) {
        return Arrays.stream(sizes).map(arr -> Math.min(arr[0], arr[1])).max((o1, o2) -> o1 - o2).get() *
                Arrays.stream(sizes).map(arr -> Math.max(arr[0], arr[1])).max((o1, o2) -> o1 - o2).get();
    }

    public static void main(String[] args) {
        int[][] a = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        solution(a);
    }
}
