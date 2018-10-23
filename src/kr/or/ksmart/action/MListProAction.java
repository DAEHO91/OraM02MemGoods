package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MListProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_02 execute ���� MListProAction.java");
		// 01 �ܰ� : �˻��� ���� �˻� ���� �Է��ڷ� Ȯ�� �ʿ� (����Ʈ�� 01���� ���ʿ�)
		// 02 �ܰ� : VO(DTO) MemberŬ���� ���� ������ ��ü ���� ���� (����Ʈ�� 02���� ���ʿ�)
		// 03 �ܰ� : Mdao Ŭ���� ���� ������ ��ü �� ��üȸ����ȸ �޼��� ȣ�� �� ����
		Mdao list_dao = new Mdao();
		ArrayList<Member> alm = list_dao.mAllSelect();
		// 04 �ܰ� : request ������ ����
		request.setAttribute("mlist", alm);
		// 05 �ܰ� : MActionForward Ŭ���� ���� ������ ��ü ����
		// forward�� ���� ��� ����
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/mlist/m_list.jsp");
		// 06 �ܰ� : MActionForward Ŭ���� ���� ������ ��ü �ּҰ� ����
		return mf;
	}

}
