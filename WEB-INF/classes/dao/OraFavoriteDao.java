package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbFavoriteBean;

//ebfavorite�ɑ΂���SQL
public class OraFavoriteDao implements FavoriteDao{
    PreparedStatement st=null;
    Connection cn=null;
    ResultSet rs = null;
   public void addFavorite(EbFavoriteBean ef){
    try{
        if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
        }
        //SQL������
        String sql= "insert into ebfavorite values(?,?)";

        //st�̃C���X�^���X�擾
        st=cn.prepareStatement(sql);

        //�o�C���h�ϐ��̐ݒ�
        st.setString(1,ef.getUser_id());
        st.setString(2,ef.getBook_isbn());


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
   public ArrayList getUserFavorite(String user_id){
    ArrayList<EbFavoriteBean> userfavorites = new ArrayList();
    try{
        if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
        }
        String sql= "select * from ebfavorite where user_id = ?";
        st=cn.prepareStatement(sql);

        st.setString(1,user_id);
        rs=st.executeQuery();
        while(rs.next()){
            EbFavoriteBean ef=new EbFavoriteBean();
            ef.setUser_id(rs.getString("user_id"));
            ef.setBook_isbn(rs.getString("book_isbn"));
            userfavorites.add(ef);
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
    return userfavorites;
   }
   public List getAllFavorite(){
    ArrayList<EbFavoriteBean> favoritedates=new ArrayList<>();

    try{
        if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
        }

        String sql="select * from ebfavorite";
        st=cn.prepareStatement(sql);

        rs=st.executeQuery();

        while(rs.next()){
            EbFavoriteBean ef=new EbFavoriteBean();

            ef.setUser_id(rs.getString("user_id"));
            ef.setBook_isbn(rs.getString("book_isbn"));

            favoritedates.add(ef);
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
    return favoritedates;
   }
   public void upDateFavorite(EbFavoriteBean ef){
    try{
        if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
        }

        //SQL������
        String sql="update ebfavorite set user_id=?,book_isbn=? where user_id=?";

        st=cn.prepareStatement(sql);

        st.setString(1,ef.getUser_id());
        st.setString(2,ef.getBook_isbn());
        st.setString(3,ef.getUser_id());

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
   public void deleteFavorite(EbFavoriteBean ef){
    try{
        if(cn==null){
            cn=OracleConnect.getInstance().getConnection();
        }

        //SQL������
        String sql= "delete from ebfavorite where user_id = ? AND book_isbn=? ";

        //st�̃C���X�^���X�擾
        st=cn.prepareStatement(sql);
        st.setString(1,ef.getUser_id());
        st.setString(2,ef.getBook_isbn());

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
   public boolean checkFavorite(EbFavoriteBean ef){
        boolean checked = false;
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }
        String sql="select * from ebfavorite where user_id = ? AND book_isbn = ?";
        st=cn.prepareStatement(sql);
        st.setString(1,ef.getUser_id());
        st.setString(2,ef.getBook_isbn());

        rs = st.executeQuery();
        if(rs.next()){
            checked = true;
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
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return checked;
    }
}