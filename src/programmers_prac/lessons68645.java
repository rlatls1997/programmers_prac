//월간 코드 챌린지 시즌1 > 삼각 달팽이
package programmers_prac;

public class lessons68645 {
	public static int[] solution(int n) {
		int[] answer = {};

		//최외곽삼각형의 한 변의 길이
		int side = n;
		//사각형의 총 개수
		int nums = n*(n+1) / 2;
		//사각형의 개수만큼 배열 초기화
		answer = new int[nums];

		//삽입할 값
		int num = 1;
		while(num <= nums) {
			//최외각에서 몇번째 삼각형에 위치하는지 저장
			int outer = 1;
			//현새 삼각형의 한변의 길이
			int sideOfTriangle = side;
			//최외각삼각형의 사각형개수
			int numOfsquares = (sideOfTriangle == 1)? 1 : 3*(sideOfTriangle-1);
			//이전 삼각형에서의 사각형 최댓값 구하기
			int maxValue = 0;

			while(true) {
				if(num <= numOfsquares) {
					break;
				}
				maxValue = numOfsquares;
				sideOfTriangle -=3;
				//사각형 하나만 남아있을 경우에는 사각형의 개수에 1을 더해줌
				if(sideOfTriangle == 1) {
					numOfsquares += 1;
				}
				numOfsquares += 3*(sideOfTriangle-1);
				outer++;
			}

			//num이 몇층에 있는지 나타내는 값
			int floor = 0;
			//num이 왼족에서 몇번째에 있는지 나타내는 값
			int locationFromLeft = 0;
			//num이 삼각형의 왼쪽변에 위치하는 경우
			if(num <= sideOfTriangle + maxValue) {
				locationFromLeft = outer;
				floor = (side-2*(outer-1))-(num - maxValue -1);
			}
			//num이 삼각형의 밑변에 위치하는 경우
			else if(num <=  maxValue+ 2*sideOfTriangle-1) {
				floor = outer;
				locationFromLeft = outer + (num - (maxValue+sideOfTriangle));
			}
			//num이 삼각형의 오른쪽변에 위치하는 경우
			else {
				floor = num - (maxValue+ 2*sideOfTriangle-1) + outer;
				locationFromLeft = (side-floor+2) - outer;
			}
			//num을 삽입할 위치
			int lengthFromTop = side - floor;
			int index = (lengthFromTop*(lengthFromTop+1)/2)+locationFromLeft-1;

			answer[index] = num;
			num++;
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(1);
	}
}
