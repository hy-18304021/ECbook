import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import func.*;

public class LogoutCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

        HttpSession session=(HttpSession)reqc.getSession();
        session.removeAttribute("flag");

        //ÉzÅ[ÉÄÇ÷
		resc.setTarget("index");
        return resc;
	}
}