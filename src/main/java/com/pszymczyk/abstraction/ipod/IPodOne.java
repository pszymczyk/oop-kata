package com.pszymczyk.abstraction.ipod;


import java.util.ArrayList;
import java.util.List;

/**
 * iPod a thousand songs in your pocket
 */
public class IPodOne implements IPod {

    private final IStoreApi iStoreApi;
    private final List<Song> songs = new ArrayList<>(1000);

    public IPodOne(IStoreApi iStoreApi) {
        this.iStoreApi = iStoreApi;
    }

    public void uploadSongFromItunes(long itunesSongId) {
        Song song = iStoreApi.getSong(itunesSongId);
        songs.add(song);
    }

    public List<Song> playlist(int position) {
        return songs;
    }


}
