package action.member;

import action.Action;
import action.ActionForward;
import model.MemberDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
  1. �Ķ���� ����.
  2. db���� email�� tel�� �̿��Ͽ� id���� ����
    id = MemberDao.idSearch(email,tel)
  3. id ���� ����
    opener�� id�� ���� ����. ���� ȭ�� �ݱ�
  4. id ���� ���� ���
    ������ �´� id�� ã�� �� �����ϴ�. �޼��� �����
    idForm.jsp�� ������ �̵�.
 */
public class IdAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        MemberDao dao = new MemberDao();
        String id = dao.idSearch(email,tel);
        if(id == null) {
            request.setAttribute("msg", "������ �´� id�� ã�� �� �����ϴ�.");
            request.setAttribute("url","idForm.me");
            return new ActionForward(false,"../alert.jsp");
        }
        request.setAttribute("id",id.substring(0,id.length()-2));
        return new ActionForward();
    }
}
