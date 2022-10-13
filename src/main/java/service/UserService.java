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
  
  public User insert(Request req, Response res) {
    int id = Integer.parseInt(req.queryParams("ID_usuario"));
    String email = req.queryParams("Email");
    String senha = req.queryParams("Senha");
    String nome = req.queryParams("Nome");
    boolean tipo_cadastro = Boolean.parseBoolean(req.queryParams("Tipo_Cadastro"));
    
    String resp = "";
    User user = new User(id, email, nome, tipo_cadastro);
      
    
    if (UserDAO.insert(user) == true) {
      resp = "Usuário (" + nome + ") inserido";
      res.status(201);
    } else {
        resp = "Usuário (" + nome + ") não inserido!";
        res.status(404); // 404 Not found
      }

    
    return user;
  }
  
  public User get(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));       
    User user = (User) UserDAO.get(id);
    
    if (user != null) {
      res.status(200);
    } else {
      res.status(404);
    }
    
    return user;
  }
  
  public User update(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));
    User user = UserDAO.get(id);
    String resp = "";       

    if (user != null) {
        user.setId(Integer.parseInt(req.queryParams("ID_Usuario")));
        user.setUsername(req.queryParams("Nome"));
        user.setPremium(Boolean.parseBoolean(req.queryParams("Tipo_Cadastro")));
        UserDAO.update(user);
        res.status(200); // success
        resp = "Usuário (ID " + user.getId() + ") atualizado!";
    } else {
        res.status(404); // 404 Not found
        resp = "Usuário (ID \" + user.getId() + \") não encontrado!";
        user = null;
    }
    return user;
  }
  
  public boolean delete(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));
    User user = UserDAO.get(id);
    String resp = "";
    boolean status = false;
    
    if (user != null) {
      status = UserDAO.delete(id);
      res.status(200);
    } else {
      res.status(404);
    }
    
    return status;
  }
  
  
  /*
   * public Object addUser() {}
   * public Object getUser() {}
   * public Object updateUser() {}
   * public Object deleteUser() {}
   * */
}
