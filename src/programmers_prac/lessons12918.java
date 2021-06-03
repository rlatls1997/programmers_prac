package programmers_prac;
//연습문제 > 문자열 다루기 기본
public class lessons12918 {
    public boolean solution(String s) {
        boolean answer = true;
        try{
            if(s.length() == 4 || s.length() == 6){
                Integer.parseInt(s);
            }else{
                return false;
            }
        }catch(Exception e){
            answer = false;
        }
        return answer;
    }
}
