package dao;

import java.util.List;
import bean.EbUserBean;

//ebuser�ɑ΂���SQL
public interface UserDao{
   public int addUser(EbUserBean eu);
   public EbUserBean getUser(String key);
   public List getAllUser();
   public void updateUser(EbUserBean eu);
   public void deleteUser(EbUserBean eu);
}