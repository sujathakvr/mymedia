package com.ontarioinc.mediaapp.db;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, String> {

	public Optional<Playlist> findByName(String name);

	@Query("select s from Song s where s.playlistId = ?1")
	public Collection<Song> getSongs(String playlistId);
}
