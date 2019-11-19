package bean;

public class EBBookBean{
    int book_kind;//本ID
    int book_price;//本値段
    int book_count;//本在庫
    String book_image;//本画像
    String book_isbn;//ISBNコード     
    String book_name;//本題名    
    String small_genre_name;//小ジャンル名
    String lage_genre_name;//大ジャンル名

    public EBBookBean(){}

    public void setBook_kind(int kind){
        book_kind=kind;
    }

    public int getBook_kind(){
        return book_kind;
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
    public void setAll(int kind, String name, int price,int count, String isbn){
        book_kind = kind;
        book_name = name;
        book_price = price;
        book_count = count;
        book_isbn = isbn;
    }
}