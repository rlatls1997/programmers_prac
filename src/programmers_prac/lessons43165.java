//깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버
package programmers_prac;

public class lessons43165 {
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = recursion(numbers, target, 0, 0);
        return answer;
    }
	public static int recursion(int [] numbers, int target, int depth, int result) {
		int k = 0;
		if(depth == numbers.length) {
			if(result == target) {
				return 1;
			}
				return 0;
		}
		k += recursion(numbers, target, depth+1, result + numbers[depth]);
		k += recursion(numbers, target, depth+1, result - numbers[depth]);

		return k;
	}
	public static void main(String[] args) {
		int [] arr = {1, 1, 1, 1, 1};
		System.out.println(solution(arr, 3));
	}

}
