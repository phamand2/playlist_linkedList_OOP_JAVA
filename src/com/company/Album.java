package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            // add the Song object to the list
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong (String title){
        // Loop through each Song object in the list
        for(Song checkedSong : this.songs){
            // If the song title is equal to the title that was passed in the parameter
            if(checkedSong.getTitle().equals(title)){
                // return that Song object
                return checkedSong;
            }
        }
            return null;
    }

    public boolean addToPlayList (int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        if(index >= 0 && (index <= this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList (String title, LinkedList<Song> playlist){
        // return the Song object if it exist by title
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
                    return true;
        }

        System.out.println("The song " + title + " is not in this album");
        return false;
    }


}
