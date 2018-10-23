package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.GActionInterFace;
import kr.or.ksmart.dao.Gdao;
import kr.or.ksmart.dto.Goods;
import kr.or.ksmart.forward.GActionForward;

public class GInsertProAction implements GActionInterFace {

	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GInsertProAction.java!!");
		
		Goods g = new Goods();
		g.setG_name(request.getParameter("g_name"));
		g.setG_cate(request.getParameter("g_cate"));
		g.setG_sangse(request.getParameter("g_sangse"));
		g.setG_price(Integer.parseInt(request.getParameter("g_price")));
		g.setG_id(request.getParameter("g_id"));
		
		Gdao insert_goods = new Gdao();
		insert_goods.gInsert(g);
		
		GActionForward mf = new GActionForward();
		mf.setRedirect(false);
		mf.setPath("/Gin/g_list.goods");
		
		return mf;
	}

}
