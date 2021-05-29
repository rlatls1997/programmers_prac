package programmers_prac;
//2018 KAKAO BLIND RECRUITMENT > [1차]비밀지도
public class lessons17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String a1Binary = Integer.toBinaryString(arr1[i]);
            String a2Binary = Integer.toBinaryString(arr2[i]);
            String result = "";

            while (a1Binary.length() < n) {
                a1Binary = "0" + a1Binary;
            }
            while (a2Binary.length() < n) {
                a2Binary = "0" + a2Binary;
            }

            for (int j = 0; j < n; j++) {
                if (a1Binary.charAt(j) == '1' || a2Binary.charAt(j) == '1') {
                    result += "#";
                } else {
                    result += " ";
                }
            }
            answer[i] = result;
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println();
    }
}
