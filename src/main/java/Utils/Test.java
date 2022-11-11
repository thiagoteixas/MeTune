package Utils;

import java.util.HashMap;
import java.util.Map;


import com.google.gson.Gson;

import dao.UserDAO;
import model.User;
import service.UserService;
import spark.Request;
import spark.Response;

public class Test {

	  public static boolean insert(Request req, Response res) {
		  boolean resp = true;
		  
		  System.out.println(req.body());
//		  System.out.println(req.body().toString());
//		  System.out.println(req.queryParams("titulo"));
		  
		  return resp;
	  }

	public static Object get(Request request, Response response) {
		Response resp = response;
		resp.type("aplication/json");
		Map<String, Object> map = new HashMap<>();
		map.put("test", "METUNE");
		return new Gson().toJson(map);
	}
	
	public static void sqlInjectUserPass() {
			
		UserDAO us = new UserDAO();
		
		User user = us.getWithPassword("X' OR 'X' LIKE 'X");
		System.out.println(user);
	}
	
	public static void TestUserpass() {
		
		UserDAO us = new UserDAO();
		
		User user = us.getWithPassword("name1");
		System.out.println(user);
	}
	
	public static void main(String[] args) {
		
		sqlInjectUserPass();
		TestUserpass();
	}
}
