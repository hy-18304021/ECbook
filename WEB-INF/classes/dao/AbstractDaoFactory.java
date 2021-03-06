package dao;
import bean.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import froc.RequestContext;

public abstract class AbstractDaoFactory{
    public static AbstractDaoFactory getFactory(RequestContext path){
        AbstractDaoFactory factory=null;
        Properties pro=new Properties();
        String daolPath=path.getRealPath("/WEB-INF/classes/property/dao.properties");

        try{
            pro.load(new FileInputStream(daolPath));

            String className=pro.getProperty("dao");

            Class c=Class.forName(className);

            factory=(AbstractDaoFactory)c.newInstance();
        }catch(FileNotFoundException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(IOException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(InstantiationException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(IllegalAccessException e){
            throw new RuntimeException(e.getMessage(),e);
        }

        return factory;
    }
    public abstract AddressDao getAddressDao();
    public abstract ArrivalDao getArrivalDao();
    public abstract BookDao getBookDao();
    public abstract CartDao getCartDao();
    public abstract CreditDao getCreditDao();
    public abstract FavoriteDao getFavoriteDao();
    public abstract GenreDao getGenreDao();
    public abstract ReviewDao getReviewDao();
    public abstract Sales_RefDao getSales_RefDao();
    public abstract SalesDao getSalesDao();
    public abstract UserDao getUserDao();
}