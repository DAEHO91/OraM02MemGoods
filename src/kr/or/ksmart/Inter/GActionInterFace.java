package kr.or.ksmart.Inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.forward.GActionForward;

public interface GActionInterFace {
	//상품 인터페이스 추상메서드 선언
	public GActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
