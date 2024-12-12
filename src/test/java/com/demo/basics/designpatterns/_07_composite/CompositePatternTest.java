package com.demo.basics.designpatterns._07_composite;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * When the group of objects should behave as the single object
 */
public class CompositePatternTest {

    @Test
    public void test() {
        SongComponent playList1 = new PlayList("playlist_1");
        SongComponent playList2 = new PlayList("playlist_2");
        SongComponent playList3 = new PlayList("playlist_3");

        playList1.add(new Song("Song1"));
        playList2.add(new Song("Song2"));
        playList2.add(new Song("Song3"));
        playList3.add(playList1);
        playList3.add(playList2);
        playList3.add(new Song("Song4"));
        playList3.displaySongInfo();
    }
}

abstract class SongComponent {

    public void add(SongComponent c) {
        throw new UnsupportedOperationException();
    }

    public String getSong() {
        throw new UnsupportedOperationException();
    }

    public void displaySongInfo() {
        throw new UnsupportedOperationException();
    }
}

@RequiredArgsConstructor
class PlayList extends SongComponent {

    final String playListName;
    List<SongComponent> componentLst = new ArrayList<>();

    @Override
    public void add(SongComponent c) {
        componentLst.add(c);
    }

    @Override
    public void displaySongInfo() {
        System.out.println("Playlist Name: " + playListName);
        for (SongComponent s : componentLst) {
            s.displaySongInfo();
        }
    }
}

@AllArgsConstructor
class Song extends SongComponent {
    String songName;

    @Override
    public String getSong() {
        return songName;
    }

    @Override
    public void displaySongInfo() {
        System.out.println("Song: " + songName);
    }
}