package dao;

import java.util.List;
import bean.EbAddressBean;

//ebaddress�ɑ΂���SQL
public interface AddressDao{
   public void addAddress(EbAddressBean ea);
   public EbAddressBean getAddress(String key);
   public List getAllAddress();
   public void upDateAddress(EbAddressBean ea);
   public void deleteAddress(EbAddressBean ea);
}