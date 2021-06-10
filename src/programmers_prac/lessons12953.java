package programmers_prac;

import java.util.HashMap;
import java.util.Map;

//연습문제 > N개의 최소공배수
public class lessons12953 {
    public static int solution(int[] arr) {
        int answer = 1;
        Map<Integer, Integer> allPrimeFactor = new HashMap<>();

        for(int number : arr){
            Map<Integer, Integer> primeFactor = getPrimeFactor(number);

            for(int key : primeFactor.keySet()){
                if(allPrimeFactor.getOrDefault(key, 0) < primeFactor.get(key)){
                    allPrimeFactor.put(key, primeFactor.get(key));
                }
            }
        }
        for(int key : allPrimeFactor.keySet()){
            answer *= Math.pow(key, allPrimeFactor.get(key));
        }
        return answer;
    }
    public static Map<Integer, Integer> getPrimeFactor(int number){
        Map<Integer, Integer> primeFactor = new HashMap<>();

        while(number != 1){
            for(int i = 2; i<=number; i++){
                if(number % i == 0){
                    primeFactor.put(i, primeFactor.getOrDefault(i, 0) + 1);
                    number /= i;
                    break;
                }
            }
        }
        return primeFactor;
    }

    public static void main(String[] args) {
        int [] arr = {2,6,8,14};
        solution (arr);
    }
}
