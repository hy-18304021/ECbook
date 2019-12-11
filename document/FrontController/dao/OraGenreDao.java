package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbGenreBean;

//ebgenre�ɑ΂���SQL
public class OraGenreDao implements GenreDao{
    public void addGenre(EbGenreBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "insert into ebgenre values(?,?)";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            //�o�C���h�ϐ��̐ݒ�
            st.setInt(1,ec.getGenre_id());
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
    public EbGenreBean getGenre(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbGenreBean eb=new EbGenreBean();

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "select * from ebgenre where genre_id = ?";

            st.setInt(1,Integer.parseInt(key));

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                eb.setGenre_id(rs.getInt("genre_id"));
                eb.setGenre_name(rs.getString("genre_name"));
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
    public List getAllGenre(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbGenreBean> genredates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebcresit";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbGenreBean eb=new EbGenreBean();

                eb.setGenre_id(rs.getInt("genre_id"));
                eb.setGenre_name(rs.getString("genre_name"));

                genredates.add(eb);
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
        return genredates;
    }
    public void upDateGenre(EbGenreBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql="update ebgenre set genre_id=?,genre_name where genre_id=?";

            st.setInt(1,ec.getGenre_id());
            st.setString(2,ec.getGenre_name());
            st.setInt(3,ec.getGenre_id());

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
    public void deleteGenre(EbGenreBean ec){}
}