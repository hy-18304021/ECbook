package bean;

import java.io.Serializable;

public class EbArrivalBean implements Serializable{
    private int arrival_id;     //入荷id
    private int arrival_price;  //仕入れ値
    private String book_isbn;   //isbnコード
    private int arrival_amount; //正の値、同時にEBBOOKのbook_amountを変更する。book_amountの上限越えないように

    public EbArrivalBean(){}

    public void setArrival_id(int id){
        arrival_id=id;
    }

    public void setArrival_price(int price){
        arrival_price=price;
    }

    public void setBook_isbn(String isbn){
        book_isbn=isbn;
    }

    public void setArrival_amount(int amount){
        arrival_amount=amount;
    }

    public int getArrival_id(){
        return arrival_id;
    }

    public int getArrival_price(){
        return arrival_price;
    }

    public String getBook_isbn(){
        return book_isbn;
    }

    public int getArrival_amount(){
        return arrival_amount;
    }
   
}