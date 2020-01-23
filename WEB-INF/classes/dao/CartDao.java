package dao;

import java.util.List;
import java.util.ArrayList;
import bean.EbCartBean;

//ebcart‚É‘Î‚·‚éSQL
public interface CartDao{
   public void addCart(EbCartBean ec);
   public EbCartBean getCart(String key);
   public List getAllCart();
   public int amountCheck(String user_id,String book_isbn);
   public void updateCart(EbCartBean ec);
   public void deleteBook(EbCartBean ec);
   public ArrayList getUserCartInfo(String user_id);
}