package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MUpdateProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("05_04 execute ½ÇÇà MUpdateProAction.java");
		request.setCharacterEncoding("UTF-8");
		Member m = new Member();
		m.setOra_id(request.getParameter("ora_id"));
		m.setOra_pw(request.getParameter("ora_pw"));
		m.setOra_level(request.getParameter("ora_level"));
		m.setOra_name(request.getParameter("ora_name"));
		m.setOra_email(request.getParameter("ora_email"));
		
		Mdao update_dao = new Mdao();
		update_dao.mUpdate(m);
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath()+"/Mlist/m_list.ksmart");
		
		return mf;
	}

}
