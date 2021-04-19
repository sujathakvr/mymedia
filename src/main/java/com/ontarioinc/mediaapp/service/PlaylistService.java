package com.ontarioinc.mediaapp.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ontarioinc.mediaapp.db.Playlist;
import com.ontarioinc.mediaapp.db.PlaylistRepository;
import com.ontarioinc.mediaapp.db.Song;
import com.ontarioinc.mediaapp.rest.PlaylistNotFoundException;

@Service
public class PlaylistService {
    // inject dependency of `EntityManager` from application context
    @Autowired
    private EntityManager entityManager;

    // inject dependency of `PlaylistRepository` from application context
    @Autowired
    private PlaylistRepository playlistRepo;

    // fetch all the playlist from `playlist` table using `PlaylistRepository`
    public List<Playlist> getAllPlaylists() {
    	List<Playlist> lists = new ArrayList<>();
        playlistRepo.findAll().forEach(l -> lists.add(l));
        return lists;
    }
    
    // fetch play list by id
    public Playlist getPlaylistById(String playlistId) {
        return playlistRepo.findById(playlistId)
				.orElseThrow(() -> new PlaylistNotFoundException(playlistId));
    }

    // fetch all songs inside the given playlist using `@NamedNativeQuery`
    public List<Song> getSongs(BigInteger playlistId) {
        List<Song> resultList = entityManager.createNamedQuery("songsByPlaylistId", Song.class)
            .setParameter(1, playlistId)
            .getResultList();
        return resultList;
    }
    
    public void addPlayList(Playlist playList) {
    	playList.setCreatedOn(new Date());
    	playlistRepo.save(playList);
    }
    
    public void updatePlayList(Playlist playList) {
    	playlistRepo.save(playList);
    }
    
    public void deletePlayList(String playlistId) {
    	playlistRepo.deleteById(playlistId);
    }
}
