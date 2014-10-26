package ar.edu.uces.progweb2.booksmov.model;

import java.io.Serializable;
import java.util.Set;

public class Movie extends Product{
	
	private String isan;
	private Set<Actor> actors;
	private Enum<Format> format;
	private Director director;
	
	public Movie(){}
	
	public Movie(String isan, String title, String mark, boolean alreadyUsed, boolean borrowable, Serializable image, Enum<Format> format, Set<Actor> actors, Director director){
		super(title, mark, alreadyUsed, borrowable, image);
		this.isan = isan;
		this.format = format;
		this.actors = actors;
		this.director = director;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Enum<Format> getFormat() {
		return format;
	}

	public void setFormat(Enum<Format> format) {
		this.format = format;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public String getIsan() {
		return isan;
	}

	public void setIsan(String isan) {
		this.isan = isan;
	}
	
}
