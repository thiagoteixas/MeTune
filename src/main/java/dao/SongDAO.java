package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Song;

public class SongDAO extends DAO {
	
	public SongDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Song song) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO song (name, duration, author_id) "
				       + "VALUES ('"+ song.getName() + "', "  
				       + song.getDuration() + ", "
				       + song.getAuthor() + ");";
			//System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Song get(int id) {
		Song song = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM song WHERE id = " + id;
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	song = new Song(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return song;
	}
	
	
	public List<Song> get() {
		return get("");
	}
	
	public List<Song> getOrderById() {
		return get("id");		
	}
	
	
	public List<Song> getOrderByName() {
		return get("name");		
	}
	
	public List<Song> getOrderByDuration() {
		return get("duration");		
	}

	
	private List<Song> get(String orderBy) {
	
		List<Song> songs = new ArrayList<Song>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM song" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Song s = new Song(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"));
	        	songs.add(s);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return songs;
	}
	
	public Song getByName(String name) {
		Song song = null;
		try {
			Statement st = conexao.createStatement();
			String sql = "SELECT song WHERE name = '" + name;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
			if(rs.next()){            
	        	song = new Song(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"));
	        }
	        st.close();
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return song;
	}
	
	public boolean update(Song song) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE song SET name = '" + song.getName() 
						+ "', duration = '" + song.getDuration()
						+ "' WHERE id = " + song.getId();
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
			String sql = "DELETE FROM song WHERE id = " + id;
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