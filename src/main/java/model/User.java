package model;

public class User {

	private String id;
	private String email;
	private String username;
	private boolean isPremium;
	

	public User(String id, String email, String username, boolean isPremium) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.isPremium = isPremium;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", isPremium=" + isPremium + "]";
	}
	
	
}
