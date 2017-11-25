package gz.itcast.action;

import com.opensymphony.xwork2.Action;

public class BookAction implements Action {

	public String execute() throws Exception {
		System.out.println("BookAction.execute()");
		return "success";
	}

	
}
