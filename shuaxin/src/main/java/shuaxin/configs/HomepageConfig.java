package shuaxin.configs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class HomepageConfig {

private static File file = new File("shuaxinHome.txt");;	
	public HomepageConfig() {
	}
	public static void write(String homepage) throws IOException{
		StringBuilder sb = new StringBuilder();
		sb.append(homepage);
		String content = sb.toString();
		
		FileUtils.writeStringToFile(file, content, "UTF-8");
	}
	
	public static String read() throws IOException{
		if(!file.exists()){
			return null;
		}
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		String homepage = lines.get(0);
		
		return homepage;
	}
	public static void request(HttpServletRequest req) throws IOException{
		if(!"post".equalsIgnoreCase(req.getMethod())){
			return ;
		}
		String homepageStr = req.getParameter("homepage");
		write(homepageStr);
	}
}
