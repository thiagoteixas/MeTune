package service;

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
    
    String resp = "";
    Tag tag = new Tag(nome);
    
    
    if (TagDAO.insert(tag) == true) {
      resp = "Tag (" + nome + ") inserida";
      res.status(201);
    } else {
        resp = "Tag (" + nome + ") não inserido!";
        res.status(404); // 404 Not found
      }
    return tag;
  }
    
  
  public Tag get(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));       
    Tag tag = (Tag) TagDAO.get(id);
    
    if (tag != null) {
      res.status(200);
    } else {
      res.status(404);
    }
    
    return tag;
  }
  
  public Tag update(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));
    Tag tag = TagDAO.get(id);
    String resp = "";       

    if (tag != null) {
//        tag.setName(req.queryParams("ID_Musica"));
        
    	tag.setName(req.queryParams("titulo"));
        TagDAO.update(tag);
        res.status(200); // success
        resp = "Tag (ID " + tag.getId() + ") atualizado!";
    } else {
        res.status(404); // 404 Not found
        resp = "Tag (ID \" + tag.getId() + \") não encontrado!";
        tag = null;
    }
    return tag;
  }
  
  public boolean delete(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));
    Tag tag = TagDAO.get(id);
    String resp = "";
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
