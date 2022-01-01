package baekjoon_prac;
//1011
//Fly me to the Alpha Centauri
import java.util.Scanner;

public class boj1011 {
    static int getMinimumMove(int x, int y) {
        int distance = y - x;
        int move = 1;
        int time = 0;

        while (distance / 2 >= move) {
            distance -= move * 2;
            time += 2;
            move++;
        }
        if (1 <= distance && distance <= move) {
            time++;
        } else if (move < distance) {
            time += 2;
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int x = s.nextInt();
            int y = s.nextInt();

            System.out.println(getMinimumMove(x, y));
        }
    }
}
