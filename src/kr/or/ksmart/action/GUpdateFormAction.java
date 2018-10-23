package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.GActionInterFace;
import kr.or.ksmart.dao.Gdao;
import kr.or.ksmart.dto.Goods;
import kr.or.ksmart.forward.GActionForward;

public class GUpdateFormAction implements GActionInterFace {

	@Override
	public GActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("execute 실행 GUpdateFormAction.java");
		
		String g_code = request.getParameter("send_code");
		Gdao update_list = new Gdao();
		Goods g = update_list.gUpdateSelect(g_code);
		System.out.println(g.getG_name() + "<<<<G_name execute 실행 GUpdateFormAction.java");
		request.setAttribute("gUpdateForm", g);
		
		GActionForward mf = new GActionForward();
		mf.setRedirect(false);
		mf.setPath("/gupdate/g_update_form.jsp");

		return mf;
	}

}
