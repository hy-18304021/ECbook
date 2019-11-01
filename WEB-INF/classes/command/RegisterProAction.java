package command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LogonDataBean;
import bean.LogonDBBean;

public class RegisterProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//会員登録情報
		LogonDataBean member = new LogonDataBean();
		member.setId(request.getParameter("id"));
        member.setPass(request.getParameter("pass"));
        member.setName(request.getParameter("name"));
		member.setTel(request.getParameter("tel"));
		member.setBirth(request.getParameter("birth"));
		member.setSex(request.getParameter("sex"));
		member.setMail(request.getParameter("mail"));
        
		//会員登録処理
        LogonDBBean dbPro = LogonDBBean.getInstance();
        dbPro.insertMember(member);
		
		return "/member/registerPro.jsp";

		//会員登録処理ロジック
	}

}
