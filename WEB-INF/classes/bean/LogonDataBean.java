package bean;

public class LogonDataBean{
	private String id;//id
	private String pass;//passward
	private String name;//名前
	//private String address;住所
	private String tel;//電話番号
	private String birth;//生年月日
	private String sex;//性別
	private String mail;//メール

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getPass(){
		return pass;
	}

	public void setPass(String pass){
		this.pass = pass;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getTel(){
		return tel;
	}

	public void setTel(String tel){
		this.tel = tel;
	}

	public String getBirth(){
		return birth;
	}

	public void setBirth(String birth){
		this.birth = birth;
	}

	public String getSex(){
		return sex;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public String getMail(){
		return mail;
	}

	public void setMail(String mail){
		this.mail = mail;
	}
}
