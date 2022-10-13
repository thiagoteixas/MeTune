package app;
import static spark.Spark.*;

import service.*;
import model.*;
import Utils.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Aplicacao {
  
    public static SongService SongService = new SongService();
    public static TagService TagService = new TagService();
    public static UserService UserService = new UserService();
    public static Test testRoutes = new Test();
    
	
	public static void main(String[] args) {
		//port(****);
	  
      /*  post("/post", (request, response) -> {
    	   	response.type("aplication/json");
    	   	Map<String, Object> map = new HashMap<>();
       		map.put("test", "METUNE");
//       		System.out.println(map);
       		return new Gson().toJson(map);
//       		return map;
       });*/
	  // Song routes
	  post("/song", (request, response) -> SongService.insert(request, response));
	  get("/song/:id", (request, response) -> SongService.get(request, response));
	  put("/song/update/:id", (request, response) -> SongService.update(request, response));
	  get("/song/delete/:id", (request, response) -> SongService.delete(request, response));
	  
	  // Tag routes
	  
	  post("/tag", (request, response) -> TagService.insert(request, response));
      get("/tag/:id", (request, response) -> TagService.get(request, response));
      put("/tag/update/:id", (request, response) -> TagService.update(request, response));
      get("/tag/delete/:id", (request, response) -> TagService.delete(request, response));
      
      // User routes
      
      post("/user", (request, response) -> UserService.insert(request, response));
      get("/user/:id", (request, response) -> UserService.get(request, response));
      put("/user/update/:id", (request, response) -> UserService.update(request, response));
      get("/user/delete/:id", (request, response) -> UserService.delete(request, response));
      
      
      // Test routes
      post("/test", (request, response) -> testRoutes.insert(request, response));	
      get("/test2", (request, response) -> testRoutes.get(request, response));
	} 
}