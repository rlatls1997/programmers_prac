package programmers_prac;
//연습문제
//2 x n 타일링
public class lessons12900 {
    public int solution(int n) {
        int [] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for(int i = 2; i<arr.length; i++){
            arr[i] = (arr[i-1] + arr[i-2])%1000000007;
        }
        return arr[n-1];
    }
}
