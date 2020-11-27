package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

@WebServlet(urlPatterns = {"*.me"},
initParams = {@WebInitParam(name="porperties",value="action.properties")})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,Action> commandMap= new HashMap<>();
    public ControllerServlet() {
        super();
    }
    //config: ("properties","action.properties")
    // 		@WebInitParam 객체가 전달됨.
    @Override //ControllerServlet 클래스의 객체 생성시 한번 호출
    public void init(ServletConfig config) throws ServletException{
    	//props: action.proteries
    	String props = config.getInitParameter("porperties");
    	//Properties: Hashtable의 하위 클래스임.
    	//				Map 객체.
    	//				<String,String> map객체.
    	Properties pr=new Properties();
    	FileInputStream f=null;
    	try {
    		//f: action.properties 파일을 읽기 위한 입력스트림
			f=new FileInputStream(config.getServletContext().getRealPath("/")+"WEB-INF/"+props);
			// /model2/hello.me=action.HelloAction
			// key: /model2/hello.me
			// value: action.HelloAction
			//("/model2/hello.me","action.HelloAction")
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e);
		}finally {
			try {
				if(f!=null)
					f.close();
			} catch (IOException e) {}
		}
    	for(Object k:pr.keySet()) {
    		String command=(String)k;// "/model2/hello.me"
    		//className : "action.HelloAcion"
    		String className=pr.getProperty(command);
    		try {
    			//commandClass: actionHelloAction 클래스 정보
				Class commandClass=Class.forName(className.trim());
				//newInstance(): 객체화. new action.HellAction()
				//commandObj :action.HellAction 객체 저장
				Object commandObj=commandClass.newInstance();
				commandMap.put(command, (Action)commandObj);
			} catch (Exception e) {
				throw new ServletException(e);
			}
    	}
    }//init메서드 끝
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:8090/jspstudy2/model2/hello.me
		request.setCharacterEncoding("UTF-8");
		Action action=null;
		ActionForward forward=null;
		String command= null;
		try {
			//request.getRequestURI(): /jspstudy2/model2/hello.me
			//request.getContextPath(): /jspstudy2
			//command: /model2/hello.me
			command=request.getRequestURI().substring(request.getContextPath().length());
			//action: action.HelloAction객체 리턴
			action=commandMap.get(command);
			//forward: new ActionForward(false, "hello.jsp");
			forward=action.execute(request, response);
			} catch (NullPointerException e) {
			forward=new ActionForward();
		}catch(Exception e) {
			throw new ServletException(e);
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getView());
			}else {
				if(forward.getView() == null) {
					forward.setView(command.replace(".me", ".jsp"));
				}
				//forward.getView(): hello.jsp
				RequestDispatcher disp=request.getRequestDispatcher(forward.getView());
				disp.forward(request, response); //forward
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
