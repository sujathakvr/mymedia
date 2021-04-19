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

import com.ontarioinc.mediaapp.db.Playlist;
import com.ontarioinc.mediaapp.service.PlaylistService;

@RestController
public class PlaylistController {
	
	@Autowired
	private PlaylistService playListService;
	
	@GetMapping("/playlists")
	public List<Playlist> getAllPlaylist() {
		return playListService.getAllPlaylists();
	}
	
	@GetMapping("/playlists/{id}")
	public Playlist getPlaylistById(@PathVariable String id) {
		return playListService.getPlaylistById(id);
	}
   
	@PostMapping("/playlists")
	public void addPlayList(@RequestBody Playlist p) {
		playListService.addPlayList(p);
	}
	
	@PutMapping("/playlists")
	public void updatePlayList(@RequestBody Playlist p) {
		playListService.updatePlayList(p);
	}
	
	@DeleteMapping("/playlists/{id}")
	public void deletePlayList(@PathVariable String id) {
		playListService.deletePlayList(id);
	}
}
