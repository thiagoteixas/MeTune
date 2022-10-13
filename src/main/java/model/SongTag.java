package model;

public class SongTag {

  private int tag_id;
  private int song_id;

  public SongTag() {
    this.tag_id = -1;
    this.song_id = -1;
  }

  public SongTag(int tag_id, int song_id) {
    this.tag_id = tag_id;
    this.song_id = song_id;
  }

  public int getIdTag() {
    return tag_id;
  }

  public int getIdSong() {
    return song_id;
  }

  public void setIdTag(int id) {
    this.tag_id = id;
  }
  
  public void setIdSong(int id) {
    this.song_id = id;
  }
  @Override
  public String toString() {
    return "SongTag [song_id=" + song_id + ", song_tag=" + tag_id + "]";
  }

}
