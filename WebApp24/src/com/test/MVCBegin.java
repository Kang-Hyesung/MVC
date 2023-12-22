/*=========================
 	ServletSample.java
 	- Servlet 관련 실습
 ========================*/

// HttpServlet 을 상속받는 클래스로 설계 -> Servlet

package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HttpServlet 은 추상클래스이지만 추상메소드가 없다
public class MVCBegin extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	// 서블릿 컨테이너가 이 메소드들을 호출해서 사용하는데 
	// get 과 post 두 방식 중에서 get 방식이라고 하면 서블릿 컨테이너는 doGet 메소드를 호출한다.
	// post 방식이라고 지정하면 doPost 메소드를 호출한다.
	// 하지만 실제 이 방식으로 코딩을 하게 되면 개발자의 입장에서 코딩을 이중으로 해야 하는 문제가 생긴다
	// 그 때문에 사용자 정의 메소드를 만들어 어떤 방식이든 사용자 정의 메소드가 호출되도록 하면 편리하다
	
	// 우리가 보이지 않는 영역에서 클라이언트와 서버는 뭔가를 주고 받는다.
	
	// 사용자의 http 프로토콜 요청이 Get 방식일 경우 호출되는 메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}
	
	// 사용자의 http 프로토콜 요청이 Post 방식일 경우 호출되는 메소드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Get 방식이든 Post 방식이든
		// 어던 방식의 요청에도 모두 처리할 수 있는 사용자 정의 메소드
		
		// 서블릿 관련 코딩
		
		// 데이터 구성(-> 업무 처리)
		String message = "안녕하세요, MVC 패턴입니다";
		
		// View 역할을 수행하는 JSP 페이지에 데이터를 전달해야 한다.
		request.setAttribute("message", message);
		
		// check
		// 제어권(제어 흐름)도 JSP 페이지(View)에 전달해야 한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/MVCBegin.jsp");
		dispatcher.forward(request, response);
		// javax.servlet.RequestDispatcher 클래스는
		// 현재 클라이언트의 요청을 다른 서블릿/JSP 페이지로 전달하거나
		// 다른 서블릿/JSP 페이지의 결과를 현재 위치에 포함시키고자 할 때 사용된다.
		
		// ※ RequestDispatcher 객체는
		//    이러한 기능을 제공하기 위해
		//    forward() 메소드와 include() 메소드를 제공하고 있으며
		//    이 두 메소드는 JSP 의 <jsp:forward> 액션 태그,
		//    <jsp:include> 액션 태그와 동일한 기능을 제공한다.
		//    위의 경우는 현재 요청을 MVCBegin.jsp 페이지로
		//    보내고자 하는 경우이다.
		
		// ==> 웹 기반 모델2(MVC) 구조는
		//     바로 이 RequestDispatcher 의 forward()
		//	   메소드를 통해 구현된다.
		
		
	}
	
}






































