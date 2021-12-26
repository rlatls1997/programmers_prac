package programmers_prac;
//연습문제
//줄 서는 방법
import java.util.ArrayList;
import java.util.List;

public class lessons12936 {
    public static int[] solution(int n, long k) {
        int[] result = new int[n];
        List<Integer> elementList = getElementList(n);
        long kindOfLines = factorial(n);
        k--;
        int i = 0;
        while (i < n) {
            kindOfLines /= elementList.size();
            long listIndex = k / kindOfLines;
            k %= kindOfLines;
            result[i] = elementList.get((int) listIndex);
            elementList.remove((int) listIndex);
            i++;
        }

        return result;
    }

    public static long factorial(int n) {
        long result = 1;
        while (n != 0) {
            result *= n;
            n--;
        }
        return result;
    }

    public static List<Integer> getElementList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        solution(3, 5);
    }
}
