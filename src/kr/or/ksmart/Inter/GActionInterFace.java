package kr.or.ksmart.Inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.forward.GActionForward;

public interface GActionInterFace {
	//��ǰ �������̽� �߻�޼��� ����
	public GActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
