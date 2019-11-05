 package DBOracle;
public class OracleProfile{
	private String id;
	private String name;
	private String pass;
	private int tel;
	private String mail;
	private int sex;
	private int birth; 

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getPass(){
		return pass;
	}
	public void setPassword(String pass){
		this.pass = pass;
	}
	public int getTel(){
		return tel;
	}
	public void setTel(int tel){
		this.tel=tel;
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail=mail;
	}
	public int getSex(){
		return sex;
	}
	public void setSex(int sex){
		this.sex=sex;
	}
	public int getBirth(){
		return birth;
	}
	public void setBirth(int birth){
		this.birth=birth;
	}
}