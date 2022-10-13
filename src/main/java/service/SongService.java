package service;

import dao.SongDAO;
import model.Song;

import spark.Request;
import spark.Response;

public class SongService {
  private SongDAO SongDAO;
  
  public SongService() {
    try {
      SongDAO = new SongDAO();
      SongDAO.conectar();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  public String insert(Request req, Response res) {
//    int id = Integer.parseInt(req.queryParams("ID_musica"));
    String titulo = req.queryParams("titulo");
    int duracao = Integer.parseInt(req.queryParams("duracao"));
    int autor = 1;
    
    System.out.println("test");
    
    String resp = "";
    Song song = new Song(titulo, duracao, autor);
    
    if (req.queryParams("Autor") != null) {
      autor = Integer.parseInt(req.queryParams("Autor"));
      song.setAuthor(autor);
    }
      
    
    if (SongDAO.insert(song) == true) {
      resp = "Música (" + titulo + ") inserida";
      System.out.println("Música (" + titulo + ") inserida");
      res.status(201);
    } else {
        resp = "Produto (" + titulo + ") não inserido!";
        System.out.println("Produto (" + titulo + ") não inserido!");
        res.status(404); // 404 Not found
      }

    return resp;
  }
  
  public Song get(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));       
    Song song = (Song) SongDAO.get(id);
    
    
    if (song != null) {
      res.status(200);
    } else {
      res.status(404);
    }
    
    return song;
  }
  
  public Song update(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));
    Song song = SongDAO.get(id);
    String resp = "";       

    if (song != null) {
//        song.setAuthor(Integer.parseInt(req.queryParams("ID_Musica")));
        song.setName(req.queryParams("titulo"));
        song.setDuration(Integer.parseInt(req.queryParams("duracao")));
        SongDAO.update(song);
        res.status(200); // success
        resp = "Musica (ID " + song.getId() + ") atualizado!";
    } else {
        res.status(404); // 404 Not found
        resp = "Musica (ID \" + song.getId() + \") não encontrado!";
        song = null;
    }
    return song;
  }
  
  public boolean delete(Request req, Response res) {
    int id = Integer.parseInt(req.params(":id"));
    Song song = SongDAO.get(id);
    String resp = "";
    boolean status = false;
    
    if (song != null) {
      status = SongDAO.delete(id);
      res.status(200);
    } else {
      res.status(404);
    }
    
    return status;
  }
  
  /*
   * public Object addSong() {}
   * public Object getSong() {}
   * public Object updateSong() {}
   * public Object deleteSong() {}
   * */
}


