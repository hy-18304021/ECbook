package dao;

import java.util.List;
import bean.EbArrivalBean;

//ebarrival�ɑ΂���SQL
public interface ArrivalDao{
   public void addArrival(EbArrivalBean ea);
   public EbArrivalBean getArrival(String key);
   public List getAllArrival();
   public void upDateArrival(EbArrivalBean ea);
   public void deleteArrival(EbArrivalBean ea);
}