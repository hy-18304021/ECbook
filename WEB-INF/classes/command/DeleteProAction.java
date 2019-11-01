package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LogonDBBean;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pass  = request.getParameter("pass");
		
		//ID,PASSを削除して成功できたかを返す。
		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.deleteMember(id,pass);
		
		request.setAttribute("check", new Integer(check));  
		return "/member/deletePro.jsp";
	}
}