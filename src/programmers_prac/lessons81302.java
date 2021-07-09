package programmers_prac;

//2021 카카오 채용연계형 인턴십
//거리두기 확인하기
public class lessons81302 {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int k = 0; k < places.length; k++) {
            String[] place = places[k];
            char[][] seats = new char[5][5];
            for (int i = 0; i < place.length; i++) {
                seats[i] = place[i].toCharArray();
            }
            answer[k] = 1;
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    if (seats[i][j] == 'P') {
                        if (!checkSeat(i, j, seats)) {
                            answer[k] = 0;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public boolean checkSeat(int x1, int y1, char[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'P' && distance(x1, y1, i, j) <= 2 && distance(x1, y1, i, j) >= 1) {
                    if (!checkPartition(x1, y1, i, j, distance(x1, y1, i, j), seats)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkPartition(int x1, int y1, int x2, int y2, int distance, char[][] seats) {
        if (distance == 1) {
            return false;
        } else {
            if (x1 != x2 && y1 != y2) {
                int addY = (y2 > y1) ? 1 : -1;
                int addX = (x2 > x1) ? 1 : -1;

                if (seats[x1 + addX][y1] == 'X' && seats[x1][y1 + addY] == 'X') {
                    return true;
                }
                return false;
            } else {
                if (x1 == x2) {
                    int addY = (y2 > y1) ? 1 : -1;
                    if (seats[x1][y1 + addY] == 'X') {
                        return true;
                    }
                    return false;
                } else {
                    int addX = (x2 > x1) ? 1 : -1;
                    if (seats[x1 + addX][y1] == 'X') {
                        return true;
                    }
                    return false;
                }
            }
        }
    }

    public int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
