package com.pszymczyk.abstraction.ipod;


import java.util.ArrayList;
import java.util.List;

/**
 * iPod a thousand songs in your pocket
 */
public class IPodOne {

    private final IStoreApi iStoreApi;
    private final List<Song> songs = new ArrayList<>(1000);

    public IPodOne(IStoreApi iStoreApi) {
        this.iStoreApi = iStoreApi;
    }

    public boolean uploadSongFromItunes(Long itunesSongId) {
        Song song = iStoreApi.getSong(itunesSongId);
        return songs.add(song);
    }

    public List<Song> playlist(int position) {
        return songs;
    }


}
