package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.forward.MActionForward;

public class MLogoutProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_08 execute ½ÇÇà MLogoutProAction.java");

		HttpSession session = request.getSession();
		session.invalidate();

		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/Mlist/m_list.ksmart");
		
		return mf;
	}

}
