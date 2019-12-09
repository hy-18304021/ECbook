package bean;

import java.io.Serializable;

public class EbSales_RefBean{
    private int sales_id;
    private int sales_amount;
    private String book_isbn;

    public EbSales_RefBean(){}

    public void setSales_id(int id){
        sales_id=id;
    }

    public void setSales_amount(int amount){
        sales_amount=amount;
    }
   
    public void setBook_isbn(String isbn){
        book_isbn=isbn;
    }

    public int getSales_id(){
        return sales_id;
    }

    public int getSales_amount(){
        return sales_amount;
    }

    public int getBook_isbn(){
        return book_isbn;
    }
}