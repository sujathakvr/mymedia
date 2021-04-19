package com.ontarioinc.mediaapp.rest;

@SuppressWarnings("serial")
public class PlaylistNotFoundException extends RuntimeException {

	public PlaylistNotFoundException(final String id) {
		super(String.format("playlist with id '%s' not found", id));
	}
}