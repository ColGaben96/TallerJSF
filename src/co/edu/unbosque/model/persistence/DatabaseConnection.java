package co.edu.unbosque.model.persistence;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
	
	private Connection con;
	private Statement statement;
	private ResultSet rs;
	
	public String getAllBooks() {
		var msg = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM books");
			while(rs.next()) {
				msg += rs.getString(1)+
						";"+rs.getString(2)+
						";"+rs.getString(3)+
						";"+rs.getString(4)+"\n";
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public String getAllUsers() {
		var msg = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg += rs.getString(1)+
						";"+rs.getString(2)+
						";"+rs.getString(3)+
						";"+rs.getString(4)+
						";"+rs.getString(5)+"\n";
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllGeneres() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM books_generes");
			while(rs.next()) {
				msg.add(rs.getString(2));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public int checkUser(String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM `users` WHERE username = '"+username+"' AND pass = '"+password+"'");
			while(rs.next()) {
				if(!(rs.getString(2) == username) && !(rs.getString(4) == password) && (rs.getInt(5) == 1)) {
					return 1;
				} else if(!(rs.getString(2) == username) && !(rs.getString(4) == password) && (rs.getInt(5) == 0)) {
					return 2;
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
}
