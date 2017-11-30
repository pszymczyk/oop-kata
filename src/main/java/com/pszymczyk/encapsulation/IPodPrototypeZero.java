package com.pszymczyk.encapsulation;

import com.pszymczyk.abstraction.ipod.IPod;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pawel szymczyk
 */
public class IPodPrototypeZero extends IPod {

    private final ITunesConnector iTunesConnector;
    private final Set<Long> songs = new HashSet();

    public IPodPrototypeZero(ITunesConnector iTunesConnector) {
        this.iTunesConnector = iTunesConnector;
    }

    @Override
    protected void addSongToLibrary(Long itunesSongId) {
        songs.add(itunesSongId);
    }

    @Override
    protected int songsNumber() {
        return 1000;
    }
}
