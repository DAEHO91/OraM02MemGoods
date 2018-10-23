package kr.or.ksmart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.GActionInterFace;
import kr.or.ksmart.action.GInsertProAction;
import kr.or.ksmart.action.GListProAction;
import kr.or.ksmart.action.GUpdateFormAction;
import kr.or.ksmart.action.GUpdateProAction;
import kr.or.ksmart.forward.GActionForward;

@WebServlet("*.goods")
public class GController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GController() {
        super();
    }

	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("07_doPro���� GController.java");

		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI GController.java");
		System.out.println(contextPath + "<-- contextPath GController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() GController.java");
		System.out.println(command + "<-- command GController.java");
		System.out.println("----------GController.java----------------");
		System.out.println();	
		
		GActionForward forward = null;
		GActionInterFace action = null;
		
		//��ǰ �߰� ����Ʈ �̵�
		if(command.equals("/Gin/g_insert_form.goods")) {
			System.out.println("07_01 /Gin/g_insert_form.goods ���ǹ����� MController ----------");
			forward = new GActionForward();
			forward.setRedirect(false);		//false ���� ���ص� �ʱⰪ�� false��(������ ���)
			forward.setPath("/ginsert/g_insert_form.jsp");
		
		}else if(command.equals("/Gin/g_insert_pro.goods")) {
			System.out.println("07_02 /Gin/g_insert_pro.goods ���ǹ����� MController ----------");
			action = new GInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		//��ǰ ����Ʈ
		}else if(command.equals("/Gin/g_list.goods")) {
			System.out.println("07_03 /Glist/g_list.goods ���ǹ����� MController ----------");
			action = new GListProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		//��ǰ ���� ������ �̵�
		} else if(command.equals("/Gup/g_update_form.goods")) {
			System.out.println("07_04 /Gup/g_update_form.goods ���ǹ����� MController ----------");
			action = new GUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			// ��ǰ ���� ����
		} else if(command.equals("/Gup/g_update_pro.goods")) {
			System.out.println("07_05 /Gup/g_update_pro.goods ���ǹ����� MController ----------");
			action = new GUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	
			// ���� ȭ������ �̵�
		} else if(command.equals("/Gdel/g_delete_form.goods")) {
			System.out.println("07_06 /Gdel/g_delete_form.goods ���ǹ����� MController ----------");
			forward = new GActionForward();
			forward.setRedirect(false);
			forward.setPath("/gdelete/g_delete_pro.jsp");
		}
		
				
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
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPro(request, response);
	}

}
