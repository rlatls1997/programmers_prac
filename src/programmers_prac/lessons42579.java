package programmers_prac;
//해시 > 베스트앨범
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lessons42579 {
	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		Map<String, ArrayList<Integer[]>> hm = new HashMap<>();
		Map<String, Integer> playTime = new HashMap<>();

		Set<String> genreSet = new HashSet<>();
		for (String genre : genres) {
			genreSet.add(genre);
		}
		for (String genre : genreSet) {
			ArrayList<Integer[]> list = new ArrayList<>();
			hm.put(genre, list);
		}

		for (int i = 0; i < genres.length; i++) {
			Integer[] song = new Integer[2];
			song[0] = i;
			song[1] = plays[i];
			playTime.put(genres[i], playTime.getOrDefault(genres[i], 0) + plays[i]);
			hm.get(genres[i]).add(song);
		}

		String[][] arr = new String[playTime.size()][2];
		int index = 0;
		for (String key : playTime.keySet()) {
			arr[index][0] = key;
			arr[index][1] = "" + playTime.get(key);
			index++;
		}
		Arrays.sort(arr, (o1, o2) -> {
			if (Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])) {
				return -1;
			} else
				return 1;
		});

		ArrayList<Integer> bestAlbum = new ArrayList<>();

		for (String[] ar : arr) {
			ArrayList<Integer[]> al = hm.get(ar[0]);
			Collections.sort(al, (o1, o2) -> {
				if (o1[1] > o2[1]) {
					return -1;
				} else {
					return 1;
				}
			});
			bestAlbum.add(al.get(0)[0]);
			if (al.size() > 1) {
				bestAlbum.add(al.get(1)[0]);
			}
		}
		answer = new int[bestAlbum.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = bestAlbum.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		solution(genres, plays);
	}
}