package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;//mvc

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result");
		//반드시 webINF밑에 있다고 할수 없다 ...이름만담고 ViewResolver가 실제적인 물리적 저장 장소를 담고있다.
		mv.addObject("message", "Hello First SpringMVC!!"); //바인딩..
		
		return mv;
	}
	
}
/*
	Spring lib의 ModelAndView::
	1)View page에 대한 이름과
	2)Model에 대한 정보를 담는 라이브러리 객체이다.
	::
	View page의 물리적인 저장소에 대한 위치는 담고있지 않다.
	---->ViewResorver::저장소

*/