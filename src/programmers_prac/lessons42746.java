//정렬 > 가장 큰 수
package programmers_prac;

import java.util.Arrays;
import java.util.Comparator;

public class lessons42746 {

	public static String solution(int[] numbers) {
        String answer = "";

        //int형 numbers를 string으로 바꾸어 저장할 배열 생성
        String [] str = new String[numbers.length];

        //numbers의 각 원소를 string으로 바꾸어 str에 저장
        for(int i = 0; i<numbers.length; i++) {
        	str[i] = String.valueOf(numbers[i]);
        }

        //Arrays클래스의 sort 메소드를 사용
        //배열 정렬
        Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//문자열을 앞, 뒤로 붙여서 더 큰 것을 return
				return (o2 + o1).compareTo(o1 + o2);
			}

        });
        //정렬된 배열의 첫 원소가 0일경우 0 반환
        if(str[0].equals("0")) {
        	return "0";
        }
        //answer에 답 나열
        for(String element : str) {
        	answer += element;
        }

        return answer;
    }

	public static void main(String[] args) {
		int [] arr = {6, 10 ,2};
		System.out.println(solution(arr));
		int [] arr2 = {3, 30, 34 , 5, 9};

		System.out.println(solution(arr2));


	}

}
