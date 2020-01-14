package dao;

import java.util.List;
import bean.EbSales_RefBean;

//ebsales_ref‚É‘Î‚·‚éSQL
public interface Sales_RefDao{
   public void addSales_Ref(EbSales_RefBean esr);
   public EbSales_RefBean getSales_Ref(String key);
   public List getAllSales_Ref();
   public void upDateSales_Ref(EbSales_RefBean esr);
   public void deleteSales_Ref(EbSales_RefBean esr);
}