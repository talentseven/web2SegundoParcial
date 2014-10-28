package ar.edu.uces.progweb2.booksmov.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.uces.progweb2.booksmov.model.Actor;
import ar.edu.uces.progweb2.booksmov.model.Director;
import ar.edu.uces.progweb2.booksmov.model.Format;

public class MovieDto extends ProductDto{
	
	private String isan;
	private String actors;
	private Set<Actor> actorSet = new HashSet<Actor>();
	private Director director;
	private	List<Format> formats = new ArrayList<Format>();
	private Format selectedFormat;
	
	public MovieDto(){}

	public MovieDto(String title, String rating, boolean alreadyUsed,
			boolean borrowable, Serializable image, String isan,
			String actors, Director director, Format format) {
		super(title, rating, alreadyUsed, borrowable, image);
		this.isan = isan;
		this.actors = actors;
		this.director = director;
		this.selectedFormat = format;
	}

	public String getIsan() {
		return isan;
	}

	public void setIsan(String isan) {
		this.isan = isan;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Format> getFormats() {
		return formats;
	}

	public void setFormats(List<Format> formats) {
		this.formats = formats;
	}

	public Format getSelectedFormat() {
		return selectedFormat;
	}

	public void setSelectedFormat(Format selectedFormat) {
		this.selectedFormat = selectedFormat;
	}
	
	public Set<Actor> getActorSet() {
		return actorSet;
	}

	public void setActorSet(Set<Actor> actorSet) {
		this.actorSet = actorSet;
	}

	public void clearFields(){
		this.isan = null;
		this.title = null;
		this.director = null;
		this.rating = null;
		this.borrowable = false;
		this.image = null;
		this.alreadyUsed = false;
		this.actors = null;
		this.selectedFormat = null;
	}
	
}
