package com.pszymczyk.encapsulation;

import com.pszymczyk.abstraction.ipod.IPod;
import com.pszymczyk.abstraction.ipod.Song;

/**
 * @author pawel szymczyk
 */
public class IPodPrototypeOne extends IPod {

    private final ITunesConnector iTunesConnector;
    private final Song[] songs = new Song[1000];

    private int lastFreeSpot = 0;

    public IPodPrototypeOne(ITunesConnector iTunesConnector) {
        this.iTunesConnector = iTunesConnector;
    }

    @Override
    protected void addSongToLibrary(Long itunesSongId) {
        songs[lastFreeSpot] = iTunesConnector.getSong(itunesSongId);
        ++lastFreeSpot;
    }

    @Override
    protected int songsNumber() {
        return songs.length;
    }
}
