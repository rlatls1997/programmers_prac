package programmers_prac;

import java.util.ArrayList;
import java.util.Collections;

public class test {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("hello");
		boolean ok = false;
		ok = false;
		ok = false;
		sb.reverse();

		ArrayList<String> stringArr = new ArrayList<String>();

		stringArr.add("3914");
		stringArr.add("39aa");
		stringArr.add("3213");
		stringArr.add("2910");
		for(String a : stringArr) {
			System.out.println(a);
		}

		Collections.sort(stringArr);
		for(String a : stringArr) {
			System.out.println(a);
		}
		System.out.println('9' > 'a');
	}

}
