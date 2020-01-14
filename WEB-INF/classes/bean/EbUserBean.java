package bean;

import java.io.Serializable;

public class EbUserBean implements Serializable{
    String id;
    String name;
    String pass;
    String mail;
    int sex;
    String birth;

    public EbUserBean(){}

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setPass(String pass){
        this.pass=pass;
    }
    public String getPass(){
        return pass;
    }

    public void setMail(String mail){
        this.mail=mail;
    }
    public String getMail(){
        return mail;
    }

    public void setSex(int sex){
        this.sex=sex;
    }
    public int getSex(){
        return sex;
    }

    public void setBirth(String birth){
        this.birth=birth;
    }
    public String getBirth(){
        return birth;
    }
}