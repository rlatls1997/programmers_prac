package baekjoon_prac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 28445 > 알록달록 앵무새
public class boj28445 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String[] fatherColors = s.nextLine().split(" ");
		String[] motherColors = s.nextLine().split(" ");

		String[] parentColors = {fatherColors[0], fatherColors[1], motherColors[0], motherColors[1]};

		Set<String> childColors = new HashSet<>();
		addChildColor(childColors, parentColors, 0, 2, "");

		childColors.stream()
			.sorted()
			.forEach(System.out::println);
	}

	private static void addChildColor(Set<String> childColors, String[] parentColors, int depth, int r, String color) {
		if (depth == r) {
			childColors.add(color);
			return;
		}

		for (String parentColor : parentColors) {
			String newColor = color.isEmpty() ? parentColor : color + " " + parentColor;
			addChildColor(childColors, parentColors, depth + 1, r, newColor);
		}
	}
}

