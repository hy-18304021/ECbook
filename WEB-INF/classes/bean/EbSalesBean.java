package bean;

import java.io.Serializable;

public class EbSalesBean implements Serializable{

    private int sales_id;
    private String user_id;
    private String sales_date;
    private int address_id;
    private String pay_method;


    public EbSalesBean(){}

    public void setSales_id(int id){
        sales_id=id;
    }
    
    public void setUser_id(String user){
        user_id=user;
    }

    public void setSales_date(String date){
        sales_date=date;
    }

    public void setAddress_id(int id){
        address_id=id;
    }

    public void setPay_method(String method){
        pay_method=method;
    }

    public int getSales_id(){
        return sales_id;
    }

    public String getUser_id(){
        return user_id;
    }

    public String getSales_date(){
        return sales_date;
    }
    
    public int getAddress_id(){
        return address_id;
    }

    public String getPay_method(){
        return pay_method;
    }
}