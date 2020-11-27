package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionForward;
import model.Member;
import model.MemberDao;
/*
1. 모든 파라미터 정보를 Member객체에 저장
2. 입력된 비밀번호와, db에 저장된 비밀번호 비교
	관리자인 경우 관리자 비밀번호로 비교하기.
	-같지않은경우: "비밀번호 오류" 메세지 출력 updateForm.me 페이지 이동
3. 파라미터를 저장하고있는 Member 객체를 이용하여 db정보 수정.
	int MemberDao.update(Member)
	결과가 0이하면 수정실패 메세지 출력후, updateForm.me페이지 이동. 1이상이면 수정 성공 info.me페이지 이동
*/
public class UpdateAction extends UserLoginAction{
	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem=new Member();
		mem.setId(request.getParameter("id"));
		mem.setPass(request.getParameter("pass"));
		mem.setName(request.getParameter("name"));
		mem.setGender(Integer.parseInt(request.getParameter("gender")));
		mem.setTel(request.getParameter("tel"));
		mem.setEmail(request.getParameter("email"));
		mem.setPicture(request.getParameter("picture"));
		
		String msg="비밀번호가 틀렸습니다.";
		String url="updateForm.me?id="+mem.getId();
		MemberDao dao=new MemberDao();
		Member dbmem=dao.selectOne(login);
		if(mem.getPass().equals(dbmem.getPass())) {
			int result=dao.update(mem);
			if(result>0) {
				return new ActionForward(true, "info.me?id="+mem.getId());
			}else {
				msg="수정실패";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}

}
