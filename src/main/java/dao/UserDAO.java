package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends DAO {
	
	public UserDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(User user) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO user (email, username, premium) "
				       + "VALUES ('"+ user.getEmail() + "', '" 
				       + user.getUsername() + "', '" 
				       + user.isPremium() + "');";
			//System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public User get(int id) {
		User user = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM user WHERE id = " + id;
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	user = new User(
	        			rs.getInt("id"), 
	        			rs.getString("email"), 
	        			rs.getString("username"), 
	        			rs.getBoolean("premium"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return user;
	}
	
	
	public List<User> get() {
		return get("");
	}
	
	public List<User> getOrderById() {
		return get("id");		
	}
	
	
	public List<User> getOrderByEmail() {
		return get("email");		
	}
	
	public List<User> getOrderByUsername() {
		return get("username");		
	}
	
	public List<User> getOrderByPremium() {
		return get("isPremium");		
	}

	
	private List<User> get(String orderBy) {
	
		List<User> users = new ArrayList<User>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM user" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	User u = new User(
	        			rs.getInt("id"), 
	        			rs.getString("email"), 
	        			rs.getString("username"), 
	        			rs.getBoolean("premium"));
	        	users.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return users;
	}
	
	public boolean update(User user) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE user SET email = '" + user.getEmail() 
						+ "', username = '" + user.getUsername()
						+ "', premium = '" + user.isPremium()
						+ "' WHERE id = " + user.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM user WHERE id = " + id;
			//System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}