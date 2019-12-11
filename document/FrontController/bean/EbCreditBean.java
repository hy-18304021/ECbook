package bean;

import java.io.Serializable;

public class EbCreditBean implements Serializable{
    private String user_id;
    private String card_name;
    private String card_number;
    private String security_number;
    private String card_expiration;

    public EbCreditBean(){}

    public void setUser_id(String id){
        user_id=id;
    }

    public void setCard_name(String name){
        card_name=name;
    }

    public void setCard_number(String number){
        card_number=number;
    }

    public void setSecurity_number(String number){
        security_number=number;
    }

    public void setCard_expiration(String expiration){
        card_expiration=expiration;
    }

    public String getUser_id(){
        return user_id;
    }

    public String getCard_name(){
        return card_name;
    }

    public String getCard_number(){
        return card_number;
    }

    public String getSecurity_number(){
        return security_number;
    }

    public String getCard_expiration(){
        return card_expiration;
    }
   
}