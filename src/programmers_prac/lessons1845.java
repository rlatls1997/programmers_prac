package programmers_prac;

import java.util.HashSet;
import java.util.Set;

//찾아라 프로그래밍 마에스터 > 폰켓몬
public class lessons1845 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return (set.size() < nums.length / 2) ? set.size() : nums.length / 2;
    }

    public static void main(String[] args) {

    }
}
