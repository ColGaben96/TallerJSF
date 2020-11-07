package co.edu.unbosque.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import co.edu.unbosque.model.persistence.DatabaseConnection;

@ManagedBean(name="book")
@SessionScoped
public class Book {
	private ArrayList<String> genres;
	private String name, author;
	private float rating;
	
	public Book() {
		
	}
	
	public Book(String name, String author, ArrayList<String> genres, float rating) {
		this.name = name; this.author = author; this.genres = genres; this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void createBook() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		FacesMessage message = null;
		DatabaseConnection db = new DatabaseConnection();
		String convertedGeneres = "";
		for (int i = 0; i < genres.size(); i++) {
			convertedGeneres += genres.get(i);
		}
		try {
			db.createBook(name, author, convertedGeneres, String.valueOf(rating));
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregando "+name, "El libro ha sido cargado");
			context.addMessage("200Creation", message);
			context.getExternalContext().redirect("booksAdmin.xhtml");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrió un error con la creacion del libro. Contacta con tu administrador mas cercano.");
			context.addMessage("403Creation", message);
			
		}
	}
}
