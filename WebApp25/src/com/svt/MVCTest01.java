/*============================================
	MVCTest01.java
	- Controller 역할을 수행할 서블릿 클래스
 ============================================*/

package com.svt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVCTest01 extends HttpServlet
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
	
	// 사용자 정의 메소드
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Get 방식이든 Post 방식이든
		// 어던 방식의 요청에도 모두 처리할 수 있는 사용자 정의 메소드
		
		// 서블릿 관련 코딩
		// 1 부터 100 까지의 수를 객체(컬렉션)에 저장하는 과정
		List<String> lists = new ArrayList<String>();
		for(int i = 1 ; i <= 100; i++) {
			lists.add(String.valueOf(i));
		}
		
		request.setAttribute("lists", lists);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/MVCTest01.jsp");
		dispatcher.forward(request, response);
	}
	
	
}






















