package com.ontarioinc.mediaapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ontarioinc.mediaapp.db.Song;
import com.ontarioinc.mediaapp.service.SongService;

@RestController
public class SongController {
	
	@Autowired
	private SongService songService;
	
	@GetMapping("/songs")
	public List<Song> getAllSongs() {
		return songService.getAllSongs();
	}
	
	@GetMapping("/songs/{id}")
	public Song getSongById(@PathVariable String id) throws SongNotFoundException {
		return songService.getSongbyId(id);
	}
   
	@PostMapping("/songs")
	public void addSong(@RequestBody Song s) {
		songService.addSong(s);
	}
	
	@PutMapping("/songs")
	public void updateSong(@RequestBody Song s) {
		songService.updateSong(s);
	}
	
	@DeleteMapping("/songs/{id}")
	public void deleteSong(@PathVariable String id) {
		songService.deleteSong(id);
	}
}
