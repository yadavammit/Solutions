import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FavouriteGenre {
	public static void main(String[] args) {
		HashMap<String, String[]> userSongs = new HashMap<String, String[]>();
		HashMap<String, String[]> genresSong = new HashMap<String, String[]>();

		HashMap<String, String> songGenre = new HashMap<String, String>();

		HashMap<String, Integer> songCount = new HashMap<String, Integer>();

		HashMap<String, ArrayList<String>> userGenre = new HashMap<String, ArrayList<String>>();

		userSongs.put("David", new String[] { "song1", "song2", "song3", "song4", "song8" });
		userSongs.put("Emma", new String[] { "song5", "song6", "song7" });

		genresSong.put("Rock", new String[] { "song1", "song3" });
		genresSong.put("Dubstep", new String[] { "song7" });
		genresSong.put("Techno", new String[] { "song2", "song4" });
		genresSong.put("Pop", new String[] { "song5", "song6" });
		genresSong.put("Jazz", new String[] { "song8", "song9" });

		for (String genre : genresSong.keySet()) {
			for (String st : genresSong.get(genre)) {
				songGenre.put(st, genre);
			}
		}
		for (String user : userSongs.keySet()) {
			ArrayList<String> favGenre = new ArrayList<String>();
			int genreCnt = 0;
			int maxSongs = 0;
			songCount = new HashMap<String, Integer>();
			for (String song : userSongs.get(user)) {
				
				genreCnt = songCount.getOrDefault(songGenre.get(song), 0);
				if (maxSongs <= genreCnt) {
					maxSongs = genreCnt + 1;
				}
				songCount.put(songGenre.get(song), genreCnt + 1);
			}

			for (String genre : songCount.keySet()) {
				if (songCount.get(genre) == maxSongs) {
					favGenre.add(genre);
				}
			}

			userGenre.put(user, favGenre);
		}
		System.out.println(userGenre);
	}
}
