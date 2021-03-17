//2019카카오개발자 겨울인턴십 > 크레인 인형뽑기
package programmers_prac;

import java.util.ArrayList;

public class lessons64061 {
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;			//정답(지워진 인형의 개수)	
        int erazedDoll = 0;		//지워진 인형의 개수
        
        ArrayList<Integer> stack = new ArrayList<Integer>();	//뽑은 인형을 저장하는 스택
        
        //입력된 moves의 배열내용대로 인형뽑기
        for(int i = 0; i<moves.length; i++) {
        	int depth = 0;	//집게의 깊이
        	
        	//맨 위층부터 검사하며 인형이 있는지 조사, 인형이 없다면 집게의 깊이 + 1
        	while(board[depth][moves[i] -1] == 0 ) {
        		depth++;
        		//집게가 맨 밑칸에 도달하면 break
        		if(depth == (board.length -1)) {
        			break;
        		}
        	}
        	
        	//집게의 위치에 인형이 있다면
        	if(board[depth][moves[i] -1] != 0) {
        		
        		
        		//인형을 스택에 추가
        		stack.add(board[depth][moves[i] -1]);
        		
        		//인형을 뽑은 위치에 인형 없애기
        		board[depth][moves[i] -1] = 0;
        		
        		//스택의 맨 위에 방금 전 뽑은 인형과 동일한 인형이 있다면
        		if(stack.size() > 1 && (stack.get(stack.size() -2) == stack.get(stack.size() -1))) {
        			//위에서부터 인형 2개 지우기
        			stack.remove(stack.size()-1);
        			stack.remove(stack.size()-1);
        			
        			//지워진 인형개수 +2
        			erazedDoll += 2;
        		}
        	}
        }
        answer = erazedDoll;
        return answer;
    }

	public static void main(String[] args) {

		int [][]board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};

		System.out.println(solution(board, moves));



	}

}
