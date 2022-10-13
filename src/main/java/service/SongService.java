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
  
  public Song insert(Request req, Response res) {
    int id = Integer.parseInt(req.queryParams("ID_musica"));
    String autor_temp = req.queryParams("Autor");
    String titulo = req.queryParams("Titulo");
    int duracao = Integer.parseInt(req.queryParams("Duracao"));
    int autor = -1;
    
    String resp = "";
    Song song = new Song(id, titulo, duracao, autor);
    
    if (autor_temp != null) {
      autor = Integer.parseInt(autor_temp);
      song.setAuthor(autor);
      
    
    if (SongDAO.insert(song) == true) {
      resp = "Música (" + titulo + ") inserida";
      res.status(201);
    } else {
        resp = "Produto (" + titulo + ") não inserido!";
        res.status(404); // 404 Not found
      }

    }
    return song;
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
        song.setAuthor(Integer.parseInt(req.queryParams("ID_Musica")));
        song.setName(req.queryParams("Titulo"));
        song.setDuration(Integer.parseInt(req.queryParams("Duracao")));
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


