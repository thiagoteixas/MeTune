package service;

import dao.UserDAO;
import model.User;

import spark.Request;
import spark.Response;

public class UserService {
  private UserDAO UserDAO;
  
  public UserService() {
    try {
      UserDAO = new UserDAO();
      UserDAO.conectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  /*
   * public Object addUser() {}
   * public Object getUser() {}
   * public Object updateUser() {}
   * public Object deleteUser() {}
   * */
}
