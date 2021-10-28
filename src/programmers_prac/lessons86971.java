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

            List<int[]> clonedWires1 = cloneWires(i, wires);
            List<int[]> clonedWires2 = cloneWires(i, wires);

            int numOfConnectedPollWithPoll1 = getNumOfConnectedPoll(poll1, clonedWires1);
            int numOfConnectedPollWithPoll2 = getNumOfConnectedPoll(poll2, clonedWires2);
            int differ = Math.abs(numOfConnectedPollWithPoll1-numOfConnectedPollWithPoll2);
            answer = (differ < answer)? differ : answer;
        }
        return answer;
    }

    public int getNumOfConnectedPoll(int poll, List<int[]> clonedWires) {
        int numOfConnectedPoll = 0;
        while (true) {
            boolean isConnectedPollExists = false;
            for (int i = 0; i < clonedWires.size(); i++) {
                int[] wire = clonedWires.get(i);
                if (wire[0] == poll || wire[1] == poll) {
                    int connectedPoll = wire[0] == poll ? wire[1] : wire[0];
                    clonedWires.remove(i);
                    numOfConnectedPoll++;
                    numOfConnectedPoll += getNumOfConnectedPoll(connectedPoll, clonedWires);
                    isConnectedPollExists = true;
                }
            }
            if (!isConnectedPollExists) {
                break;
            }
        }
        return numOfConnectedPoll;
    }

    public List<int[]> cloneWires(int exceptedIndex, int[][] wires) {
        List<int[]> clonedWires = new ArrayList<>();
        for (int i = 0; i < wires.length; i++) {
            if (i != exceptedIndex) {
                clonedWires.add(new int[]{wires[i][0], wires[i][1]});
            }
        }
        return clonedWires;
    }
}
