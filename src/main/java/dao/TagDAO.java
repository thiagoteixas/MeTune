package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Tag;

public class TagDAO extends DAO {
	
	public TagDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Tag tag) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO tag (name) "
				       + "VALUES ('"+ tag.getName() + "');";
			//System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Tag get(int id) {
		Tag tag = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM tag WHERE id = " + id;
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	tag = new Tag(rs.getInt("id"), rs.getString("name"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return tag;
	}
	
	
	public List<Tag> get() {
		return get("");
	}
	
	public List<Tag> getOrderById() {
		return get("id");		
	}
	
	
	public List<Tag> getOrderByName() {
		return get("name");		
	}
	

	
	private List<Tag> get(String orderBy) {
	
		List<Tag> tags = new ArrayList<Tag>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM tag" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Tag t = new Tag(rs.getInt("id"), rs.getString("name"));
	        	tags.add(t);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return tags;
	}
	
	public boolean update(Tag tag) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE tag SET name = '" + tag.getName()
						+ "' WHERE id = " + tag.getId();
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
			String sql = "DELETE FROM tag WHERE id = " + id;
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