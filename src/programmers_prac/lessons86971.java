package programmers_prac;
//위클리챌린지_9주차_전력망을 둘로 나누기

import java.util.ArrayList;
import java.util.List;

public class lessons86971 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int poll1 = wires[i][0];
            int poll2 = wires[i][1];

            boolean[] isVisited1 = new boolean[wires.length];
            boolean[] isVisited2 = new boolean[wires.length];

            int numOfConnectedPollWithPoll1 = getNumOfConnectedPoll(poll1, i, wires, isVisited1);
            int numOfConnectedPollWithPoll2 = getNumOfConnectedPoll(poll2, i, wires, isVisited2);
            int differ = Math.abs(numOfConnectedPollWithPoll1 - numOfConnectedPollWithPoll2);
            answer = (differ < answer) ? differ : answer;
        }
        return answer;
    }

    public int getNumOfConnectedPoll(int poll,int index, int[][] wires, boolean[] isVisited) {
        int numOfConnectedPoll = 0;
        isVisited[index] = true;

        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            if ((wire[0] == poll || wire[1] == poll) && !isVisited[i]) {
                int connectedPoll = wire[0] == poll ? wire[1] : wire[0];
                numOfConnectedPoll++;
                numOfConnectedPoll += getNumOfConnectedPoll(connectedPoll, i, wires, isVisited);
            }
        }
        return numOfConnectedPoll;
    }
}
