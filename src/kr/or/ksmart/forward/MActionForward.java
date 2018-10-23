package kr.or.ksmart.forward;

public class MActionForward {
	private boolean isRedirect=false;
	private String path=null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		System.out.println(isRedirect+"<--isRedirect setRedirect MActionForward.java");
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		System.out.println(path+"<--path setPath MActionForward.java");
		this.path = path;
	}
}
