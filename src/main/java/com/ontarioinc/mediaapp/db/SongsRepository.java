package com.ontarioinc.mediaapp.db;


import java.math.BigInteger;
import java.util.Collection;
import java.util.Optional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SongsRepository extends CrudRepository<Song, String> {
	public Optional<Song> findByName(String name);

	Collection<Song> findByPlaylistId(BigInteger playlistId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("delete from Song s where s.playlistId = ?1")
	void deleteByPlaylistId(BigInteger playlistId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("delete from Song s where s.playlistId = ?1 and s.id = ?2")
	public void delete(BigInteger playlistId, BigInteger songId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Song s set s.playlistId = ?2 where s.id = ?1")
	public int updatePlaylist(BigInteger songId, BigInteger playlistId);
}
