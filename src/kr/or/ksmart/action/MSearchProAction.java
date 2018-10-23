package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MSearchProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_06 execute ���� MSearchProAction.java");
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		System.out.println(key+"<-----key MSearchProAction.java");
		System.out.println(word+"<-----word MSearchProAction.java");
		
		Mdao search_dao = new Mdao();
		ArrayList<Member> alm = search_dao.mSearch(key, word);
		
		System.out.println(alm+"<---��ȸ�� alm�� MSarchProAction.java");
		request.setAttribute("mSearchList", alm);
		//request ������ mSearchList�� �̸����� alm Arraylist���� ����
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/Msearch/m_search_list.ksmart");
		System.out.println("<--MSarchProAction.java-->");
		return mf;
	}

}
