package bean;

public class SelectOracleBean{
    int book_id;//�{ID
    int book_price;//�{�l�i
    int book_count;//�{�݌�
    String book_image;//�{�摜
    String book_isbn;//ISBN�R�[�h     
    String book_name;//�{�薼    
    String small_genre_name;//���W��������
    String lage_genre_name;//��W��������

    public SelectOracleBean(){}

    public void setBook_id(int id){
        book_id=id;
    }

    public int getBook_id(){
        return book_id;
    }

    public void setBook_price(int price){
        book_price=price;
    }

    public int getBook_price(){
        return book_price;
    }

    public void setBook_count(int count){
        book_count=count;
    }

    public int getBook_count(){
        return book_count;
    }

    public void setBook_image(String image){
        book_image=image;
    }

    public String getBook_image(){
        return book_image;
    }

    public void setBook_name(String name){
        book_name=name;
    }

    public String getBook_name(){
        return book_name;
    }

    public void setSmall_genre_name(String genre_name){
        small_genre_name=genre_name;
    }

    public String getSmall_genre_name(){
        return small_genre_name;
    }

    public void setLage_genre_name(String genre_name){
        lage_genre_name=genre_name;
    }

    public String getLage_genre_name(){
        return book_image;
    }

    public void setBook_isbn(String isbn){
        book_isbn=isbn;
    }

    public String getBook_isbn(){
        return book_isbn;
    }
}