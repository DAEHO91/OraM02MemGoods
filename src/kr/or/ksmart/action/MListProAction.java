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
		System.out.println("05_02 execute 실행 MListProAction.java");
		// 01 단계 : 검색의 경우는 검색 조건 입력자료 확인 필요 (리스트는 01과정 불필요)
		// 02 단계 : VO(DTO) Member클래스 통해 생성된 객체 내에 세팅 (리스트는 02과정 불필요)
		// 03 단계 : Mdao 클래스 통해 생성된 객체 내 전체회원조회 메서드 호출 후 리턴
		Mdao list_dao = new Mdao();
		ArrayList<Member> alm = list_dao.mAllSelect();
		// 04 단계 : request 영역에 세팅
		request.setAttribute("mlist", alm);
		// 05 단계 : MActionForward 클래스 통해 생성된 객체 내에
		// forward를 위한 경로 세팅
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/mlist/m_list.jsp");
		// 06 단계 : MActionForward 클래스 통해 생성된 객체 주소값 리턴
		return mf;
	}

}
