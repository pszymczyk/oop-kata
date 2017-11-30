package com.pszymczyk.abstraction.ipod;

/**
 * iPod a thousand songs in your pocket
 */
public abstract class IPod {

    protected abstract void addSongToLibrary(Long itunesSongId);

    protected abstract int songsNumber();

    public boolean uploadSongFromItunes(Long iTunesSongId) {
        if (canAddSong()) {
            addSongToLibrary(iTunesSongId);
            return true;
        } else {
            return false;
        }
    }

    private boolean canAddSong() {
        return songsNumber() <= 1000;
    }
}
