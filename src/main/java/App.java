import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;


public class App {
	
	public static void main(String[] args) {
		
        
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