package service;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import dao.TagDAO;
import model.Tag;

import spark.Request;
import spark.Response;

public class TagService {
  private TagDAO TagDAO;
  
  /**
   * incializar novo servico tentando conectar e imprimindo qualquer erro que possa ocorrer  
   */
  public TagService() {
    try {
      TagDAO = new TagDAO();
      TagDAO.conectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * Dado uma requisicao com os paremetros sendo passados pela a URL pegar os paremetros e criar um nova classe e 
   * inserir no banco 
   * @param req requisicao que o metodo vai receber 
   * @param res resposta que o metodo vai mandar para a pagina, esse uma string
   * @return tag retorna a tag que foi criada como resposta 
   */
  public Tag insert(Request req, Response res) {
	  res.header("Access-Control-Allow-Origin", "*");
	  res.header("Access-Control-Allow-Method", "POST");
//    int id = Integer.parseInt(req.queryParams("ID_musica"));
    String nome = req.queryParams("titulo");
    
//    String resp = "";
    Tag tag = new Tag(nome);
    
    
    if (TagDAO.insert(tag) == true) {
//      resp = "Tag (" + nome + ") inserida";
      res.status(201);
    } else {
//        resp = "Tag (" + nome + ") não inserido!";
        res.status(404); // 404 Not found
      }
    return tag;
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
    Tag tag = (Tag) TagDAO.get(id);

    if (tag != null) {
    	
	    Map<String, Object> preJson = new HashMap<>();
	    preJson.put("id", id);
	    preJson.put("nome", tag.getName());
	    res.status(200);
	    
	    return new Gson().toJson(preJson);
    } else {
      res.status(404);
    }
    
    return new Gson().toJson("{}");
  }
  
  /**
   * Dado uma URL atualizar um registro no banco de dados, pegando os dados atualizado da URL
   * @param req requisicao para pedir dados
   * @param res reposta para o metodo que chamou esse metodo
   * @return retorna a class que foi atualizada com as novas informacoes
   */
  public String getAll(Request req, Response res) {
	    
	  res.type("aplication/json");
	  res.header("Access-Control-Allow-Origin", "*");
	  res.header("Access-Control-Allow-Method", "GET");
	  int id = Integer.parseInt(req.params(":id"));       
	    Tag tag = (Tag) TagDAO.get();

	    if (tag != null) {
	    	
		    Map<String, Object> preJson = new HashMap<>();
		    preJson.put("id", id);
		    preJson.put("nome", tag.getName());
		    res.status(200);
		    
		    return new Gson().toJson(preJson);
	    } else {
	      res.status(404);
	      return ("{}");
	    }
	  }
  
  public Tag update(Request req, Response res) {
	  
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "PUT");
    int id = Integer.parseInt(req.params(":id"));
    Tag tag = TagDAO.get(id);
//    String resp = "";       

    if (tag != null) {
//        tag.setName(req.queryParams("ID_Musica"));
        
    	tag.setName(req.queryParams("titulo"));
        TagDAO.update(tag);
        res.status(200); // success
//        resp = "Tag (ID " + tag.getId() + ") atualizado!";
    } else {
        res.status(404); // 404 Not found
//        resp = "Tag (ID \" + tag.getId() + \") não encontrado!";
        tag = null;
    }
    return tag;
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
    Tag tag = TagDAO.get(id);
//    String resp = "";
    boolean status = false;
    
    if (tag != null) {
      status = TagDAO.delete(id);
      res.status(200);
    } else {
      res.status(404);
    }
    
    return status;
  }
  
}
