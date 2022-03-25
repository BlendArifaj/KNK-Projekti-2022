package model;

public class Login {
	private int id;
	private String username;
	private String saltedHash;
	private String salted;
	
	public Login(int id, String username, String saltedHash, String salted) {
		this.id = id;
		this.username = username;
		this.saltedHash = saltedHash;
		this.salted = salted;
	}

	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return this.username;
	}

	public String getSaltedHash() {
		return saltedHash;
	}

	public String getSalted() {
		return salted;
	}
}
