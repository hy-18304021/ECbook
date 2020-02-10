package bean;
import java.io.Serializable;

public class EbBookBean implements Serializable{
    private int book_amount;//�݌�
    private int book_price;//�P��
    private int genre_id;//�W������ID
    private String book_isbn;//isbn�R�[�h
    private String book_name;//����
    private String publisher;//�o�Ŏ�
    private String series;//�V���[�Y
    private int volume;//�扽����
    private String author;//����
    private String release_date;//�o�œ�
    private String audience;//�Ώہi���l�����Ƃ��j
    private String label;//���[�x��
    private String text_content;//���e����

    //for recommended book
    private int book_star;
    private String genre_name;

    public EbBookBean(){}

    public void setBook_amount(int amount){
        book_amount=amount;
    }

    public void setBook_price(int price){
        book_price=price;
    }

    public void setGenre_id(int genre){
        genre_id=genre;
    }

    public void setBook_isbn(String isbn){
        book_isbn=isbn;
    }

    public void setBook_name(String name){
        book_name=name;
    }

    public void setPublisher(String publisher){
        this.publisher=publisher;
    }

    public void setSeries(String series){
        this.series=series;
    }

    public void setVolume(int volume){
        this.volume=volume;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    public void setRelease_date(String date){
        release_date=date;
    }

    public void setAudience(String audience){
        this.audience=audience;
    }

    public void setLabel(String label){
        this.label=label;
    }

    public void setText_content(String content){
        this.text_content=content;
    }

    public void setBook_star(int book_star){
        this.book_star = book_star;
    }
    public void setGenre_name(String genre_name){
        this.genre_name=genre_name;
    }

    public int getBook_amount(){
        return book_amount;
    }

    public int getBook_price(){
        return book_price;
    }

    public int getGenre_id(){
        return genre_id;
    }

    public String getBook_isbn(){
        return book_isbn;
    }

    public String getBook_name(){
        return book_name;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getSeries(){
        return series;
    }

    public int getVolume(){
        return volume;
    }

    public String getAuthor(){
        return author;
    }

    public String getRelease_date(){
        return release_date;
    }

    public String getAudience(){
        return audience;
    }

    public String getLabel(){
        return label;
    }

    public String getText_content(){
        return text_content;
    }

    public int getBook_star(){
        return book_star;
    }
    public String getGenre_name(){
        return genre_name;
    }
}