package controller;
/*
 * form.do 라는 요청이 들어오면 모든 요청은 일단 DispatcherServlet으로 간다.
 * DispatcherServlet Wiring 되어진 빈 메타데이타 dispatcher-servlet.xml 
 * 파일을 통해 생성된 모든 빈들의 정보를 쥐고 있다.
 * ::
 * DispatcherServlet은 form.do라는 요청을 HandlerMapping에게 전달하고
 * HandlerMapping은 FormController를 생성
 * 이때 bean name="/form.do" class="controller.FormController"이거보고
 * 
 * 생성한 FormController는 다시 DispatcherServlet에게 리턴되고 
 * FormController의 handleRequest() 수행한 결과물인 ModelAndView를 리턴받는다.
 * 
 * 하지만 DispatcherServlet입자엥서는 ModelandView에 담겨진 실제적인View page의
 * 물리적인 저장위치를 알수가 없기 /때문에 다시ViewResolver에게 물어본다.
 * 이때 최종적인 View의 내용을 받을수 있다...
 * 
 * 그리고 View페이지는 다시 web Container로 돌아와서 수행되어 진다.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		
		
		//setViewName() + addObject() ==이걸 한꺼번에 생성자에 넣자.
		return new ModelAndView("ok", "info",name+" , "+addr) ;//map을넣어도되고 형으로바로넣어도된다.
													//setviewname , addObject
	}

}
