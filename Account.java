

public class Account {
	private String name;
	private String username;
	private String password;
	private String phone;
	
	public Account(String name,String username,String password,String phone){
		this.name=name;
		this.username=username;
		this.password=password;
		this.phone=phone;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
}
