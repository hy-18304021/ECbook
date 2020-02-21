package dao;

import java.util.List;
import bean.EbAddressBean;

//ebaddress‚É‘Î‚·‚éSQL
public interface AddressDao{
   public void addAddress(EbAddressBean ea);
   public EbAddressBean getAddress(String key);
   public List getAllAddress();
   public List getUserAddress(String user);
   public void upDateAddress(EbAddressBean ea);
   public void deleteAddress(EbAddressBean ea);
   public EbAddressBean getLastAddress_id();
}