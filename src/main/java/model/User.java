package model;

public class User {

	private int id;
	private String email;
	private String password;
	private String username;
	private boolean isPremium;
	

	public User(int id, String email, String username, boolean isPremium) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.isPremium = isPremium;
	}


	public User(String email, String password, String username, boolean isPremium) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.isPremium = isPremium;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
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

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
