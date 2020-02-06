package bean;
import java.io.Serializable;
import java.util.ArrayList;

public class EbCartBean implements Serializable{
	private String user_id;
	private String book_isbn;
	private int cart_amount;
	private String book_name;
	private String book_price;
	public EbCartBean(){}

	public void setUser_id(String user_id){
		this.user_id=user_id;
	}
	public String getUser_id(){
		return user_id;
	}
	public void setBook_isbn(String book_isbn){
		this.book_isbn=book_isbn;
	}
	public String getBook_isbn(){
		return book_isbn;
	}
	public void setCart_amount(int cart_amount){
		this.cart_amount=cart_amount;
	}
	public int getCart_amount(){
		return cart_amount;
	}
	public void setBook_name(String book_name){
		this.book_name=book_name;
	}
	public String getBook_name(){
		return book_name;
	}
	public void setBook_price(String book_price){
		this.book_price=book_price;
	}
	public String getBook_price(){
		return book_price;
	}
	// public void setAllCartInfo(ArrayList cartinfo){
	// 	setUser_id((String)cartinfo.get(0));
	// 	setBook_name((String)cartinfo.get(1));
	// 	setCart_amount(Integer.parseInt((String)cartinfo.get(3)));
	// }
}