package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MLoginProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_07 execute ½ÇÇà MLoginProAction.java");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Mdao login_dao = new Mdao();
		Member m = login_dao.mLogin(id, pw);
		
		HttpSession session = request.getSession(true);

		session.setAttribute("S_ID", m.getOra_id());
		session.setAttribute("S_LEVEL", m.getOra_level());
		session.setAttribute("S_NAME", m.getOra_name());

		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/Mlist/m_list.ksmart");
		
		return mf;
	}

}
