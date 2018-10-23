package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.GActionInterFace;
import kr.or.ksmart.dao.Gdao;
import kr.or.ksmart.dto.Goods;
import kr.or.ksmart.forward.GActionForward;

public class GUpdateProAction implements GActionInterFace {

	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("excute GUpdateProAction.java");
		
		request.setCharacterEncoding("UTF-8");
		
		Goods g = new Goods();
		
		g.setG_code(request.getParameter("g_code"));
		g.setG_name(request.getParameter("g_name"));
		g.setG_cate(request.getParameter("g_cate"));
		g.setG_sangse(request.getParameter("g_sangse"));
		g.setG_price(Integer.parseInt(request.getParameter("g_price")));
		
		Gdao update_dao = new Gdao();
		update_dao.gUpdatePro(g);
		
		
		System.out.println("리다이렉트 시작 GUpdateProAction.java");
		GActionForward mf = new GActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath()+"/Gin/g_list.goods");
		System.out.println(mf.getPath()+"<< 리다이렉트 패스 GUpdateProAction.java");
		
		return mf;
	}

}
