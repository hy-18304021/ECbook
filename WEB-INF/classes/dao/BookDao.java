package dao;

import java.util.List;
import bean.EbBookBean;

//ebbook�ɑ΂���SQL
public interface BookDao{
    public void addBook(EbBookBean eb);
    public EbBookBean getBook(String key);
    public List getAllBook();
    public void upDateBook(EbBookBean eb);
    public void deleteBook(EbBookBean eb);
    public List getRecommendedBooks();
    public List searchBook(EbBookBean eb);
}