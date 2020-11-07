package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.unbosque.model.persistence.DatabaseConnection;

@ManagedBean(name="server")
@SessionScoped
public class BiblioBosque {
	private DatabaseConnection db = new DatabaseConnection();
	
	public DatabaseConnection getDb() {
		return db;
	}
}