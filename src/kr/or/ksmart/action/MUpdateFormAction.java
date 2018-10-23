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
		System.out.println("05_03 execute ���� MUpdateFormAction.java");
		
		String sendid = request.getParameter("send_id");
		System.out.println(sendid+"05_03 execute ���� MUpdateFormAction.java");
		
		Mdao list_dao = new Mdao();
		Member m = list_dao.mUpdateSelect(sendid);
		System.out.println(m.getOra_name()+"<----name�� MUpdateFormAction.java");
		request.setAttribute("mUpdateForm", m);
		// mUpdateSelect�� ��ȸ�� Member�� ������ MemberŬ���� ��ü�� m���� �޾� ���ǿ� mUpdateForm�̶� �̸����� ����
		// m_update_form.jsp���� Member m = (Member)request.getAttribute("mUpdateForm"); ���� �޾� ȭ�鿡 ���
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/mupdate/m_update_form.jsp");

		return mf;
	}

}
