package dao;

import java.util.List;
import java.util.ArrayList;
import bean.EbCartBean;
import bean.EbUserBean;

//ebcart‚É‘Î‚·‚éSQL
public interface CartDao{
   public void addCart(EbCartBean ec);
   public EbCartBean getCart(String key);
   // public List getAllCart();
   public int amountCheck(String user_id,String book_isbn);
   public void updateCart(String user_id,String book_isbn,int cart_amount);
   public void deleteBook(String user_id,String book_isbn);
   public ArrayList getUserCartInfo(String user_id);
}