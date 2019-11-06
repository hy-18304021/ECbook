 package DBOracle;
 import java.util.ArrayList;
public class OracleProfile{
	private String id;
	private String name;
	private String pass;
	private String tel;
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
	public void setPass(String pass){
		this.pass = pass;
	}
	public String getTel(){
		return tel;
	}
	public void setTel(String tel){
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

	public void setAll(ArrayList information){
		setId((String)information.get(0));
		setName((String)information.get(1));
		setPass((String)information.get(2));
		setTel((String)information.get(3));
		setMail((String)information.get(4));
		setSex(Integer.parseInt((String)information.get(5)));
		setBirth(Integer.parseInt((String)information.get(6)));
	}
}