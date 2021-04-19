package com.ontarioinc.mediaapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ontarioinc.mediaapp.db.Song;
import com.ontarioinc.mediaapp.db.SongsRepository;
import com.ontarioinc.mediaapp.rest.SongNotFoundException;

@Service
public class SongService {
    // inject dependency of `EntityManager` from application context
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private SongsRepository songRepository;
    
    public List<Song> getAllSongs() {
    	List<Song> lists = new ArrayList<>();
    	songRepository.findAll().forEach(l -> lists.add(l));
        return lists;
    }
    
    public Song getSongbyId(String songId) {
    	return songRepository.findById(songId)
				.orElseThrow(() -> new SongNotFoundException(songId));
    }
    
    public void addSong(Song s) {
    	s.setCreatedOn(new Date());
    	songRepository.save(s);
    }

    public void updateSong(Song s) {
    	songRepository.save(s);
    }
    
    public void deleteSong(String songId) {
    	songRepository.deleteById(songId);
    }
}
