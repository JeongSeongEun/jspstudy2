package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import model.Member;
import model.MemberDao;
/*
1. id파라미터 값을 조회
2. login상태 검증
	로그인상태:'로그인 하세요' 메세지 출력후 loginForm.me
3. login 상태 검증 2
	id 파라미터값과 login id가 다른경우: 내 정보 조회만 가능합니다. 메세지 출력. main.me 펭지 이동
	
	InfoAction
	4.db에서 id값으로 데이터 조회.: selectOne(id)
	5. 조회된 내용을 화면 출력하기

*/
public class InfoAction extends UserLoginAction{
	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem=new MemberDao().selectOne(id);
		request.setAttribute("mem", mem);
		return new ActionForward();
	}

}
