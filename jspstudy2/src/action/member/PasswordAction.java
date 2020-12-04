package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionForward;
import model.Member;
import model.MemberDao;

public class PasswordAction extends UserLoginAction {

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean opener = true;
		boolean closer = true;
		String msg = null;
		String url = null;
		String pass = request.getParameter("pass");
		String chgpass = request.getParameter("chgpass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(login);
		if (pass.equals(mem.getPass())) {
			if (dao.updatePass(login, chgpass) > 0) {
				msg = "비밀번호가 변경되었습니다.";
				url = "info.me?id=" + login;
			}
		} else {
			opener = false;
			closer = false;
			msg = "비밀번호 오류입니다. 확인하세요.";
			url = "passwordForm.me";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("closer", closer);
		request.setAttribute("opener", opener);
		return new ActionForward();

	}
}
