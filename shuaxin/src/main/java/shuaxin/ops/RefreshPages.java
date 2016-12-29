package shuaxin.ops;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshPages {
private static Vector<String> handlerList = new Vector();
	public RefreshPages() {
	}
public static List<String> getRefreshHandlers(){
	return new ArrayList<String>(handlerList);
}
	
	
	public static void changeHandlers(HttpServletRequest req){
		if(!"post".equalsIgnoreCase(req.getMethod())){
			return;
		}
		handlerList.clear();
		String[] handles = req.getParameterValues("handles");
		if(handles == null || handles.length == 0){
			return;
		}
		for(String handle : handles){
			handlerList.add(handle);
		}
	}

}
