package xiaoxi.configs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class LocateInputConfig {

	public LocateInputConfig() {
	}
	public static void write(String type,String expression) throws IOException{
		StringBuilder sb = new StringBuilder();
		sb.append(type).append('\n').append(expression);
		File file = ConfigFiles.getLocateInputFile();
		FileUtils.writeStringToFile(file, sb.toString());
	}
	
	public static String[] read() throws IOException{
		File file = ConfigFiles.getLocateInputFile();
		if(!file.exists()){
			return null;
		}
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		String[] ss = {lines.get(0),lines.get(1)};
		return ss;
	}
	public static void request(HttpServletRequest req) throws IOException{
		if(!"post".equalsIgnoreCase(req.getMethod())){
			return ;
		}
		String locateType = req.getParameter("locateType");
		String locateExpression = req.getParameter("locateExpression");
		write(locateType,locateExpression);
	}
}
