package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbFavotiteBean;

//ebfavotite�ɑ΂���SQL
public class OraFavotiteDao implements FavotiteDao{
   public void addFavotite(EbFavotiteBean ec){
    PreparedStatement st=null;
    Connection cn=null;

    try{
        cn=OracleConnect.getInstance().getConnection();

        //SQL������
        String sql= "insert into ebfavotite values(?,?)";

        //st�̃C���X�^���X�擾
        st=cn.prepareStatement(sql);

        //�o�C���h�ϐ��̐ݒ�
        st.setString(1,ec.getUser_id());
        st.setString(2,ec.getGenre_name());


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
   public EbFavotiteBean getFavotite(String key){
    PreparedStatement st=null;
    Connection cn=null;
    ResultSet rs=null;
    EbFavotiteBean eb=new EbFavotiteBean();

    try{
        cn=OracleConnect.getInstance().getConnection();

        //SQL������
        String sql= "select * from ebcerdit where address_id = ?";

        //st�̃C���X�^���X�擾
        st=cn.prepareStatement(sql);

        st.setString(1,key);
        
        rs=st.executeQuery();
        while(rs.next()){
            eb.setUser_id(rs.getString("user_id"));
            eb.setGenre_name(rs.getString("book_isbn"));
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
    return eb;
   }
   public List getAllFavotite(){
    Connection cn=null;
    PreparedStatement st=null;
    ResultSet rs=null;

    ArrayList<EbFavotiteBean> favotitedates=new ArrayList<>();

    try{
        cn=OracleConnect.getInstance().getConnection();

        String sql="select * from ebcresit";
        st=cn.prepareStatement(sql);

        rs=st.executeQuery();

        while(rs.next()){
            EbFavotiteBean eb=new EbFavotiteBean();

            eb.setUser_id(rs.getString("user_id"));
            eb.setGenre_name(rs.getString("book_isbn"));

            favotitedates.add(eb);
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
    return favotitedates;
   }
   public void upDateFavotite(EbFavotiteBean ec){
    PreparedStatement st=null;
    Connection cn=null;

    try{
        cn=OracleConnect.getInstance().getConnection();

        //SQL������
        String sql="update ebfavotite set user_id=?,book_isbn=? where user_id=?";

        st.setString(1,ec.getUser_id());
        st.setString(2,ec.getGenre_name());
        st.setString(3,ec.getUser_id());

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
   public void deleteFavotite(EbFavotiteBean ec){
    PreparedStatement st=null;
    Connection cn=null;

    try{
        cn=OracleConnect.getInstance().getConnection();

        //SQL������
        String sql= "delete from ebfavotite where user_id=? ";

        //st�̃C���X�^���X�擾
        st=cn.prepareStatement(sql);

        st.setString(1,ec.getUser_id());

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