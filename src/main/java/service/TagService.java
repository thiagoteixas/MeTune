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
  
  /*
   * public Object addTag() {}
   * public Object getTag() {}
   * public Object updateTag() {}
   * public Object deleteTag() {}
   * */
}
