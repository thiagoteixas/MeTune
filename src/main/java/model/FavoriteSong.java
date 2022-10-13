package model;

public class FavoriteSong {
  private int user_id;
  private int song_id;

  public FavoriteSong() {
    this.user_id = -1;
    this.song_id = -1;
  }

  public FavoriteSong(int user_id, int song_id) {
    this.user_id = user_id;
    this.song_id = song_id;
  }

  public int getUserId() {
    return user_id;
  }

  public int getSongId() {
    return song_id;
  }

  public void setUserId(int id) {
    this.user_id = id;
  }

  public void setSongId(int id) {
    this.song_id = id;
  }

  @Override
  public String toString() {
    return "FavoriteSong [song_id=" + song_id + ", user_id=" + user_id + "]";
  }
}
