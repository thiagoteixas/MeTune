package app;
import static spark.Spark.*;
// import app.Cors;

import service.*;
import Utils.*;


public class Aplicacao {
  
    public static SongService SongService = new SongService();
    public static TagService TagService = new TagService();
    public static UserService UserService = new UserService();
    public static Test testRoutes = new Test();
    public static ProfileService profile = new ProfileService();
    
	
	public static void main(String[] args) {
		
		//port(****);
		// get("/profile/:id", (request, response) -> profile.get(request, response));
		
		//Cors.apply();
		
		get("/home", (request, response) -> SongService.getAll(request, response));
	  // Song Crud routes
	  post("/song", (request, response) -> SongService.insert(request, response));
	  get("/song/:id", (request, response) -> SongService.get(request, response));
	  post("/song/update/:id", (request, response) -> SongService.update(request, response));
	  get("/song/delete/:id", (request, response) -> SongService.delete(request, response));
	  
	  // Tag Crud routes
	  
	  post("/tag", (request, response) -> TagService.insert(request, response));
      get("/tag/:id", (request, response) -> TagService.get(request, response));
      get("/tag", (request, response) -> TagService.getAll(request, response));
      put("/tag/update/:id", (request, response) -> TagService.update(request, response));
      get("/tag/delete/:id", (request, response) -> TagService.delete(request, response));
      
      // User Crud routes
      
      post("/user", (request, response) -> UserService.insert(request, response));
      get("/user/:id", (request, response) -> UserService.get(request, response));
      put("/user/update/:id", (request, response) -> UserService.update(request, response));
      get("/user/delete/:id", (request, response) -> UserService.delete(request, response));
      get("/user/validation/:username/:password", (request, response) -> UserService.validate(request, response));
      
      
      // Test routes
      post("/test", (request, response) -> testRoutes.insert(request, response));	
      get("/test2", (request, response) -> testRoutes.get(request, response));
	} 
}