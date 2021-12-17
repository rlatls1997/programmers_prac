package programmers_prac;
//Summer/Winter Coding(~2018)_소수 만들기
public class lessons12977 {
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        return numOfPrimeNumber(0, 0, nums, visited, 0);
    }

    public int numOfPrimeNumber(int index, int sum, int[] nums, boolean[] visited, int depth) {
        int numOfPrimeNumber = 0;
        if (depth == 3) {
            if (isPrimeNumber(sum)) {
                return 1;
            }
            return 0;
        }
        for (int i = index; i < nums.length; i++) {
            visited[i] = true;
            numOfPrimeNumber += numOfPrimeNumber(i + 1, sum + nums[i], nums, visited, depth + 1);
            visited[i] = false;
        }
        return numOfPrimeNumber;
    }

    public boolean isPrimeNumber(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
