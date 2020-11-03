package co.edu.unbosque.model;

import java.util.LinkedList;

import co.edu.unbosque.model.persistence.DatabaseConnection;

public class BiblioBosque {
	private DatabaseConnection db = new DatabaseConnection();
	private LinkedList<Book> books = new LinkedList<Book>();
	
	public LinkedList<Book> downloadBooks() {
		var bookList = db.getAllBooks().split("\n");
		for (int i = 0; i < bookList.length; i++) {
			var bookDetails = bookList[i].split(";");
			books.add(new Book(bookDetails[1], bookDetails[2], Float.parseFloat(bookDetails[3])));
		}
		return books;
	}
	
	public DatabaseConnection getDb() {
		return db;
	}
}