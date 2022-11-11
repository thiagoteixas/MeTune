package service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import dao.UserDAO;
import model.Song;
import model.User;

import spark.Request;
import spark.Response;

public class UserService {
  private UserDAO UserDAO;
  
  /**
   * incializar novo servico tentando conectar e imprimindo qualquer erro que possa ocorrer  
   */
  public UserService() {
    try {
      UserDAO = new UserDAO();
      UserDAO.conectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * Converter uma senha para o formato de MD5 para melhor seguranca
   * @param senha string da senha recem criada para codificao
   * @return senha codificada em formato MD5
   */
	public static String toMD5(String senha) {
		String resp = "";
		try {
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(),0, senha.length());
			resp = new BigInteger(1,m.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resp;
	}
	
  /**
   * Dado uma requisicao com os paremetros sendo passados pela a URL pegar os paremetros e criar um nova classe e 
   * inserir no banco 
   * @param req requisicao que o metodo vai receber 
   * @param res resposta que o metodo vai mandar para a pagina, esse uma string
   * @return nova class que acabou de ser criada com resposta
   */
  public String insert(Request req, Response res) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "POST");
	res.type("aplication/json");
    User user = new Gson().fromJson(req.body(), User.class);
    
    if (user == null) {
    	return new String("{\n\t\"Usario invalido\"\n}");
    }
    
    System.out.println(""+user);
    user.setPassword(toMD5(user.getPassword()));
    System.out.println(""+user);
    
//    String resp = "";
     
    // User user = new User(email, toMD5(senha), nome, tipo_cadastro);
      
   
    if (UserDAO.insert(user) == true) {
//      resp = "Usuário (" + nome + ") inserido";
      res.status(201);
    } else {
//        resp = "Usuário (" + nome + ") não inserido!";
        res.status(404); // 404 Not found
      }

    
    return new String("{\n\t\"Usario inserio com sucesso\"\n}");
  }
  
  /**
   * Pegar penas um registro no banco de dados, dado um paremetro nomeado na URL
   * @param req requerimento para pegar os dados necessarios
   * @param res resposta para o servico que ele foi chamado
   * @return a classe na sua formatacao como toString, apresentado os atributos dela
   */
  public String get(Request req, Response res) {
	res.type("aplication/json");
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "GET");
    int id = Integer.parseInt(req.params(":id"));       
    User user = (User) UserDAO.get(id);
    
    if (user != null) {
      
	    Map<String, Object> preJson = new HashMap<>();
	    preJson.put("id", id);
	    preJson.put("username", user.getUsername());
	    preJson.put("email", user.getEmail());
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
  public User update(Request req, Response res) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "PUT");
    int id = Integer.parseInt(req.params(":id"));
    User user = UserDAO.get(id);
//    String resp = "";       

    if (user != null) {
//        user.setId(Integer.parseInt(req.queryParams("ID_Usuario")));
        user.setUsername(req.queryParams("nome"));
        user.setUsername(req.queryParams("email"));
        user.setPremium(Boolean.parseBoolean(req.queryParams("cadastro")));
        UserDAO.update(user);
        res.status(200); // success
//        resp = "Usuário (ID " + user.getId() + ") atualizado!";
    } else {
        res.status(404); // 404 Not found
//        resp = "Usuário (ID \" + user.getId() + \") não encontrado!";
        user = null;
    }
    return user;
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
    User user = UserDAO.get(id);
//    String resp = "";
    boolean status = false;
    
    if (user != null) {
      status = UserDAO.delete(id);
      res.status(200);
    } else {
      res.status(404);
    }
    
    return status;
  }
  
  public String validate(Request req, Response res) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Method", "GET");
	
	String username = req.params(":username");
	String password = toMD5(req.params(":password"));
    User user = (User) UserDAO.getWithPassword(username);
    
    if (user != null) {
    	System.out.println(user.getPassword());
    	System.out.println(user.getEmail());
    	System.out.println(user.getId());
    	if (user.getPassword().equals(password)) {
    		Map<String, Object> preJson = new HashMap<>();
		    preJson.put("id", user.getId());
		    res.status(200);
		    return new Gson().toJson(preJson);
    	} else {
    		res.status(403);
    	}
	    
    } else {
      res.status(404);
    }
    
    return new Gson().toJson(null);
	
  }
  
}
