package dao;

import java.util.List;
import bean.EbCartBean;

//ebcart�ɑ΂���SQL
public interface CartDao{
   public void addCart(EbCartBean ec);
   public EbCartBean getCart(String key);
   public List getAllCart();
   public void upDateCart(EbCartBean ec);
   public void deleteCart(EbCartBean ec);
}