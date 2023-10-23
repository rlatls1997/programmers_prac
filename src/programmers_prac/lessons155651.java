package programmers_prac;

// 연습문제 > 호텔 대실
public class lessons155651 {
	private static final int CLEANING_MINUTES = 10;

	public int solution(String[][] book_time) {
		int answer = 0;

		int[][] bookMinuteTimes = new int[book_time.length][2];

		for (int i = 0; i < book_time.length; i++) {
			bookMinuteTimes[i][0] = makeMinute(book_time[i][0]);
			bookMinuteTimes[i][1] = makeMinute(book_time[i][1]);
		}

		for (int i = 0; i < 24 * 60; i++) {
			int count = 0;

			for (int[] bookMinuteTime : bookMinuteTimes) {
				if (bookMinuteTime[0] <= i && i < bookMinuteTime[1] + CLEANING_MINUTES) {
					count++;
				}
			}

			answer = Math.max(answer, count);
		}

		return answer;
	}

	private int makeMinute(String hhMM) {
		String[] hhMMArray = hhMM.split(":");

		return Integer.parseInt(hhMMArray[0]) * 60 + Integer.parseInt(hhMMArray[1]);
	}
}
