package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionForward;
import model.Member;
import model.MemberDao;

/*

*/
public class DeleteAction extends UserLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(id.equals("admin")) {
			request.setAttribute("msg", "관리자는 탈퇴할 수 없습니다.");
			request.setAttribute("url", "main.me");
			return new ActionForward(false, "../alert.jsp");
		}
		String pass = request.getParameter("pass");
		String msg=null;
		String url=null;
		if(login.equals("admin")) {
			url="list.me";
		}else {
			url="loginForm.me";
		}
		Member dbmem=null;
		MemberDao dao=new MemberDao();
		dbmem=dao.selectOne(login);
		if(pass.equals(dbmem.getPass())) {
			if(dao.delete(id)>0) {
				if(login.equals("admin")) {
					msg=id+"사용자를 강제탈퇴 성공";
				}else {
					msg=id+"님의 회원탈퇴가 완료되었습니다.";
					request.getSession().invalidate();
				}
			}else {
				msg=id+"님의 탈퇴시 오류 발생.";
				if(!login.equals("admin")) {
					url="info.me?id="+id;
				}
			}
		}else {
			msg=login+"님의 비밀번호가 틀립니다.";
			url="deleteForm.me?id="+id;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}

}
