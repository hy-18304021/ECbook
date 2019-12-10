package dao;

public class OraDaoFactory extends AbstractDaoFactory{
    
    //OraUserDaoのインスタンスを返す
    public UserDao getUserDao(){
        return new OraUserDao();
    }

    //OraCartDaoのインスタンスを返す
    public CartDao getCartDao(){
        return new OraCartDao();
    }

    //OraBookDaoのインスタンスを返す
    public BookDao getBookDao(){
        return new OraBookDao();
    }
}