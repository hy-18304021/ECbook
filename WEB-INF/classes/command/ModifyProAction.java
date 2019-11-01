package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LogonDataBean;
import bean.LogonDBBean;

public class ModifyProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//修正可能な会員情報
		LogonDataBean member = new LogonDataBean();
		member.setId(request.getParameter("id"));
        member.setPass(request.getParameter("pass"));
        member.setName(request.getParameter("name"));
		member.setTel(request.getParameter("tel"));
		member.setBirth(request.getParameter("birth"));
		member.setSex(request.getParameter("sex"));
		member.setMail(request.getParameter("mail"));
		
		//修正する会員情報を持って成功したかを判断
		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.updateMember(member);
		
		request.setAttribute("check", new Integer(check));
		return "/member/modifyPro.jsp";
	}
}