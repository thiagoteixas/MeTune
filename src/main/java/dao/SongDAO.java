package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Song;
import model.User;

import dao.UserDAO;

public class SongDAO extends DAO {
	
	/*
	 * Construtor padrao da classe, conecta automaticamente ao banco de dados quando criado
	 */
	public SongDAO() {
		super();
		conectar();
	}

	/**
	 * Fecha a conexao entreo o banco de dados
	 */
	public void finalize() {
		close();
	}
	
	/**
	 * 
	 * inserir musica dado um classe musica 
	 * @param song classe a ser inserida no banco
	 * @return Valida a insercao da classe
	 */
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

	
	/**
	 * Retorna uma musica de acordo com o id passado no parametro
	 * @param id numero de id para ser resgastado a classe
	 * @return a classe resgatada
	 */
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
	
	public List<Song> getAll() {
		List<Song> songs = new ArrayList<Song>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//String sql = "SELECT * from public.user";
			String sql = "SELECT song.id, song.name, song.duration, song.author_id, public.user.username FROM song ";
			sql += "LEFT JOIN public.user ON song.author_id = public.user.id";
			//sql += "INNER JOIN user ON song.author_id = song.id";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs);
	        while(rs.next()) {
	        	System.out.println(rs.getString("username"));
	        	Song s = new Song(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"), rs.getInt("author_id"));
	        	songs.add(s);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return songs;
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

	
	/**
	 * Dado um valor de ordem pegar todos os registros de acordo com a filtragem
	 * @param orderBy valor a ser ordernado
	 * @return uma lista dinamica com todos os registros ordenados
	 */
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
	
	/**
	 * Retorna uma musica pela o nome dela
	 * @param song class a ser autalizada
	 * @return valida se a classe foi autalizado com sucesso.
	 */
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
	
	/**
	 * Procura todas as tag associadas a uma musica 
	 * @param id da musica a ser pesquisada
	 * @return Uma lista com todas as tags da musica
	 */
	public List<String> getSongTags(int id) {
		List<String> listaTags = new ArrayList<String>();
		
		try {
			Statement st = conexao.createStatement();
			String sql = "SELECT b.name FROM tag as b INNER JOIN song_tag as c ON ( b.id = c.tag_id ) WHERE c.song_id = " + id;
//			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()){            
	        	listaTags.add(rs.getString("name"));
	        }
	        st.close();
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return listaTags;
	}
	
	/**
	 * Procura uma musica pela o id do autor
	 * @param id do autor a ser pesquisado
	 * @return Uma lista com todos as musicas pelo o autor
	 */
	public List<Song> getByAuthor(int id) {
		List<Song> listaMusicas = new ArrayList<Song>();
		
		try {
			Statement st = conexao.createStatement();
			String sql = "SELECT * FROM song WHERE author_id = " + id;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()){            
	        	Song s = new Song(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"), rs.getInt("author_id"));
	        	listaMusicas.add(s);
	        }
	        st.close();
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return listaMusicas;
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
	
	/**
	 * Deleta um registro de acordo com um id
	 * @param id id a ser passado para deletacao
	 * @return valor validando se ele foi deletado
	 */
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