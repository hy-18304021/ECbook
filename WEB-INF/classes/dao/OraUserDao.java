package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbUserBean;


//ebuserに対するSQLのまとめ
public class OraUserDao implements UserDao{
    Connection cn=null;
    PreparedStatement st=null;
    ResultSet rs = null;
    public int addUser(EbUserBean eu){
        String sql= "insert into ebuser values(?,?,?,?,?,?)";
        int success=0;
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }

            st=cn.prepareStatement(sql);

            //バインド変数の設定
            st.setString(1,eu.getId());
            st.setString(2,eu.getName());
            st.setString(3,eu.getPass());
            st.setString(4,eu.getMail());
            st.setInt(5,eu.getSex());
            st.setString(6,eu.getBirth());

            success=st.executeUpdate();
            System.out.println(success);
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
        System.out.println(success);
        return success;
    }

    public EbUserBean getUser(String key){
        EbUserBean eb=new EbUserBean();
        String sql= "select * from ebuser where id = ?";
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }
            //stのインスタンス取得
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
            //ロールバック処理
            OracleConnect.getInstance().rollback();
        }finally{
            //リソース解放
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
        return eb;
    }
    public List getAllUser(){
        ArrayList<EbUserBean> userdata=new ArrayList<>();
        String sql="select * from ebuser";
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }

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
    
                userdata.add(eb);
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
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return userdata;
    }
    public void updateUser(EbUserBean eu){
        String sql="update ebuser set name=?,pass=?,mail=?,sex=?,birth=? where id=?";
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }

            st=cn.prepareStatement(sql);

            st.setString(1,eu.getName());
            st.setString(2,eu.getPass());
            st.setString(3,eu.getMail());
            st.setInt(4,eu.getSex());
            st.setString(5,eu.getBirth());
            st.setString(6,eu.getId());
            // System.out.println("name="+eu.getName()+"\tpass="+eu.getPass()+"\t"+eu.getMail()+"\t"+eu.getId());

            st.executeUpdate();
        }catch(SQLException e){
            //ロールバック処理
            System.out.println("SQLException1");
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
    public void deleteUser(EbUserBean eu){
        String sql= "delete from ebuser where id=?";
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }

            st=cn.prepareStatement(sql);

            st.setString(1,eu.getId());

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
}