package ro.sci.library;

public class Novel extends Book {

	private String genre;

	public Novel(String name, int numberOfPages, String genre) {
		super(name, numberOfPages);
		this.genre = genre;
	}

}
