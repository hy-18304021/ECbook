package dao;

public class OraDaoFactory extends AbstractDaoFactory{
    
    //OraUserDao�̃C���X�^���X��Ԃ�
    public UserDao getUserDao(){
        return new OraUserDao();
    }

    //OraCartDao�̃C���X�^���X��Ԃ�
    public CartDao getCartDao(){
        return new OraCartDao();
    }

    //OraBookDao�̃C���X�^���X��Ԃ�
    public BookDao getBookDao(){
        return new OraBookDao();
    }
}