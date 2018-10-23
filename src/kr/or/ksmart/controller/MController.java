package kr.or.ksmart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.action.*;
import kr.or.ksmart.forward.MActionForward;

@WebServlet("/MController")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MController() {
        super();
    }
    protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("03_doPro실행 MController.java");

		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI MController.java");
		System.out.println(contextPath + "<-- contextPath MController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() MController.java");
		System.out.println(command + "<-- command MController.java");
		System.out.println("----------MController.java----------------");
		System.out.println();	
		
		MActionForward forward = null;
		MActionInterFace action = null;
		
		
		if(command.equals("/Min/m_insert_form.ksmart")) {
			System.out.println("04_01 /Min/m_insert_form.ksmart 조건문실행 MController ----------");
			forward = new MActionForward();
			forward.setRedirect(false);		//false 셋팅 안해도 초기값이 false다(포워드 경우)
			forward.setPath("/minsert/m_insert_form.jsp");
			
			
		}else if(command.equals("/Min/m_insert_pro.ksmart")) {
			System.out.println("04_02 /Min/m_insert_pro.ksmart 조건문실행 MController ----------");
			action = new MInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//리스트 조회
		}else if(command.equals("/Mlist/m_list.ksmart")) {
			System.out.println("/Mlist/M_list.ksmart 조건문실행 MController ----------");
			action = new MListProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//업데이트할 MEMBER 정보 조회
		}else if(command.equals("/Mup/m_update_form.ksmart")) {
			System.out.println("/Mup/m_update_form.ksmart 조건문실행 MController ----------");
			action = new MUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		//입력받은 업데이트 정보를 적용
		}else if(command.equals("/Mup/m_update_pro.ksmart")) {
			System.out.println("/Mup/m_update_pro.ksmart 조건문실행 MController ----------");
			action = new MUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//Member 삭제
		}else if(command.equals("/Mdel/m_delete_pro.ksmart")) {
			System.out.println("/Mdel/m_delete_pro.ksmart 조건문실행 MController ----------");
			action = new MDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			//검색
		}else if(command.equals("/Msearch/m_search_pro.ksmart")) {
			System.out.println("/Msearch/m_search_pro.ksmart 조건문실행 MController ----------");
			action = new MSearchProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			//검색결과출력
		}else if(command.equals("/Msearch/m_search_list.ksmart")) {
			System.out.println("/Msearch/m_search_list.ksmart 조건문실행 MController ----------");
			
			forward = new MActionForward();
			forward.setRedirect(false);	
			forward.setPath("/msearch/m_search_list.jsp");
		
		
			//로그인처리
		}else if(command.equals("/Mlogin/m_login_pro.ksmart")) {
			System.out.println("/Mlogin/m_login_pro.ksmart 조건문실행 MController ----------");
			action = new MLoginProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			//로그아웃처리
		}else if(command.equals("/MLogin/m_logout_pro.ksmart")) {
			System.out.println("/MLogin/m_logout_pro.ksmart 조건문실행 MController ----------");
			action = new MLogoutProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		
		
				
// forward or redirect 결정		
		if(forward != null){
			if(forward.isRedirect()){
				System.out.println(forward.getPath() + "<--- forward.getPath()[REDIRECT]  MController.java");
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[FORWARD]  MController.java");
				dispatcher.forward(request, response);
			}
		}
		
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("01_doGet실행 MController.java");
		doPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("02_doPost실행 MController.java");
		doPro(request,response);
	}

}
