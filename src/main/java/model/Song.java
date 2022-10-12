package model;

public class Song {

	private String id;
	private String name;
	private int duration;
	
	public Song(String id, String name, int duration) {
		this.id = id;
		this.name = name;
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", duration=" + duration + "]";
	}
	
}
