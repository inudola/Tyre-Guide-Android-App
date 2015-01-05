package dougs.fourwdtyres;

public class Users {
	
	private String _name;
	private String _email;
	
	public Users(){		
	}
	
	public Users( String name, String email){
		this._name = name;
		this._email = email;
	}
	
	public Users(String name){
		this._name = name;		
	}
	
	public void setName(String name){
		this._name = name;
	}
	
	public String getName(){
		return this._name;
	}
	
	public void setEmail(String email){
		this._email = email;
	}
	
	public String getEmail(){
		return this._email;
	}

}
