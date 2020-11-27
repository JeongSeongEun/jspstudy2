package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import model.Member;
import model.MemberDao;
/*
1. 파라미터 정보를 Member 객체에 저장
	model.Member
2. Member 객체정보를 db에 추가. member테이블 데이터 저장
3.  가입성공: loginForm.jsp페이지 이동
	가입실패: joinForm.jsp페이지 이동
*/
public class JoinAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem=new Member();
		mem.setId(request.getParameter("id"));
		mem.setPass(request.getParameter("pass"));
		mem.setName(request.getParameter("name"));
		mem.setGender(Integer.parseInt(request.getParameter("gender")));
		mem.setTel(request.getParameter("tel"));
		mem.setEmail(request.getParameter("email"));
		mem.setPicture(request.getParameter("picture"));
		String msg="회원가입 실패";
		String url="JoinForm.me";
		if(new MemberDao().insert(mem)>0) {
			msg=mem.getName()+"님 회원가입 완료";
			url="loginForm.me";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}

}
