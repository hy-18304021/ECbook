package dao;

import java.util.List;
import bean.Product;

public interface ProductDao{
   public void addProduct(Product p);
   public Product getProduct(String key);
   public List getAllProduct();
   public void upProduct(Product p);
   public void delProduct(Product p);
}