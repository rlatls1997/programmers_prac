package programmers_prac;

import java.util.ArrayList;
import java.util.List;

public class lessons84512 {
    public static int solution(String word) {
        List<String> myStr = new ArrayList<>();
        getStringByTime(myStr, 5, true);
        myStr.sort((o1, o2) -> o1.compareTo(o2));

        return myStr.indexOf(word)+1;
    }

    public static void getStringByTime(List<String> myStr, int time, boolean first) {
        if (time == 0) {
            return;
        }
        List<String> strTmp = new ArrayList<>();
        String[] padArr = {"A", "E", "I", "O", "U"};
        for(String str : padArr){
            strTmp.add(str);
        }

        for (String str : padArr) {
            for (String curStr : myStr) {
                strTmp.add(str + curStr);
            }
        }
        myStr.clear();
        for(String str : strTmp){
            myStr.add(str);
        }
        getStringByTime(myStr, time - 1, false);
    }

    public static void main(String[] args) {
        List<String> myStr = new ArrayList<>();
        getStringByTime(myStr, 5, true);
        myStr.sort((o1, o2) -> o1.compareTo(o2));
        for (String b : myStr) {
            System.out.println(b);
        }
    }
}

