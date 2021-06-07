package programmers_prac;
//연습문제 > 콜라츠 추측
public class lessons12943 {
    public int solution(int num) {
        long number = num;
        int i ;
        for(i = 0; i<500; i++){
            if(number == 1){
                break;
            }
            if(number%2 == 0){
                number /= 2;
            }else{
                number  = number*3 + 1;
            }
        }
        if(number != 1){
            return -1;
        }
        return i;
    }
}
