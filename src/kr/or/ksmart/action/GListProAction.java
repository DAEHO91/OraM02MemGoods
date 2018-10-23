package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.GActionInterFace;
import kr.or.ksmart.dao.Gdao;
import kr.or.ksmart.dto.Goods;
import kr.or.ksmart.forward.GActionForward;


public class GListProAction implements GActionInterFace {

	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("execute ½ÇÇà GListProAction.java");
		
		Gdao list_dao = new Gdao();
		ArrayList<Goods> alm = list_dao.gAllSelect();
		
		request.setAttribute("glist", alm);
		
		GActionForward mf = new GActionForward();
		mf.setRedirect(false);
		mf.setPath("/glist/g_list.jsp");
		
		return mf;
	}

}
