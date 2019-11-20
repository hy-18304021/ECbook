package bean;

import java.io.Serializable;

public class UserInfoBean implements Serializable{
    String id;
    String pass;
    String mail;
    int sex;
    int birth;

    public UserInfoBean(){}

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
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

    public void setBirth(int birth){
        this.birth=birth;
    }
    public int setBirth(){
        return birth;
    }
}