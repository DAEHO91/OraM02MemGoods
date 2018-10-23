package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MUpdateFormAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_03 execute 실행 MUpdateFormAction.java");
		
		String sendid = request.getParameter("send_id");
		System.out.println(sendid+"05_03 execute 실행 MUpdateFormAction.java");
		
		Mdao list_dao = new Mdao();
		Member m = list_dao.mUpdateSelect(sendid);
		System.out.println(m.getOra_name()+"<----name값 MUpdateFormAction.java");
		request.setAttribute("mUpdateForm", m);
		// mUpdateSelect로 조회한 Member의 정보를 Member클래스 객체의 m으로 받아 세션에 mUpdateForm이란 이름으로 세팅
		// m_update_form.jsp에서 Member m = (Member)request.getAttribute("mUpdateForm"); 으로 받아 화면에 출력
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/mupdate/m_update_form.jsp");

		return mf;
	}

}
