package programmers_prac;
// 2017카카오코드 본선_단체사진 찍기
public class lessons1835 {
    public static int solution(int n, String[] data) {
        String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        String[] line = new String[8];
        boolean[] visited = new boolean[8];
        int answer = lineUp(friends, line, data, visited, 0);
        return answer;
    }

    public static int lineUp(String[] friends, String[] line, String[] data, boolean[] visited, int depth) {
        int kindOfLines = 0;
        if (!isPossibleToLineUp(line, data)) {
            return 0;
        }
        if (depth == 8) {
            return 1;
        }
        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line[depth] = friends[i];
                kindOfLines += lineUp(friends, line, data, visited, depth + 1);
                visited[i] = false;
                line[depth] = null;
            }
        }
        return kindOfLines;
    }

    public static boolean isPossibleToLineUp(String[] line, String[] data) {
        for (String condition : data) {
            String one = condition.charAt(0) + "";
            String two = condition.charAt(2) + "";
            char con = condition.charAt(3);
            int num = Integer.parseInt(condition.charAt(4) + "") + 1;

            int oneIndex = getIndex(line, one);
            int twoIndex = getIndex(line, two);

            if (oneIndex == -1 || twoIndex == -1) {
                continue;
            }
            if (con == '=') {
                if (num != Math.abs(oneIndex - twoIndex)) {
                    return false;
                }
            }
            if (con == '<') {
                if (num <= Math.abs(oneIndex - twoIndex)) {
                    return false;
                }
            }
            if (con == '>') {
                if (num >= Math.abs(oneIndex - twoIndex)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getIndex(String[] line, String one) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] != null && line[i].equals(one)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] a = {"N~F=0", "R~T>2"};
        solution(2, a);
    }
}
