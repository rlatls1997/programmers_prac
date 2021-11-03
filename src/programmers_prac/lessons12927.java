package programmers_prac;
//연습문제_야근지수
import java.util.Collections;
import java.util.PriorityQueue;

public class lessons12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> worksQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            worksQueue.add(work);
        }
        for (int i = 0; i < n; i++) {
            int importantWork = worksQueue.poll();
            if (importantWork == 0) {
                return 0;
            }
            worksQueue.add(--importantWork);
        }
        for (int work : worksQueue) {
            answer += work * work;
        }
        return answer;
    }
}
