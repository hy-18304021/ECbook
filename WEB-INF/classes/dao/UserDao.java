package dao;

import java.util.List;
import bean.EbUserBean;

//ebuser‚É‘Î‚·‚éSQL
public interface UserDao{
   public int addUser(EbUserBean eu);
   public EbUserBean getUser(String key);
   public List getAllUser();
   public void updateUser(EbUserBean eu);
   public void deleteUser(EbUserBean eu);
}