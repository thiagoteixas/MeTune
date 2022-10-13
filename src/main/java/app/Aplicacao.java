package app;
import static spark.Spark.*;

import service.*;
import model.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Aplicacao {
  
    public static SongService SongService = new SongService();
    public static TagService TagService = new TagService();
    public static UserService UserService = new UserService();
    
	
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
	  
	  post("/song", (request, response) -> SongService.insert(request, response));
	  get("/song/:id", (request, response) -> SongService.get(request, response));
	  put("/song/update/:id", (request, response) -> SongService.update(request, response));
	  get("/song/delete/:id", (request, response) -> SongService.delete(request, response));
	} 
}