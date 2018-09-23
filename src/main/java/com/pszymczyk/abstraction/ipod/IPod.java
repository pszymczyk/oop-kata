package com.pszymczyk.abstraction.ipod;

import java.util.List;

public interface IPod {

    void uploadSongFromItunes(long itunesSongId);

    List<Song> playlist(int position);

}
