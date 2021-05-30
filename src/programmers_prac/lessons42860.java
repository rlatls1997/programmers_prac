package programmers_prac;
//탐욕법(Greedy) > 조이스틱

public class lessons42860 {
    public static int solution(String name) {
        int answer = 0;
        char[] nameChar = name.toCharArray();
        int index = 0;
        int beforeIndex = 0;
        for (char c : nameChar) {
            answer += ('N' < c) ? 91 - c : c - 'A';
        }
        nameChar[index] = 'A';

        while (true) {
            beforeIndex = index;
            int index1 = findNearIndexNotAToRight(nameChar, beforeIndex);
            int index2 = findNearIndexNotAToLeft(nameChar, beforeIndex);

            int index1Dis = getDistance(index, index1, nameChar.length);
            int index2Dis = getDistance(index, index2, nameChar.length);

            index = (index1Dis <= index2Dis) ? index1 : index2;
            nameChar[index] = 'A';

            answer += getDistance(index, beforeIndex, nameChar.length);
            if (isCorrect(nameChar)) {
                break;
            }
        }
        return answer;
    }

    public static int getDistance(int index, int beforeIndex, int arrLength) {
        int roundDistance = (index < beforeIndex) ? getDistanceWithRounding(index, beforeIndex, arrLength) :
                getDistanceWithRounding(beforeIndex, index, arrLength);
        int normalDistance = Math.abs(index - beforeIndex);
        return (roundDistance > normalDistance) ? normalDistance : roundDistance;
    }

    public static int getDistanceWithRounding(int smallerIndex, int largerIndex, int arrLength) {
        int distance = 0;
        while (smallerIndex != largerIndex % arrLength) {
            largerIndex++;
            distance++;
        }
        return distance;
    }

    public static int findNearIndexNotAToRight(char[] nameChar, int index) {
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[index % nameChar.length] != 'A') {
                break;
            }
            index++;
        }
        return index % nameChar.length;
    }

    public static int findNearIndexNotAToLeft(char[] nameChar, int index) {
        for (int i = 0; i < nameChar.length; i++) {
            if (index == -1) {
                index = nameChar.length -1;
            }
            if (nameChar[index % nameChar.length] != 'A') {
                break;
            }
            index--;
        }
        return index;
    }

    public static boolean isCorrect(char[] nameChar) {
        for (char c : nameChar) {
            if (c != 'A') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solution("ZZZAAAZ");
    }
}
