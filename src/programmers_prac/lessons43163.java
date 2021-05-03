// 깊이/너비 우선 탐색(DFS/BFS) > 단어 변환
package programmers_prac;

public class lessons43163 {
	public static int solution(String begin, String target, String[] words) {
		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			// begin과 한 글자만 다른 단어일 경우
			if (diffOne(begin, words[i])) {
				int[] visited = new int[words.length];
				// 방문한 단어에 추가하고 dfs호출
				int calledTime = dfs(words[i], target, words, visited, 1, i);
				if (calledTime < answer) {
					answer = calledTime;
				}
			}
		}
		if (answer == Integer.MAX_VALUE)
			return 0;
		return answer;
	}

	public static int dfs(String begin, String target, String [] words, int[] visited, int depth,int loc) {
		if (begin.equals(target)) {
			return depth;
		}
		if(visited[loc] == 1) {
			return depth;
		}
		visited[loc] = 1;
		int find = 0;

		for (int i = 0; i < words.length; i++) {
			// 방문하지 않은 단어라면
			if (visited[i] != 1) {
				// begin과 한 글자만 다른 단어일 경우
				if (diffOne(begin, words[i])) {
					System.out.println(depth+", "+words[i]);
					find =  dfs(words[i], target, words, visited, depth + 1, i);
				}
			}
		}
		// 한 문자만 다른 단어가 없을 경우
		return find;
	}
	public static boolean diffOne(String a , String b) {
		boolean diffOne = false;
		for (int j = 0; j < a.length(); j++) {
			if (a.charAt(j) != b.charAt(j)) {
				if (diffOne) {
					diffOne = false;
					break;
				}
				diffOne = true;
			}
		}
		return diffOne;
	}

	public static void main(String[] args) {
		String[] arr = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution("hit", "cog", arr));
	}
}
