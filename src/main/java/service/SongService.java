package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dao.SongDAO;
import dao.UserDAO;
import model.Song;
import model.User;
import spark.Request;
import spark.Response;

public class SongService {
  private SongDAO SongDAO;
  
  /**
   * incializar novo servico tentando conectar e imprimindo qualquer erro que possa ocorrer  
   */
  public SongService() {
    try {
      SongDAO = new SongDAO();
      SongDAO.conectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * Dado uma requisicao com os paremetros sendo passados pela a URL pegar os paremetros e criar um nova classe e 
   * inserir no banco 
   * @param req requisicao que o metodo vai receber 
   * @param res resposta que o metodo vai mandar para a pagina, esse uma string
   * @return string que indica se a classe foi inserida ou nao no banco de dados
   */
  public String insert(Request req, Response res) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "POST");
    String titulo = req.queryParams("titulo");
    int duracao = Integer.parseInt(req.queryParams("duracao"));
    int autor = -1;
    
    System.out.println("test");
    
    String resp = "";
    Song song = new Song(titulo, duracao, autor);
    
    if (req.queryParams("Autor") != null) {
      autor = Integer.parseInt(req.queryParams("Autor"));
      song.setAuthor(autor);
    }
      
    
    if (SongDAO.insert(song) == true) {
      resp = "Música (" + titulo + ") inserida";
      System.out.println("Música (" + titulo + ") inserida");
      res.status(201);
    } else {
        resp = "Música (" + titulo + ") não inserido!";
        System.out.println("Música (" + titulo + ") não inserido!");
        res.status(404); // 404 Not found
      }

    return resp;
  }
  
  /**
   * Pegar penas um registro no banco de dados, dado um paremetro nomeado na URL
   * @param req requerimento para pegar os dados necessarios
   * @param res resposta para o servico que ele foi chamado
   * @return retorna uma string em formato de Json para a pagina principal contendo a class em formato Json
   */
  public String get(Request req, Response res) {
	res.type("aplication/json");
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "GET");
    int id = Integer.parseInt(req.params(":id"));       
    Song song = (Song) SongDAO.get(id);
    
    
    if (song != null) {
    	
	    Map<String, Object> preJson = new HashMap<>();
	    preJson.put("id", id);
	    preJson.put("nome", song.getName());
	    
//	    if (UserService.get(song.getAuthor())) {
//	    	
//	    }
	    
//	    String autorNome = "";
	    
//	    preJson,put("autor", )
	    
	    res.status(200);
	    
	    return new Gson().toJson(preJson);
    } else {
      res.status(404);
    }
    
    return new Gson().toJson("{}");
  }
  
  public String getAll(Request req, Response res) {
	  res.type("aplication/json");
	  res.header("Access-Control-Allow-Origin", "*");
	  res.header("Access-Control-Allow-Method", "GET");
	  
	  List<Song> songs = (List <Song>) SongDAO.getAll();
	  
	  if(songs != null) {
		 System.out.println(songs);
		 res.status(200);
		 return new Gson().toJson(songs);
	  } else {
		 res.status(404);
	  }
	  return "Erro";
  }
  
  public Song getByName(Request req, Response res) {
	 res.type("aplication/json");
	 res.header("Access-Control-Allow-Origin", "*");
	 res.header("Access-Control-Allow-Method", "GET");
	 String name = req.queryParams("titulo");
	 Song song = SongDAO.getByName(name);
	 
	 if (song != null) {
	    	
		    
		    res.status(200);
		    
		    return song;
	    } else {
	      res.status(404);
	    }
	    
	    return null;
  }
  
  /**
   * Dado uma URL atualizar um registro no banco de dados, pegando os dados atualizado da URL
   * @param req requisicao para pedir dados
   * @param res reposta para o metodo que chamou esse metodo
   * @return retorna a class que foi atualizada com as novas informacoes
   */
  public Song update(Request req, Response res) {
	res.type("aplication/json");
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "POST");
	System.out.println(req.body());
    int id = Integer.parseInt(req.params(":id"));
    Song song = SongDAO.get(id);
    Song song2 = new Gson().fromJson(req.body(), Song.class);
//    String resp = "";       

    if (song != null) {
//        song.setAuthor(Integer.parseInt(req.queryParams("ID_Musica")));
    	System.out.println(""+ req.queryParams("titulo"));
        song.setName(song2.getName());
        song.setDuration(song2.getDuration());
        song.setAuthor(song2.getAuthor());
        SongDAO.update(song);
        res.status(200); // success
//        resp = "Musica (ID " + song.getId() + ") atualizado!";
    } else {
        res.status(404); // 404 Not found
//        resp = "Musica (ID \" + song.getId() + \") não encontrado!";
        song = null;
    }
    return song;
  }
  
  /**
   * deleta um registro dado um id na URL
   * @param req requisisao para pegar os dados
   * @param res reposta para mandar dados 
   * @return boolean confirmando a deletacao do registro do banco de dados
   */
  public boolean delete(Request req, Response res) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "GET");
    int id = Integer.parseInt(req.params(":id"));
    Song song = SongDAO.get(id);
//    String resp = "";
    boolean status = false;
    
    if (song != null) {
      status = SongDAO.delete(id);
      res.status(200);
    } else {
      res.status(404);
    }
    
    return status;
  }
  
}


