package dao;

public class OraDaoFactory extends AbstractDaoFactory{
    
    //OraAddressDaoのインスタンスを返す
    public AddressDao getAddressDao(){
        return new OraAddressDao();
    }

    //OraArrivaDaoのインスタンスを返す
    public ArrivalDao getArrivalDao(){
        return new OraArrivalDao();
    }

    //OraBookDaoのインスタンスを返す
    public BookDao getBookDao(){
        return new OraBookDao();
    }

    //OraCartDaoのインスタンスを返す
    public CartDao getCartDao(){
        return new OraCartDao();
    }

    //OraCreditDaoのインスタンスを返す
    public CreditDao getCreditDao(){
        return new OraCreditDao();
    }

    //OraFavotiteDaoのインスタンスを返す
    public FavotiteDao getFavotiteDao(){
        return new OraFavotiteDao();
    }

    //OraGenreDaoのインスタンスを返す
    public GenreDao getGenreDao(){
        return new OraGenreDao();
    }

    //OraReviewDaoのインスタンスを返す
    public ReviewDao getReviewDao(){
        return new OraReviewDao();
    }

    //OraSales_RefDaoのインスタンスを返す
    public Sales_RefDao getSales_RefDao(){
        return new OraSales_RefDao();
    }

    //OraSalesDaoのインスタンスを返す
    public SalesDao getSalesDao(){
        return new OraSalesDao();
    }

    //OraUserDaoのインスタンスを返す
    public UserDao getUserDao(){
        return new OraUserDao();
    }
}