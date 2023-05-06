package com.example.shlokmantraapp.Songs;

public class Music {
    private String songName;
    private int songs;

    public Music(String songName, int songs) {
        this.songName = songName;

        this.songs = songs;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
    
    public int getSongs() {
        return songs;
    }

    public void setSongs(int songs) {
        this.songs = songs;
    }
}
