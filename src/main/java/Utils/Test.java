package Utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;

public class Test {

	  public boolean insert(Request req, Response res) {
		  boolean resp = true;
		  
//		  System.out.println(req.body());
//		  System.out.println(req.body().toString());
		  System.out.println(req.queryParams("titulo"));
		  
		  return resp;
	  }

	public Object get(Request request, Response response) {
		Response resp = response;
		resp.type("aplication/json");
		Map<String, Object> map = new HashMap<>();
		map.put("test", "METUNE");
		return new Gson().toJson(map);
	}
}
