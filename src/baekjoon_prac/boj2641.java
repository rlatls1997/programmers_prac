package baekjoon_prac;
//2641
//다각형그리기

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class boj2641 {
	private static final String UP = "2";
	private static final String DOWN = "4";
	private static final String RIGHT = "1";
	private static final String LEFT = "3";

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int sequenceLength = s.nextInt();
		s.nextLine();

		String representativeSequence = s.nextLine();

		int candidateCount = s.nextInt();
		s.nextLine();

		List<String> representativeDirectionInfo = getDirectionInfo(representativeSequence);
		List<String> reversedRepresentativeDirectionInfo = getReversedDirectionInfo(representativeDirectionInfo);

		List<String> sameDirection = new ArrayList<>();

		for (int i = 0; i < candidateCount; i++) {
			String candidateSequence = s.nextLine();
			List<String> candidateDirectionInfo = getDirectionInfo(candidateSequence);

			if (isSamePattern(representativeDirectionInfo, candidateDirectionInfo, sequenceLength) || isSamePattern(reversedRepresentativeDirectionInfo, candidateDirectionInfo, sequenceLength)) {
				sameDirection.add(candidateSequence);
			}
		}

		System.out.print(sameDirection.size());

		for (String direction : sameDirection) {
			System.out.println();
			System.out.print(direction);
		}
	}

	private static boolean isSamePattern(List<String> standardPattern, List<String> pattern, int sequenceLength) {
		for (int i = 0; i < sequenceLength; i++) {
			if (isSameAllElements(standardPattern, pattern)) {
				return true;
			}

			String lastElement = pattern.remove(pattern.size() - 1);
			pattern.add(0, lastElement);
		}

		return false;
	}

	private static boolean isSameAllElements(List<String> standardPattern, List<String> pattern) {
		for (int i = 0; i < standardPattern.size(); i++) {
			if (!standardPattern.get(i).equals(pattern.get(i))) {
				return false;
			}
		}

		return true;
	}

	private static List<String> getReversedDirectionInfo(List<String> directionInfo) {
		List<String> reversedDirectionInfo = new ArrayList<>();

		for (String direction : directionInfo) {
			String reversedDirection = getReversedDirection(direction);
			reversedDirectionInfo.add(0, reversedDirection);
		}

		return reversedDirectionInfo;
	}

	private static String getReversedDirection(String direction) {
		switch (direction) {
			case UP:
				return DOWN;
			case DOWN:
				return UP;
			case LEFT:
				return RIGHT;
			case RIGHT:
				return LEFT;
			default:
				throw new IllegalArgumentException("unsupported direction");
		}
	}

	private static List<String> getDirectionInfo(String sequence) {
		return Arrays.stream(sequence.split(" ")).collect(Collectors.toList());
	}
}
