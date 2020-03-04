package bean;

import java.io.Serializable;

public class EbFavotiteBean implements Serializable{
    private String user_id;
    private String book_isbn;    

    public EbFavotiteBean(){}

    public void setUser_id(String id){
        user_id=id;
    }

    public void setGenre_name(String isbn){
        book_isbn=isbn;
    }

    public String getUser_id(){
        return user_id;
    }

    public String getGenre_name(){
        return book_isbn;
    }
   
}