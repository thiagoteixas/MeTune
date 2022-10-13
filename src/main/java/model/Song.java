package model;

public class Song {

	private int id;
	private String name;
	private int duration;
	private int author;
	
	public Song(int id, String name, int duration, int author) {
      this.id = id;
      this.name = name;
      this.duration = duration;
      this.author = author;
  }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getAuthor() {
        return author;
    }
  
    public void setAuthor(int author) {
        this.author = author;
    }

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", duration=" + duration + "]";
	}
	
}
