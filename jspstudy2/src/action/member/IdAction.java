package action.member;

import action.Action;
import action.ActionForward;
import model.MemberDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
  1. 파라미터 저장.
  2. db에서 email과 tel을 이용하여 id값을 리턴
    id = MemberDao.idSearch(email,tel)
  3. id 값이 존재
    opener의 id에 값을 저장. 현재 화면 닫기
  4. id 값이 없는 경우
    정보에 맞는 id를 찾을 수 없습니다. 메세지 출력후
    idForm.jsp로 페이지 이동.
 */
public class IdAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        MemberDao dao = new MemberDao();
        String id = dao.idSearch(email,tel);
        if(id == null) {
            request.setAttribute("msg", "정보에 맞는 id를 찾을 수 없습니다.");
            request.setAttribute("url","idForm.me");
            return new ActionForward(false,"../alert.jsp");
        }
        request.setAttribute("id",id.substring(0,id.length()-2));
        return new ActionForward();
    }
}
