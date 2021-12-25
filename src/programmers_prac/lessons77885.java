package programmers_prac;

//월간 코드 챌린지 시즌2
//2개 이하로 다른 비트
public class lessons77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = getFx(numbers[i]);
        }

        return answer;
    }

    public long getFx(long number) {
        if (number % 2 == 0) {
            return number + 1;
        }
        StringBuilder binaryString = new StringBuilder("0" + Long.toBinaryString(number));

        int lastIndexOfZero = binaryString.lastIndexOf("0");
        binaryString.replace(lastIndexOfZero, lastIndexOfZero + 1, "1");
        binaryString.replace(lastIndexOfZero + 1, lastIndexOfZero + 2, "0");

        return Long.parseLong(binaryString.toString(), 2);
    }
}
