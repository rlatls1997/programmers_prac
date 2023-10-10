package baekjoon_prac;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

//5588
//별자리 찾기
public class boj5588 {

	private static class Star {
		private final int x;
		private final int y;

		public Star(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Star)) {
				return false;
			}

			Star star = (Star)o;

			return x == star.x && y == star.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.x, this.y);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int m = s.nextInt();
		Set<Star> myStars = makeStarSet(s, m);

		int n = s.nextInt();
		Set<Star> universeStars = makeStarSet(s, n);

		for (Star universeStar : universeStars) {
			Star firstMyStar = myStars.stream().findFirst().orElse(null);
			int moveX = universeStar.getX() - firstMyStar.getX();
			int moveY = universeStar.getY() - firstMyStar.getY();

			Set<Star> myNewStars = new HashSet<>();

			for (Star myStar : myStars) {
				myNewStars.add(new Star(myStar.getX() + moveX, myStar.getY() + moveY));
			}

			if (universeStars.containsAll(myNewStars)) {
				System.out.print(moveX + " " + moveY);
				break;
			}
		}
	}

	private static Set<Star> makeStarSet(Scanner s, int starCount) {
		Set<Star> starSet = new HashSet<>();

		for (int i = 0; i < starCount; i++) {
			int starX = s.nextInt();
			int starY = s.nextInt();

			starSet.add(new Star(starX, starY));
		}

		return starSet;
	}
}
