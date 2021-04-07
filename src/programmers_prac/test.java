package programmers_prac;

public class test {
	public static void a(int a) {
		a++;
	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("aa");
		sb.delete(0, 1);
		int a = 4;
		a(a);
		System.out.println(a);
	}

}
