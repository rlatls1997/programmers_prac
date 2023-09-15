// 연습문제 > 둘만의 암호
package programmers_prac;

public class lessons155652 {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char alphabet : s.toCharArray()) {
            for (int i = 0; i < index; ) {
                alphabet = (char) ((alphabet - 'a' + 1) % ('z' - 'a' + 1) + 'a');
                i = skip.indexOf(alphabet) == -1 ? i + 1 : i;
            }

            answer.append(alphabet);
        }

        return answer.toString();
    }
}
