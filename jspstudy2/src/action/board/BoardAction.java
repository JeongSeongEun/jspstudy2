package action.board;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import action.ActionForward;
import model.Board;
import model.BoardDao;

public class BoardAction {
	BoardDao dao = new BoardDao();

	public ActionForward hello(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("hello", "Hello World");
		return new ActionForward();
	}

	/*
	 * 1. 파라미터값을 model.Board객체 저장. MultipartRequest 객체 사용 2. 게시물 번호 num 현재등록된 num의
	 * 최대값을 조회. 최대값 +1 등록된 게시물의 번호. db에서 maxnum을 구해서 +1 값으로 num설정하기 3. board 내용을 db에
	 * 등록하기. 등록성공: list.do페이지 이동 등록실패: 메세지 출력. writeForm.do페이지 이동
	 */
	public ActionForward write(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/") + "model2/board/file/";
		File f = new File(path);
		if (!f.exists())
			f.mkdir();
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8");

			Board board = new Board();
			board.setName(multi.getParameter("name"));
			board.setPass(multi.getParameter("pass"));
			board.setSubject(multi.getParameter("subject"));
			board.setContent(multi.getParameter("content"));
			board.setFile1(multi.getFilesystemName("file1"));

			BoardDao dao = new BoardDao();
			// board table에서 num컬럼의 최대값 리턴. 최대값이 없는 경우 0으로 리턴

			int num = dao.maxnum();
			board.setNum(++num);
			board.setGrp(num);
			if (dao.insert(board)) {
				return new ActionForward(true, "list.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "게시물 등록 실패");
		request.setAttribute("url", "writeForm.do");
		return new ActionForward(false, "../alert.jsp");
	}

	/*
	 * 1. 한페이지당 10건의 게시물을 출력하기 pageNum파라미터 값을 저장 => 없는 경우는 1로 설정하기 2. 최근 등록된 게시물이 가장
	 * 위에 배치함 3. db에서 해당 페이지에 출력될 내용을 조회하여 화면에 출력 게시물을 출력부분 페이지 구분 출력부분 4.
	 */
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		int limit = 10;

		int boardcount = dao.boardCount();
		List<Board> list = dao.list(pageNum, limit);
		int maxpage = (int) ((double) boardcount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if (endpage > maxpage) {
			endpage = maxpage;
		}
		int boardnum = boardcount - (pageNum - 1) * limit;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sf.format(new Date());
		request.setAttribute("boardcount", boardcount);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("today", today);
		return new ActionForward();

	}

	public ActionForward info(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board b = dao.selectOne(num); // num에 해당하는 게시물 조회
		dao.readcntAdd(num); // 조회수 증가
		request.setAttribute("b", b);
		return new ActionForward();
	}

	public ActionForward replyForm(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board b = dao.selectOne(num); // num에 해당하는 게시물 조회
		request.setAttribute("b", b);
		return new ActionForward();
	}

	public ActionForward reply(HttpServletRequest request, HttpServletResponse response) {
		Board b = new Board();
		b.setNum(Integer.parseInt(request.getParameter("num")));
		b.setName(request.getParameter("name"));
		b.setPass(request.getParameter("pass"));
		b.setSubject(request.getParameter("subject"));
		b.setContent(request.getParameter("content"));
		b.setGrp(Integer.parseInt(request.getParameter("grp")));
		b.setGrplevel(Integer.parseInt(request.getParameter("grplevel")));
		b.setGrpstep(Integer.parseInt(request.getParameter("grpstep")));
		dao.grpStepAdd(b.getGrp(), b.getGrpstep());
		int grplevel = b.getGrplevel();
		int grpstep = b.getGrpstep();
		int num = dao.maxnum();
		String msg = "답변등록시 오류 발생";
		String url = "replyForm.do?num=" + b.getNum();
		b.setNum(++num);
		b.setGrplevel(grplevel + 1);
		b.setGrpstep(grpstep + 1);
		if (dao.insert(b)) {
			msg = "답변등록 완료";
			url = "list.do";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		Board board = new Board();
		String path = request.getServletContext().getRealPath("/") + "model2/board/file/";
		String msg = null;
		String url = null;
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8");
			board.setNum(Integer.parseInt(multi.getParameter("num")));
			board.setName(multi.getParameter("name"));
			board.setPass(multi.getParameter("pass"));
			board.setSubject(multi.getParameter("subject"));
			board.setContent(multi.getParameter("content"));
			board.setFile1(multi.getFilesystemName("file1"));
			// 파일부분의 수정이 없는경우 => 기존파일정보 유지.
			if (board.getFile1() == null || board.getFile1().equals("")) {
				board.setFile1(multi.getParameter("file2"));
			}
			// 2. 비밀번호 검증.
			BoardDao dao = new BoardDao();
			Board dbBoard = dao.selectOne(board.getNum());
			msg = "비밀번호가 틀렸습니다.";
			url = "updateForm.do?num=" + board.getNum();
			// board.getPass(): 입력된 비밀번호
			// dbBoard.getPass(): DB에 저장된 비밀번호
			if (board.getPass().equals(dbBoard.getPass())) {
				if (dao.update(board)) { // db의 게시물 수정
					msg = "게시글 수정 완료";
					url = "info.do?num=" + board.getNum();
				} else {
					msg = "게시물 수정 실패";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		String pass= request.getParameter("pass");

		String msg="게시글의 비밀번호가 틀렸습니다";
		String url="deleteForm.do?num="+num;
		BoardDao dao=new BoardDao();
		Board board=dao.selectOne(num);
		if(board==null){
			msg="없는 게시글 입니다.";
			url="list.do";
		}else{
			//pass: 입력된 비밀번호
			//board.getPass(): db에 등록된 비밀번호
			if(pass.equals(board.getPass())){
				if(dao.delete(num)){
					msg="게시글 삭제성공";
					url="list.do";
				}else{
					msg="게시글 삭제 실패";
					url="info.do?num="+num;
				}
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}
}
