package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbCartBean;

//ebcart�ɑ΂���SQL
public class OraCartDao implements CartDao{
   public void addCart(EbCartBean ec){
      PreparedStatement st=null;
      Connection cn=null;

      try{
         n=OracleConnect.getInstance().getConnection();

         //SQL������
         String sql= "insert into ebcart values(?,?,?)";

         //st�̃C���X�^���X�擾
         st=cn.prepareStatement(sql);

         //�o�C���h�ϐ��̐ݒ�
         st.setString(1,ec.getUser_id());
         st.setString(2,ec.getBook_isbn());
         st.setInt(3,ec.getCart_amount());


         st.executeUpdate();
      }catch(SQLException e){
         //���[���o�b�N����
         OracleConnect.getInstance().rollback();
      }finally{
         //���\�[�X���
         try{
               if(st!=null){
                  st.close();
               }
         }catch(SQLException e){
               e.printStackTrace();
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
         //���[���o�b�N����
         OracleConnect.getInstance().rollback();
      }finally{
         //���\�[�X���
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
   public void upDateCart(EbCartBean ec){
      PreparedStatement st=null;
      Connection cn=null;

      try{
         cn=OracleConnect.getInstance().getConnection();

         //SQL������
         String sql="update ebcart set user_id=?,book_isbn=?,cart_amount=? where user_id=?";

         st.setString(1,ec.getUser_id());
         st.setString(2,ec.getBook_isbn());
         st.setInt(3,ec.getCart_amount());
         st.setString(4,ec.getUser_id());

         st.executeUpdate();
      }catch(SQLException e){
         //���[���o�b�N����
         OracleConnect.getInstance().rollback();
      }finally{
         //���\�[�X���
         try{
            if(st!=null){
               st.close();
            }
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
   }
   public void deleteCart(EbCartBean ec){
      PreparedStatement st=null;
      Connection cn=null;

      try{
         cn=OracleConnect.getInstance().getConnection();

         //SQL������
         String sql= "delete from ebcart where user_id=? AND book_isbn=?";

         //st�̃C���X�^���X�擾
         st=cn.prepareStatement(sql);

         st.setString(1,ec.getUser_id());
         st.setString(2,ec.getBook_isbn());

         st.executeUpdate();
      }catch(SQLException e){
         //���[���o�b�N����
         OracleConnect.getInstance().rollback();   
            }finally{
         //���\�[�X���
         try{
            if(st!=null){
                  st.close();
               }
         }catch(SQLException e){
               e.printStackTrace();
         }
      }
   }
}