package com.ontarioinc.mediaapp.rest;

@SuppressWarnings("serial")
public class SongNotFoundException extends RuntimeException {

	public SongNotFoundException(final String id) {
		super(String.format("song with id '%s' not found", id));
	}
}