package dao;

public class OraDaoFactory extends AbstractDaoFactory{
    
    //OraAddressDao�̃C���X�^���X��Ԃ�
    public AddressDao getAddressDao(){
        return new OraAddressDao();
    }

    //OraArrivaDao�̃C���X�^���X��Ԃ�
    public ArrivalDao getArrivalDao(){
        return new OraArrivalDao();
    }

    //OraBookDao�̃C���X�^���X��Ԃ�
    public BookDao getBookDao(){
        return new OraBookDao();
    }

    //OraCartDao�̃C���X�^���X��Ԃ�
    public CartDao getCartDao(){
        return new OraCartDao();
    }

    //OraCreditDao�̃C���X�^���X��Ԃ�
    public CreditDao getCreditDao(){
        return new OraCreditDao();
    }

    //OraFavotiteDao�̃C���X�^���X��Ԃ�
    public FavotiteDao getFavotiteDao(){
        return new OraFavotiteDao();
    }

    //OraGenreDao�̃C���X�^���X��Ԃ�
    public GenreDao getGenreDao(){
        return new OraGenreDao();
    }

    //OraReviewDao�̃C���X�^���X��Ԃ�
    public ReviewDao getReviewDao(){
        return new OraReviewDao();
    }

    //OraSales_RefDao�̃C���X�^���X��Ԃ�
    public Sales_RefDao getSales_RefDao(){
        return new OraSales_RefDao();
    }

    //OraSalesDao�̃C���X�^���X��Ԃ�
    public SalesDao getSalesDao(){
        return new OraSalesDao();
    }

    //OraUserDao�̃C���X�^���X��Ԃ�
    public UserDao getUserDao(){
        return new OraUserDao();
    }
}