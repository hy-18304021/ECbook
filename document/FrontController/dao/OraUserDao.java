package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbUserBean;


//ebuser�ɑ΂���SQL�̂܂Ƃ�
public class OraUserDao implements UserDao{
    public void addUser(EbUserBean eu){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "insert into ebuser values(?,?,?,?,?,?)";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            //�o�C���h�ϐ��̐ݒ�
            st.setString(1,eu.getId());
            st.setString(2,eu.getName());
            st.setString(3,eu.getPass());
            st.setString(4,eu.getMail());
            st.setInt(5,eu.getSex());
            st.setString(6,eu.getBirth());


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

    public EbUserBean getUser(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbUserBean eb=new EbUserBean();

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "select * from ebuser where id = ?";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);
            
            st.setString(1,key);

            rs=st.executeQuery();
            while(rs.next()){
                eb.setId(rs.getString("id"));
                eb.setName(rs.getString("name"));
                eb.setPass(rs.getString("pass"));
                eb.setMail(rs.getString("mail"));
                eb.setSex(rs.getInt("sex"));
                eb.setBirth(rs.getString("birth"));
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
    public List getAllUser(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
    
        ArrayList<EbUserBean> userdates=new ArrayList<>();
    
        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebuser";
            st=cn.prepareStatement(sql);
    
            rs=st.executeQuery();
    
            while(rs.next()){
                EbUserBean eb=new EbUserBean();
    
                eb.setId(rs.getString("id"));
                eb.setName(rs.getString("name"));
                eb.setPass(rs.getString("pass"));
                eb.setMail(rs.getString("mail"));
                eb.setSex(rs.getInt("sex"));
                eb.setBirth(rs.getString("birth"));
    
                userdates.add(eb);
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
        return userdates;
    }
    public void upDateUser(EbUserBean eu){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql="update ebuser set id=?,name=?,pass=?,mail=?,sex=?,birth=? where id=?";

            st.setString(1,eu.getId());
            st.setString(2,eu.getName());
            st.setString(3,eu.getPass());
            st.setString(4,eu.getMail());
            st.setInt(5,eu.getSex());
            st.setString(6,eu.getBirth());
            st.setString(7,eu.getId());

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
    public void deleteUser(EbUserBean eu){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "delete from ebuser where id=?";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            st.setString(1,eu.getId());

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