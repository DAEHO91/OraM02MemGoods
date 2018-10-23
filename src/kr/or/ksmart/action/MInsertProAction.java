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
		// 01 단계 : 화면에서 입력한 자료를 받아 콘솔창에 확인한다
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
		
		// 02 단계 : VO(DTO) Member 클래스 통해 생성된 객체내에 세팅
		Member m = new Member();
		m.setOra_id(ora_id);
		m.setOra_pw(ora_pw);
		m.setOra_level(ora_level);
		m.setOra_name(ora_name);
		m.setOra_email(ora_email);
		
		// 03 단계 : MDAO 클래스 통해 생성된 객체 내 입력처리 메서드 로출 후 리턴(리턴은 선택사항)
		Mdao insert_dao = new Mdao();
		insert_dao.mInsert(m);
		
		// 04 단계 : MActionForward 클래스 통해 생성된 객체 내에 redirect를 위한 경로 세팅
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath() + "/Mlist/m_list.ksmart");
		
		// 05 단계 : MActionForward 클래스 통해 생성된 객체 주소값 리턴
		
		return mf;
	}

}
