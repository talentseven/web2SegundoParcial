package ar.edu.uces.progweb2.booksmov.search.filter;

public class TypeSelector {
	
	private boolean all;
	private boolean booksOnly;
	private boolean moviesOnly;
	
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = all;
	}
	public boolean isBooksOnly() {
		return booksOnly;
	}
	public void setBooksOnly(boolean booksOnly) {
		this.booksOnly = booksOnly;
	}
	public boolean isMoviesOnly() {
		return moviesOnly;
	}
	public void setMoviesOnly(boolean moviesOnly) {
		this.moviesOnly = moviesOnly;
	}
	
	
}
