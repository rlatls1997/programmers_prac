package programmers_prac;
//2019 KAKAO BLIND RECRUITMENT
//후보키
import java.util.HashSet;
import java.util.Set;

public class lessons42890 {
    public static int solution(String[][] relation) {
        int answer = 0;
        Set<Set<Integer>> candidateKeys = new HashSet<>();
        boolean[] visited = new boolean[relation[0].length];

        for (int i = 1; i <= relation[0].length; i++) {
            answer += numOfCandidateKey(relation, visited, 0, relation[0].length, i, candidateKeys);
        }
        return answer;
    }

    public static int numOfCandidateKey(String[][] relation, boolean[] visited, int depth, int n, int r, Set<Set<Integer>> candidateKeys) {
        int numOfCandidateKey = 0;

        if (r == 0) {
            Set<String> keyOfTuples = new HashSet<>();
            Set<Integer> keySet = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                String candidateKey = "";
                for (int j = 0; j < visited.length; j++) {
                    if (visited[j]) {
                        candidateKey += relation[i][j] + " ";
                        keySet.add(j);
                    }
                }
                keyOfTuples.add(candidateKey);
            }
            if (keyOfTuples.size() == relation.length && isKeyMinimalAndUnique(candidateKeys, keySet)) {
                candidateKeys.add(keySet);
                return 1;
            }
            return 0;
        }

        if (depth == n) {
            return 0;
        }

        visited[depth] = true;
        numOfCandidateKey += numOfCandidateKey(relation, visited, depth + 1, n, r - 1, candidateKeys);
        visited[depth] = false;
        numOfCandidateKey += numOfCandidateKey(relation, visited, depth + 1, n, r, candidateKeys);

        return numOfCandidateKey;
    }

    public static boolean isKeyMinimalAndUnique(Set<Set<Integer>> candidateKeys, Set<Integer> keySet) {
        for (Set<Integer> existKey : candidateKeys) {
            if (keySet.containsAll(existKey)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };

        solution(arr);
    }
}
