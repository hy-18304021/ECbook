
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DBOracle.SelectOracle;
import bean.SelectOracleBean;
import func.*;

import java.util.List;
import java.util.ArrayList;

public class SelectCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<SelectOracleBean> plist=SelectOracle.getBookList("ebtest","ebpass");
		
		//�p�����[�^��JSP�ɓ]����������
		req.setAttribute("resindx",plist);
		
		resc.setTarget("");
        return resc;
		
	}
}
