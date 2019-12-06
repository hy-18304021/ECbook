package dao;

public class OraDaoFactory extends AbstractDaoFactory{
    public ProductDao getProductsDao(){
        return new OraProductsDao();
    }
}