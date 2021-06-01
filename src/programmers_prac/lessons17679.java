package programmers_prac;

import java.util.*;
//2018 KAKAO BLIND RECRUITMENT
//[1차] 프렌즈4블록
public class lessons17679 {
    static int removeCell = 0;

    public static int solution(int m, int n, String[] board) {
        List<LinkedList<Character>> blocks = new ArrayList<>();
        char[][] tmpArr = new char[m][n];

        for (int i = 0; i < m; i++) {
            tmpArr[i] = board[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            LinkedList<Character> columns = new LinkedList<>();
            for (int j = m - 1; j >= 0; j--) {
                columns.add(tmpArr[j][i]);
            }
            blocks.add(columns);
        }
        while (true) {
            if (!find2x2(blocks, blocks.size())) {
                break;
            }
        }
        return removeCell;
    }

    //같은 2*2 찾아서 index 저장
    public static boolean find2x2(List<LinkedList<Character>> blocks, int m) {
        List<int[]> locToDel = new ArrayList<>();
        for (int i = 0; i < blocks.size() -1; i++) {
            for (int j = 0; j < blocks.get(i).size() - 1; j++) {
                if (check2x2(blocks, i, j)) {
                    setLocToDel(locToDel, i, j);
                }
            }
        }
        if (locToDel.isEmpty()) {
            return false;
        }
        removeLocElement(locToDel, blocks);
        return true;
    }

    //해당 인덱스로부터 지워야하는 loc저장
    public static void setLocToDel(List<int[]> locToDel, int i, int j) {
        int[] loc1 = {i, j};
        int[] loc2 = {i, j + 1};
        int[] loc3 = {i + 1, j};
        int[] loc4 = {i + 1, j + 1};

        locToDel.add(loc1);
        locToDel.add(loc2);
        locToDel.add(loc3);
        locToDel.add(loc4);
    }

    //지워야할 인덱스를 갖는 locToDel로 blocks의 원소 지우기
    public static void removeLocElement(List<int[]> locToDel, List<LinkedList<Character>> blocks) {
        Set<String> alreadyRemovedLoc = new HashSet<>();

        Collections.sort(locToDel, (o1, o2) -> o2[1] - o1[1]);

        for (int[] loc : locToDel) {
            if (!alreadyRemovedLoc.contains(loc[0] + "," + loc[1])) {
                alreadyRemovedLoc.add(loc[0] + "," + loc[1]);
                blocks.get(loc[0]).remove(loc[1]);
                removeCell++;
            }
        }
    }

    //해당 원소로부터 2x2가 생기는지 검사
    public static boolean check2x2(List<LinkedList<Character>> blocks, int i, int j) {
        if (j +1 < blocks.get(i + 1).size() &&
                blocks.get(i).get(j) == blocks.get(i).get(j + 1) &&
                blocks.get(i).get(j + 1) == blocks.get(i + 1).get(j) &&
                blocks.get(i + 1).get(j) == blocks.get(i + 1).get(j + 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = {"AABBEE","AAAEEE","VAAEEV","AABBEE","AACCEE","VVCCEE"};
        solution(6, 6, arr);
    }
}