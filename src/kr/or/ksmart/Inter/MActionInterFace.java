package kr.or.ksmart.Inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.forward.MActionForward;


public interface MActionInterFace {
	// 추상 메서드 선언
	public MActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
