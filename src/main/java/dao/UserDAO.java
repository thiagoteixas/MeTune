package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.User;

public class UserDAO extends DAO {
	
	/*
	 * Construtor padrao da classe, conecta automaticamente ao banco de dados quando criado
	 */
	public UserDAO() {
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
	 * inserir user dado um classe user 
	 * @param user user a ser inserida no banco
	 * @return Valida a insercao da classe
	 */
	public boolean insert(User user) {
		boolean status = false;
		try {
//			String sql = "INSERT INTO public.user (email, username, password, premium) "
//				       + "VALUES ('"+ user.getEmail() + "', '"
//				       + user.getUsername() + "', '" 
//				       + user.getPassword() + "', '"
//				       + user.isPremium() + "');";
			String sql = "INSERT INTO public.user (email, username, password, premium) VALUES ( ?, ?, ?, ? )";
			//System.out.println(sql);
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, user.getEmail());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.setBoolean(4, user.isPremium());
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}


	/**
	 * Retorna uma user de acordo com o id passado no parametro
	 * @param id numero de id para ser resgastado a classe
	 * @return a classe resgatada
	 */
	public User get(int id) {
		User user = null;
		
		try {
			String sql = "SELECT * FROM public.user WHERE id = ?";
			PreparedStatement st = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			// Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//String sql = "SELECT * FROM public.user WHERE id = " + id;
			st.setInt(1, id);
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
	
	/**
	 * Retorna uma user de acordo com o id passado no parametro
	 * @param id numero de id para ser resgastado a classe
	 * @return a classe resgatada
	 */
	public User getWithPassword(String name) {
		User user = null;
		System.out.println(name);
		
		try {
			String sql = "SELECT * FROM public.user WHERE public.user.username = ?";
			PreparedStatement st = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//System.out.println(sql);
			st.setString(1, name);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	user = new User(
	        			rs.getInt("id"),
	        			rs.getString("email"),
	        			rs.getString("password"),	
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

	/**
	 * Dado um valor de ordem pegar todos os registros de acordo com a filtragem
	 * @param orderBy valor a ser ordernado
	 * @return uma lista dinamica com todos os registros ordenados
	 */
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
	
	/**
	 * Atualiza uma classe seguindo um novo objeto sendo passado por paremetro
	 * @param song class a ser autalizada
	 * @return valida se a classe foi autalizado com sucesso.
	 */
	public boolean update(User user) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE public.user SET email = '" + user.getEmail() 
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
	
	/**
	 * Deleta um registro de acordo com um id
	 * @param id id a ser passado para deletacao
	 * @return valor validando se ele foi deletado
	 */
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM public.user WHERE id = " + id;
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