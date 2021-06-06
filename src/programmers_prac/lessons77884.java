package programmers_prac;

import java.util.HashSet;
import java.util.Set;

//월간 코드 챌린지 시즌2 > 약수의 개수와 덧셈
public class lessons77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i<=right; i++){
            Set<Integer> container = new HashSet<>();
            for(int j = 1; j<=i/2; j++){
                if(i%j == 0){
                    container.add(j);
                }
            }
            answer += (container.size() %2 == 0)? -i : i;
        }
        return answer;
    }
}
