package co.edu.unbosque.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import co.edu.unbosque.model.persistence.DatabaseConnection;

@ManagedBean(name="user")
@SessionScoped
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String username, email, password, firstname, lastname, reservedBooks, generes;
	private int role;
	
	public User() {
		
	}
	
	public User(String firstname, String lastname, String username, String email, String password, int role, String generes) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.generes = generes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getReservedBooks() {
		return reservedBooks;
	}

	public void setReservedBooks(String reservedBooks) {
		this.reservedBooks = reservedBooks;
	}

	public String getGeneres() {
		return generes;
	}

	public void setGeneres(String generes) {
		this.generes = generes;
	}

	public void login() {
		FacesMessage message = null;
		DatabaseConnection db = new DatabaseConnection();
		var validation = db.checkUser(username, password);
		if(validation == 1) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hola "+firstname, "Estamos cargando tu perfil");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Bienvenido", message);
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
			try {
				context.getExternalContext().redirect("crm.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrió un error al cargar tu perfil. Contacta con tu administrador mas cercano.");
				FacesContext.getCurrentInstance().addMessage("El usuario y/o contraseña están errados", message);
			}
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario y/o contraseña están errados");
			FacesContext.getCurrentInstance().addMessage("El usuario y/o contraseña están errados", message);
		}
	}
	
	public void loginAdmin() {
		FacesMessage message = null;
		DatabaseConnection db = new DatabaseConnection();
		var validation = db.checkUser(username, password);
		if(validation == 2) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hola "+firstname, "Estamos cargando tu perfil");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Bienvenido", message);
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
			try {
				context.getExternalContext().redirect("crmAdmin.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrió un error al cargar tu perfil. Contacta con tu administrador mas cercano.");
				FacesContext.getCurrentInstance().addMessage("El usuario y/o contraseña están errados", message);
			}
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario y/o contraseña están errados");
			FacesContext.getCurrentInstance().addMessage("El usuario y/o contraseña están errados", message);
		}
	}
}
