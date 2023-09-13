package programmers_prac;

public class lessons172928 {
    private static final char OBSTACLE = 'X';
    private static final char START_POSITION = 'S';

    public void move(int[] dogPosition, String direction, int distance) {
        switch (direction) {
            case "E":
                dogPosition[1] = dogPosition[1] + distance;
                return;
            case "W":
                dogPosition[1] = dogPosition[1] - distance;
                return;
            case "S":
                dogPosition[0] = dogPosition[0] + distance;
                return;
            case "N":
                dogPosition[0] = dogPosition[0] - distance;
                return;
            default:
                throw new IllegalStateException("direction isn't allowed.");
        }
    }

    public boolean isDestinationInPark(char[][] parkArray, int[] dogPosition, String direction, int distance) {
        int dogRowPosition = dogPosition[0];
        int dogColumnPosition = dogPosition[1];

        switch (direction) {
            case "E":
                int maxColumnPosition = parkArray[0].length - 1;

                return dogColumnPosition + distance <= maxColumnPosition;
            case "W":
                return dogColumnPosition - distance >= 0;
            case "S":
                int maxRowPosition = parkArray.length - 1;

                return dogRowPosition + distance <= maxRowPosition;
            case "N":
                return dogRowPosition - distance >= 0;
            default:
                throw new IllegalStateException("direction isn't allowed.");
        }
    }

    public boolean isNotDestinationInPark(char[][] parkArray, int[] dogPosition, String direction, int distance) {
        return !isDestinationInPark(parkArray, dogPosition, direction, distance);
    }

    public boolean anyObstaclesInPath(char[][] parkArray, int[] dogPosition, String direction, int distance) {
        int dogRowPosition = dogPosition[0];
        int dogColumnPosition = dogPosition[1];


        switch (direction) {
            case "E":
                while (dogColumnPosition <= dogPosition[1] + distance) {
                    if (parkArray[dogRowPosition][dogColumnPosition] == OBSTACLE) {
                        return true;
                    }

                    dogColumnPosition++;
                }

                return false;
            case "W":
                while (dogColumnPosition >= dogPosition[1] - distance) {
                    if (parkArray[dogRowPosition][dogColumnPosition] == OBSTACLE) {
                        return true;
                    }

                    dogColumnPosition--;
                }

                return false;
            case "S":
                while (dogRowPosition <= dogPosition[0] + distance) {
                    if (parkArray[dogRowPosition][dogColumnPosition] == OBSTACLE) {
                        return true;
                    }

                    dogRowPosition++;
                }

                return false;
            case "N":
                while (dogRowPosition >= dogPosition[0] - distance) {
                    if (parkArray[dogRowPosition][dogColumnPosition] == OBSTACLE) {
                        return true;
                    }

                    dogRowPosition--;
                }

                return false;
            default:
                throw new IllegalStateException("direction isn't allowed.");
        }
    }

    public int[] getStartPosition(char[][] parkArray) {
        for (int i = 0; i < parkArray.length; i++) {
            for (int j = 0; j < parkArray[i].length; j++) {
                char parkCell = parkArray[i][j];

                if (parkCell == START_POSITION) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalStateException("start position isn't exists.");
    }

    public char[][] makeParkArray(String[] park) {
        char[][] parkArray = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            String parkRow = park[i];
            parkArray[i] = parkRow.toCharArray();
        }

        return parkArray;
    }

    public int[] solution(String[] park, String[] routes) {
        char[][] parkArray = makeParkArray(park);
        int[] dogPosition = getStartPosition(parkArray);

        for (String route : routes) {
            String[] routeInfo = route.split(" ");
            String direction = routeInfo[0];
            int distance = Integer.parseInt(routeInfo[1]);

            if (isNotDestinationInPark(parkArray, dogPosition, direction, distance) || anyObstaclesInPath(parkArray, dogPosition, direction, distance)) {
                continue;
            }

            move(dogPosition, direction, distance);
        }

        return dogPosition;
    }
}
