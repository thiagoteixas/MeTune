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
  
  public TagService() {
    try {
      TagDAO = new TagDAO();
      TagDAO.conectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  public Tag insert(Request req, Response res) {
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
    
  
  public String get(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));       
    Tag tag = (Tag) TagDAO.get(id);

    if (tag != null) {
    	
	    Map<String, Object> preJson = new HashMap<>();
	    preJson.put("id", id);
	    preJson.put("nome", tag.getName());
	    res.type("aplication/json");
	    res.status(200);
	    
	    return new Gson().toJson(preJson);
    } else {
      res.status(404);
    }
    
    return new Gson().toJson("{}");
  }
  
  public String getAll(Request req, Response res) {
	    int id = Integer.parseInt(req.params(":id"));       
	    Tag tag = (Tag) TagDAO.get("");

	    if (tag != null) {
	    	
		    Map<String, Object> preJson = new HashMap<>();
		    preJson.put("id", id);
		    preJson.put("nome", tag.getName());
		    res.type("aplication/json");
		    res.status(200);
		    
		    return new Gson().toJson(preJson);
	    } else {
	      res.status(404);
	      return ("{}");
	    }
	  }
  
  public Tag update(Request req, Response res) {
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
  
  public boolean delete(Request req, Response res) {
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
  
  
  /*
   * public Object addTag() {}
   * public Object getTag() {}
   * public Object updateTag() {}
   * public Object deleteTag() {}
   * */
}
