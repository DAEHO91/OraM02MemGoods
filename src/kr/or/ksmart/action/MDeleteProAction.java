package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.forward.MActionForward;

public class MDeleteProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_05 execute MDeleteProAction.java");
		
		// 01 단계 : 화면에서 입력한 자료를 받아 콘솔창에 확인한다
		request.setCharacterEncoding("UTF-8");
		String ora_id = request.getParameter("send_id");
		System.out.println(ora_id+"<--ora_id");
		
		Mdao delete_dao = new Mdao();
		delete_dao.mDelete(ora_id);
		
		MActionForward forward = new MActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/Mlist/m_list.ksmart");

		return forward;
	}

}
