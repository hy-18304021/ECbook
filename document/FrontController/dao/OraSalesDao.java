package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbSalesBean;

//ebsales�ɑ΂���SQL
public class OraSalesDao implements SalesDao{
    public void addSales(EbSalesBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "insert into ebsales values(?,?,?,?,?)";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            //�o�C���h�ϐ��̐ݒ�
            st.setInt(1,ec.getSales_id());
            st.setString(2,ec.getUser_id());
            st.setInt(3,ec.getSales_date());
            st.setInt(4,ec.getAddress_id());
            st.setString(5,ec.getPay_method());

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
    public EbSalesBean getSales(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbSalesBean eb=new EbSalesBean();

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "select * from ebsales where address_id = ?";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);
            
            st.setString(1,key);

            rs=st.executeQuery();
            while(rs.next()){
                eb.setSales_id(rs.getInt("sales_id"));
                eb.setUser_id(rs.getString("user_id"));
                eb.setSales_date(rs.getInt("sales_date"));
                eb.setAddress_id(rs.getInt("address_id"));
                eb.setPay_method(rs.getString("pay_method"));
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
    public List getAllSales(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbSalesBean> salesdates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebsales";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbSalesBean eb=new EbSalesBean();

                eb.setSales_id(rs.getInt("sales_id"));
                eb.setUser_id(rs.getString("user_id"));
                eb.setSales_date(rs.getInt("sales_date"));
                eb.setAddress_id(rs.getInt("address_id"));
                eb.setPay_method(rs.getString("pay_method"));

                salesdates.add(eb);
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
        return salesdates;
    }
    public void upDateSales(EbSalesBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql="update ebsales set sales_id=?,user_id=?,sales_date=?,pay_methot=?,card_expiration=? where sales_id=?";

            st.setInt(1,ec.getSales_id());
            st.setString(2,ec.getUser_id());
            st.setInt(3,ec.getSales_date());
            st.setInt(4,ec.getAddress_id());
            st.setString(5,ec.getPay_method());
            st.setInt(6,ec.getSales_id());

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
    public void deleteSales(EbSalesBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "delete from ebsales where sales_id=? ";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            st.setInt(1,ec.getSales_id());

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