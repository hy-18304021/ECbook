package bean;

public class EBBookBean{
    private int book_amount;//在庫
    private int book_price;//単価
    private int genre_id;//ジャンルID
    private String book_isbn;//isbnコード
    private String book_name;//書名
    private String publisher;//出版社
    private String series;//シリーズ
    private int volume;//第何巻か
    private String author;//著者
    private int release_date;//出版日
    private String audience;//対象（成人向けとか）
    private String label;//レーベル
    private String text_content;//内容説明


    public EBBookBean(){}

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

    public void setRelease_date(int date){
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

    public int getRelease_date(){
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

}