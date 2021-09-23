//위클리 챌린지_7주차
package programmers_prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lessons86048 {
    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        int commonSize = enter.length;
        List<Integer> enterList = new ArrayList<>();
        List<Integer> leaveList = new ArrayList<>();

        for (int e : enter) {
            enterList.add(e);
        }
        for (int l : leave) {
            leaveList.add(l);
        }
        for (int i = 1; i < commonSize + 1; i++) {
            int enterIndex = enterList.indexOf(i);
            int leaveIndex = leaveList.indexOf(i);
            List<int[]> indexOfEncountered = new ArrayList<>();
            Set<Integer> encounteredNum = new HashSet<>();

            for (int j = 1; j < commonSize + 1; j++) {
                int otherEnterIndex = enterList.indexOf(j);
                int otherLeaveIndex = leaveList.indexOf(j);

                if ((otherEnterIndex > enterIndex && otherLeaveIndex < leaveIndex)
                        || (otherEnterIndex < enterIndex && otherLeaveIndex > leaveIndex)) {
                    int[] encounteredIndex = new int[2];
                    encounteredIndex[0] = otherEnterIndex;
                    encounteredIndex[1] = otherLeaveIndex;
                    indexOfEncountered.add(encounteredIndex);
                    encounteredNum.add(j);
                }
            }
            for (int j = 1; j < commonSize + 1; j++) {
                if (encounteredNum.contains(j)) {
                    continue;
                }
                int otherEnterIndex = enterList.indexOf(j);
                int otherLeaveIndex = leaveList.indexOf(j);

                for (int k = 0; k < indexOfEncountered.size(); k++) {
                    int encounteredEnterIndex = indexOfEncountered.get(k)[0];
                    int encounteredLeaveIndex = indexOfEncountered.get(k)[1];
                    if (otherEnterIndex > enterIndex && otherEnterIndex < encounteredEnterIndex) {
                        encounteredNum.add(j);
                        break;
                    } else if (otherLeaveIndex < leaveIndex && otherLeaveIndex > encounteredLeaveIndex) {
                        encounteredNum.add(j);
                        break;
                    }
                }
            }
            answer[i - 1] = encounteredNum.size();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 3};
        int[] b = {2, 2, 1, 3};
        solution(a, b);
    }
}
