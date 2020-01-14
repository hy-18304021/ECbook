package dao;

import java.util.List;
import bean.EbCreditBean;

//ebcredit‚É‘Î‚·‚éSQL
public interface CreditDao{
   public void addCredit(EbCreditBean ec);
   public EbCreditBean getCredit(String key);
   public List getAllCredit();
   public void upDateCredit(EbCreditBean ec);
   public void deleteCredit(EbCreditBean ec);
}