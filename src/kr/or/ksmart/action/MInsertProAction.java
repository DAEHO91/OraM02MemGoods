package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.forward.MActionForward;
import kr.or.ksmart.dto.Member;

public class MInsertProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_01 execute MInsertProAction.java");
		// 01 �ܰ� : ȭ�鿡�� �Է��� �ڷḦ �޾� �ܼ�â�� Ȯ���Ѵ�
		request.setCharacterEncoding("UTF-8");
		String ora_id = request.getParameter("ora_id");
		String ora_pw = request.getParameter("ora_pw");
		String ora_level = request.getParameter("ora_level");
		String ora_name = request.getParameter("ora_name");
		String ora_email = request.getParameter("ora_email");
		
		System.out.println(ora_id+"<--ora_id");
		System.out.println(ora_pw+"<--ora_pw");
		System.out.println(ora_level+"<--ora_level");
		System.out.println(ora_name+"<--ora_name");
		System.out.println(ora_email+"<--ora_email");
		
		// 02 �ܰ� : VO(DTO) Member Ŭ���� ���� ������ ��ü���� ����
		Member m = new Member();
		m.setOra_id(ora_id);
		m.setOra_pw(ora_pw);
		m.setOra_level(ora_level);
		m.setOra_name(ora_name);
		m.setOra_email(ora_email);
		
		// 03 �ܰ� : MDAO Ŭ���� ���� ������ ��ü �� �Է�ó�� �޼��� ���� �� ����(������ ���û���)
		Mdao insert_dao = new Mdao();
		insert_dao.mInsert(m);
		
		// 04 �ܰ� : MActionForward Ŭ���� ���� ������ ��ü ���� redirect�� ���� ��� ����
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath() + "/Mlist/m_list.ksmart");
		
		// 05 �ܰ� : MActionForward Ŭ���� ���� ������ ��ü �ּҰ� ����
		
		return mf;
	}

}
