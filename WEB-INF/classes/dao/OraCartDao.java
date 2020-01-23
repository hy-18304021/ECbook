package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbCartBean;

//ebcartに対するSQL
public class OraCartDao implements CartDao{
      PreparedStatement st=null;
      Connection cn=null;
      ResultSet rs=null;
   
   public void addCart(EbCartBean ec){

      try{
         if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
         }
         
         //SQL文生成
         String sql= "insert into ebcart values(?,?,?)";

         //stのインスタンス取得
         st=cn.prepareStatement(sql);
         st.setString(1,ec.getUser_id());
         st.setString(2,ec.getBook_isbn());
         st.setInt(3,ec.getCart_amount());

         st.executeUpdate();

         
         OracleConnect.getInstance().commit();
      }catch(SQLException e){
         //ロールバック処理
         OracleConnect.getInstance().rollback();
      }finally{
         if(st!=null){
            try{
               st.close();
            }catch(SQLException ex){ ex.printStackTrace();}
         }
      }
   }
   public EbCartBean getCart(String key){
      return null;
   }
   public List getAllCart(){
      Connection cn=null;
      PreparedStatement st=null;
      ResultSet rs=null;
    
      ArrayList<EbCartBean> cartdates=new ArrayList<>();
    
      try{
         cn=OracleConnect.getInstance().getConnection();

         String sql="select * from ebcart";
         st=cn.prepareStatement(sql);
    
         rs=st.executeQuery();
    
         while(rs.next()){
            EbCartBean eb=new EbCartBean();
    
            eb.setUser_id(rs.getString("user_id"));
            eb.setBook_isbn(rs.getString("book_isbn"));
            eb.setCart_amount(rs.getInt("cart_amount"));
    
            cartdates.add(eb);
         }
      }catch(SQLException e){
         //ロールバック処理
         OracleConnect.getInstance().rollback();
      }finally{
         //リソース解放
         try{
            if(st!=null){
               st.close();
            }
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
      return cartdates;
   }
   public void updateCart(EbCartBean ec){
      // PreparedStatement st=null;
      // Connection cn=null;
      String sql="update ebcart set cart_amount = ? where user_id=? and book_isbn=?";

      try{
         if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
         }
         st=cn.prepareStatement(sql);
         st.setString(2,ec.getUser_id());
         st.setString(3,ec.getBook_isbn());
         st.setInt(1,ec.getCart_amount());
         // System.out.println(sql);
         st.executeUpdate();

         OracleConnect.getInstance().commit();
      }catch(SQLException e){
         //ロールバック処理
         OracleConnect.getInstance().rollback();
      }finally{
         //リソース解放
         try{
            if(st!=null){
               st.close();
            }
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
   }
   public void deleteBook(EbCartBean ec){
      // PreparedStatement st=null;
      // Connection cn=null;
      String sql= "delete from ebcart where user_id=? AND book_isbn=?";
      try{
         if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
         }
         //stのインスタンス取得
         st=cn.prepareStatement(sql);

         st.setString(1,ec.getUser_id());
         st.setString(2,ec.getBook_isbn());

         st.executeUpdate();
      }catch(SQLException e){
         //ロールバック処理
         OracleConnect.getInstance().rollback();
            }finally{
         //リソース解放
         try{
            if(st!=null){
                  st.close();
               }
         }catch(SQLException e){
               e.printStackTrace();
         }
      }
   }

   public ArrayList getUserCartInfo(String user_id){
      // Connection cn = null;
      // PreparedStatement st= null;
      // ResultSet rs=null;
      ArrayList array = new ArrayList();
      String sql = "select c.user_id, b.book_isbn, c.cart_amount FROM ebcart c join ebbook b on c.book_isbn=b.book_isbn where user_id=?";
      // System.out.println(sql);

      try{
         if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
         }
         st=cn.prepareStatement(sql);

         st.setString(1,user_id);
         rs=st.executeQuery();
         while(rs.next()){
            EbCartBean cart = new EbCartBean();
            cart.setUser_id(rs.getString("user_id"));
            cart.setBook_isbn(rs.getString("book_isbn"));
            cart.setCart_amount(rs.getInt("cart_amount"));
            // System.out.println("Cart:"+rs.getString("user_id")+rs.getString("book_isbn")+rs.getInt("cart_amount"));
            array.add(cart);
         }
      }catch(SQLException e){
         OracleConnect.getInstance().rollback();
      }finally{
         try{
            if(st!=null){st.close();}
            if(rs!=null){rs.close();}
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
      return array;
   }

   public int amountCheck(String user_id,String book_isbn){
      // Connection cn = null;
      // PreparedStatement st= null;
      // ResultSet rs=null;
      String sql = "select cart_amount from ebcart where user_id=? and book_isbn=?";
      // System.out.println(sql);

      int cart_amount = -1;
      try{
         if(cn==null){
             cn=OracleConnect.getInstance().getConnection();
         }
         st=cn.prepareStatement(sql);

         st.setString(1,user_id);
         st.setString(2,book_isbn);
         rs=st.executeQuery();
         while(rs.next()){
            cart_amount = rs.getInt("cart_amount");
         }
      }catch(SQLException e){
         OracleConnect.getInstance().rollback();
      }finally{
         try{
            if(st!=null){st.close();}
            if(rs!=null){rs.close();}
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
      return cart_amount;
   }
}