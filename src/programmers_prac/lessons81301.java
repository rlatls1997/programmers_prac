package programmers_prac;
//2021 카카오 채용연계형 인턴십
//숫자 문자열과 영단어
public class lessons81301 {
    public int solution(String s) {
        String [] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String tmp = "";
        String wordTmp = "";
        for(int i = 0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                wordTmp += s.charAt(i);
            }
            else{
                tmp += s.charAt(i);
            }
            for(int j = 0; j<numbers.length; j++){
                if(numbers[j].equals(wordTmp)){
                    tmp += j;
                    wordTmp = "";
                }
            }
        }
        return Integer.parseInt(tmp);
    }
}