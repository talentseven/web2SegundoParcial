package ar.edu.uces.progweb2.booksmov.model;

import java.util.HashSet;
import java.util.Set;

public class Movie extends Product{
	
	private String isan;
	private Set<Actor> actors = new HashSet<Actor>();
	private Format format;
	private Director director;
	
	public Movie(){}
	
	public Movie(String isan, String title, String mark, boolean alreadyUsed, boolean borrowable, byte[] image, Format format, Director director, User user){
		super(title, mark, alreadyUsed, borrowable, image, user);
		this.isan = isan;
		this.format = format;
		this.director = director;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
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
