package service;

import java.util.List;

import com.google.gson.Gson;

import dao.SongDAO;
import dao.UserDAO;
import model.Song;
import model.User;
import spark.Request;
import spark.Response;

public class ProfileService {

	private SongDAO SongDAO;
	
	  /**
	   * inicializar novo servico tentando conectar e imprimindo qualquer erro que possa ocorrer  
	   */
	  public ProfileService() {
	    try {
	      SongDAO = new SongDAO();
	      SongDAO.conectar();
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	  }
	
	public String get(Request request, Response response) {
		
		String aux = "{\n\t\"Dados vazios\"}";
		String resp = "";
		int author_id = Integer.parseInt(request.params(":id"));
		
		if ( author_id <= 0 ) {
			return aux;
		}
		
		List<Song> musicas = SongDAO.getByAuthor(author_id);
		
		if ( musicas == null ) {
			return aux;
		}
		
		resp = "{\"musicas\": " + new Gson().toJson(musicas) + ",";
		
		UserDAO userhelper = new UserDAO();
		User author = userhelper.get(author_id);
		
		if (author == null) {
			return aux;
		}
		
		resp = resp + "\"dados\":" + new Gson().toJson(author) + "}";
		
		
		return resp;
	}


}
