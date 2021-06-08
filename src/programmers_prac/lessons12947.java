package programmers_prac;
//연습문제 > 하샤드 수
public class lessons12947 {
    public boolean solution(int x) {
        boolean answer = true;
        int sumAllDigit = 0;
        for(char digit : (x+"").toCharArray()){
            sumAllDigit += Integer.parseInt(digit+"");
        }
        if(x % sumAllDigit != 0){
            return false;
        }
        return answer;
    }
}
