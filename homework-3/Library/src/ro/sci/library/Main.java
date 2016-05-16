package ro.sci.library;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SingleSelectionModel;

public class Main {

	public static void main(String[] args) {

		List<Book> bookCollection = new ArrayList<Book>();

		Book firstAlbum = new Album("Festivitate", 120, "Plastic");
		Book secondAlbum = new Album("a 8 - a", 120, "Plastic");
		Book thirdAlbum = new Album("Nunta", 120, "Plastic");
		Book firstNovel = new Novel("La Tiganci", 300, "Drama");
		Book secondNovel = new Novel("Moara cu noroc", 300, "Drama");
		Book thirdNovel = new Novel("Alba", 300, "Drama");

		String bookToDelete = "Festivitate";

		bookCollection.add(firstAlbum);
		bookCollection.add(secondAlbum);
		bookCollection.add(thirdAlbum);
		bookCollection.add(firstNovel);
		bookCollection.add(secondNovel);
		bookCollection.add(thirdNovel);
		System.out.print("The books in the library are: ");
		for (int i = 0; i < bookCollection.size(); i++) {
			System.out.print(bookCollection.get(i).getName() + "; ");

			if (bookToDelete.equals(bookCollection.get(i).getName())) {
				bookCollection.remove(i);
				i--;
			}
		}

		System.out.println("\n\nThe book you have deleted: " + bookToDelete);

		System.out.print("\nThe reamining books are in the library are:  ");
		for (int i = 0; i < bookCollection.size(); i++) {
			System.out.print(bookCollection.get(i).getName() + "; ");
		}

	}

}
