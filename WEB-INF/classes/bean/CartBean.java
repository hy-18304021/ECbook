package bean;
import java.io.Serializable;
import java.util.ArrayList;

public class CartBean{
	private String user_id;
	private String book_isbn;
	private int cart_amount;
	public CartBean(){}

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
	// public void setAllCartInfo(ArrayList cartinfo){
	// 	setUser_id((String)cartinfo.get(0));
	// 	setBook_name((String)cartinfo.get(1));
	// 	setCart_amount(Integer.parseInt((String)cartinfo.get(3)));
	// }
}