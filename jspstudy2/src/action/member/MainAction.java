package action.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionForward;
import model.Member;
import model.MemberDao;

public class MainAction extends UserLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member=new MemberDao().selectOne(login);
		request.setAttribute("member", member);
		return new ActionForward();
	}


}
