package programmers_prac;
//깊이/너비 우선 우선 탐색(DFS/BFS)_여행경로
import java.util.Arrays;

public class lessons43164 {
    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        String[] answerTmp = answer.clone();
        boolean[] isVisited = new boolean[tickets.length];

        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        findRoute(answer, answerTmp, tickets, isVisited, "ICN", 0);

        return answer;
    }

    public static boolean findRoute(String[] answer, String[] answerTmp, String[][] tickets,
                                    boolean[] isVisited, String current, int index) {
        if (index == 0) {
            answerTmp[index++] = current;
        }
        if (index == answer.length) {
            for (int i = 0; i < answerTmp.length; i++) {
                answer[i] = answerTmp[i];
            }
            return true;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && tickets[i][0].equals(current)) {
                int newIndex = index;
                String[] newAnswerTmp = answerTmp.clone();
                boolean[] newIsVisited = isVisited.clone();
                newIsVisited[i] = true;
                newAnswerTmp[newIndex++] = tickets[i][1];
                boolean findAllPath = findRoute(answer, newAnswerTmp, tickets, newIsVisited, tickets[i][1], newIndex);
                if (findAllPath) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] arr = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
        solution(arr);
    }
}
