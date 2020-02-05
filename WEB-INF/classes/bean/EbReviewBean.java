package bean;

import java.io.Serializable;

public class EbReviewBean implements Serializable{
    private String book_isbn;
    private String user_id;
    private String review_text;
    private int review_star;
    private String review_date;

    public EbReviewBean(){}

    public void setBook_isbn(String isbn){
        book_isbn=isbn;
    }

    public void setUser_id(String id){
        user_id=id;
    }

    public void setReview_text(String text){
        review_text=text;
    }

    public void setReview_star(int star){
        review_star=star;
    }

    public void setReview_date(String date){
        review_date=date;
    }

    public String getBook_isbn(){
        return book_isbn;
    }

    public String getUser_id(){
        return user_id;
    }

    public String getReview_text(){
        return review_text;
    }

    public int getReview_star(){
        return review_star;
    }

    public String getReview_date(){
        return review_date;
    }
   
}