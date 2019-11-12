package bean;

public class MngrDataBean {
	private int book_id; //本の名前
	private String book_kind; //本のジャンル
	private int book_price; //本の価額
	private short book_count; //在庫
	private String book_image; //本のimage
	private int book_isbn;//ISBNコード

	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_kind() {
		return book_kind;
	}
	public void setBook_kind(String book_kind) {
		this.book_kind = book_kind;
	}

	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public short getBook_count() {
		return book_count;
	}
	public void setBook_count(short book_count) {
		this.book_count = book_count;
	}

	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

    public int getBook_isbn() {
		return book_isbn;
	}
    public void setBook_isbn(int book_isbn) {
		this.book_isbn = book_isbn;
	}
}