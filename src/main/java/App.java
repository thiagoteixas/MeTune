import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;


public class App {
	
	public static void main(String[] args) {
		
		
        staticFiles.location("/public");
        
        get("/", (req, res) -> {
        	Map<String, Object> map = new HashMap<>();
        	map.put("Soforca", "tenta");
        	return new FreeMarkerEngine().render(
        		new ModelAndView(map, "template.ftl")
        	);
        });
        
        get("/test", (req, res) -> {
        	Map<String, Object> map = new HashMap<>();
        	map.put("test", "METUNE");
        	return new FreeMarkerEngine().render(
        		new ModelAndView(map, "/test/login.ftl")
        	);
        });
        
       get("/post", (req, res) -> {
    	   	res.type("aplication/json");
    	   	Map<String, Object> map = new HashMap<>();
       		map.put("test", "METUNE");
//       		System.out.println(map);
       		return new Gson().toJson(map); 
//       		return map;
       });
	}
}