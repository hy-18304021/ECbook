package bean;

import java.io.Serializable;

public class EbFavoriteBean implements Serializable{
    private String user_id;
    private String book_isbn;    

    public EbFavoriteBean(){}

    public void setUser_id(String id){
        user_id=id;
    }

    public void setBook_isbn(String isbn){
        book_isbn=isbn;
    }

    public String getUser_id(){
        return user_id;
    }

    public String getBook_isbn(){
        return book_isbn;
    }
   
}