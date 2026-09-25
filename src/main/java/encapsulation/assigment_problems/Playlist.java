import java.util.*;

class Songs {
    private String[] songs;
    private int count;

    Songs(int n) {
        songs = new String[n];
    }

    void addSong(String s) {
        if (count < songs.length)
            songs[count++] = s;
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }
}

public class Playlist {
    public static void main(String[] args) {
        Songs p = new Songs(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(p.getSongs()[0]);
        System.out.println(p.getSongCount());
    }
}