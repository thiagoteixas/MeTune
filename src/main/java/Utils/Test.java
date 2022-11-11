package Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.gson.Gson;

import dao.SongDAO;
import dao.UserDAO;
import model.Song;
import model.User;
import service.UserService;
import spark.Request;
import spark.Response;

public class Test {

	public static UserDAO us = new UserDAO();
	public static SongDAO songDAO = new SongDAO();
	
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
		System.out.println("Test sql injection: " + user);
	}
	
	public static void TestUserpass() {
			
		User user = us.getWithPassword("Pedro Silva");
		System.out.println("test get user with password:" + user);
	}
	
	public static void TestUserget() {
		
		List<User> user = us.get();
		for (User us : user) {
			System.out.println("Test get all: " + us);
		}
	}
	
	public static void testUserUpdate() {
		User u = new User(1, "dev@dev.com", "mikeeeeee", false);
		
		if (us.update(u)) {
			System.out.println("update ok");
		}
	}
	
	public static void testUserDelete() {
//		:)	
	}
	
	public static void testSongInsert() {
		Song song = new Song(0, "mike", 120, 2);
		System.out.println("song foi inserido: " + songDAO.insert(song));
	}
	
	public static void testSongGet() {
		Song song = songDAO.get(1);
		
		System.out.println("Song foi pego: " + song);
	}
	
	public static void testSongGetAll() {
		List<Song> allSong = songDAO.getAll();
		
		for (Song e : allSong) {
			System.out.println("Testar totas musicas: " + e);
		}
	}
	
	public static void testSongGetName() {
		Song song = songDAO.getByName("song1");
		
		System.out.println("Test get song by name: " + song);
	}
	
	
	
	public static void main(String[] args) {
		
		sqlInjectUserPass();
		TestUserpass();
//		TestUserget();
//		testUserUpdate();
		
//		testSongInsert();
//		testSongGet();
//		testSongGetAll();
//		testSongGetName();
	}
}
