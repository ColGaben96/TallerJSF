package co.edu.unbosque.model.persistence;

import java.sql.*;
import java.util.ArrayList;

import co.edu.unbosque.model.Book;
import co.edu.unbosque.model.User;

public class DatabaseConnection {
	
	private Connection con;
	private Statement statement;
	private ResultSet rs;
	
	public ArrayList<String> getAllBookAuthors() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM books");
			while(rs.next()) {
				msg.add(rs.getString(5));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllBookRatings() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM books");
			while(rs.next()) {
				msg.add(rs.getString(4));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllBookGeneres() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM books");
			while(rs.next()) {
				msg.add(rs.getString(3));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllBookTitles() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM books");
			while(rs.next()) {
				msg.add(rs.getString(2));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<Book> getAllBooks() {
		var msg = new ArrayList<Book>();
		var genres = getAllBookGeneres();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM books");
			while(rs.next()) {
				msg.add(new Book(rs.getString(2),rs.getString(5),genres,Float.parseFloat(rs.getString(4))));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<User> getAllUsers() {
		var msg = new ArrayList<User>();
		var genres = getAllUserGeneres();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg.add(new User(rs.getString(6),rs.getString(7),rs.getString(2),rs.getString(2),rs.getString(4),rs.getInt(5),genres,Date.valueOf(rs.getString(9)),rs.getString(10)));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllUserMail() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg.add(rs.getString(2));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllUserRoles() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg.add(String.valueOf(rs.getInt(4)));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllUserNames() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg.add(rs.getString(5)+" "+rs.getString(6));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllUserGeneres() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg.add(rs.getString(8));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllUserBirthdays() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg.add(rs.getString(9));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public ArrayList<String> getAllUserSexes() {
		var msg = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "uYjgfeTJOv";
			String pass = "52AqWbXhXq";
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				msg.add(rs.getString(10));
			}
			con.close();
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
			con.close();
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
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	public void createUser(String username, String email, String password, String firstname, String lastname, String generes, String birthday, String sex) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String user = "uYjgfeTJOv";
		String pass = "52AqWbXhXq";
		con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
		statement = con.createStatement();
		var userarr = getAllUsers();
		var id = userarr.size();
		int myresult = statement.executeUpdate("INSERT INTO `users`(`id`, `username`, `email`, `pass`, `role`, `firstname`, `lastname`, `reservedBooks`, `generes`, `birthday`, `sex`) VALUES ("+id+",'"+email+"','"+email+"','"+password+"',"+1+",'"+firstname+"','"+lastname+"','','"+generes+"','"+birthday+"','"+sex+"')");
		System.out.println("Operation: "+myresult);
		System.out.println("Added User in pos "+id+" successfully");
		con.close();
	}
	
	public void createBook(String title, String author, String genre, String rating) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String user = "uYjgfeTJOv";
		String pass = "52AqWbXhXq";
		con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + user, user, pass);
		statement = con.createStatement();
		var userarr = getAllBooks();
		var id = userarr.size();
		int myresult = statement.executeUpdate("INSERT INTO `books`(`id`, `Title`, `Genre`, `Rating`, `Author`) VALUES ("+id+",'"+title+"','"+genre+"','"+rating+"','"+author+"')");
		System.out.println("Operation: "+myresult);
		System.out.println("Added User in pos "+id+" successfully");
		con.close();
	}
}
