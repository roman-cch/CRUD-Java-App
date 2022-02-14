
public class Usuario {
	
	protected int id;
	protected String login;
	protected String password;
	
	public Usuario() {
		this.login = "-";
		this.password = "-";
	}
	public Usuario(String u, String p) {
		this.login = u;
		this.password = p;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
