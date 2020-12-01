package action.member;

import action.Action;
import action.ActionForward;
import model.MemberDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PwAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        MemberDao dao = new MemberDao();
        String pass = dao.pwSearch(id,email, tel);
        if(pass == null) {
            request.setAttribute("msg","정보를 잘못 입력했습니다.");
            request.setAttribute("url","pwForm.me");
            return new ActionForward(false,"../alert.jsp");
        }
        request.setAttribute("pass",pass.substring(2));
        return new ActionForward();
    }
}
