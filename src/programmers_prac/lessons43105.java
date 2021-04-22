//동적계획법(Dynamic Programming) > 정수 삼각형
package programmers_prac;

public class lessons43105 {
	public static int solution(int[][] triangle) {
        int answer = 0;

        int [] arr = new int[triangle[triangle.length-1].length];
        int [] tmp = new int[triangle[triangle.length-1].length];
        arr[0] = triangle[0][0];

        for(int i = 1; i<triangle.length; i++) {
        	for(int j = 0; j<triangle[i].length; j++) {
        		int over;
        		//맨 왼쪽 원소일 경우
        		if(j == 0) {
        			over = arr[j];
        		}
        		//맨 오른쪽 원소일 경우
        		else if(j == triangle[i].length -1) {
        			over = arr[triangle[i].length -2];
        		}
        		//그 외의 경우
        		else {
        			//윗층 원소 중 더 큰 값 get
        			over = (arr[j] > arr[j-1])? arr[j]:arr[j-1];
        		}
        		//임시배열에 현 위치까지의 합 중 가장 큰 값 저장
        		tmp[j] = over + triangle[i][j];
        	}
        	//배열 복사
        	for(int j = 0; j<tmp.length; j++) {
        		arr[j] = tmp[j];
        	}
        }
        //최댓값 구하기
        for(int max : arr) {
        	if(max > answer)
        		answer = max;
        }
        return answer;
    }
	public static void main(String[] args) {
		int [][] arr = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(solution(arr));
	}

}
