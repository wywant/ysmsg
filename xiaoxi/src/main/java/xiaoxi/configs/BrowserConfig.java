package xiaoxi.configs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class BrowserConfig {

	
	public BrowserConfig() {
	}
	public static void write(String browser,String homepage) throws IOException{
		StringBuilder sb = new StringBuilder();
		sb.append(browser);
		sb.append('\n');
		sb.append(homepage);
		String content = sb.toString();
		File file = ConfigFiles.getBrowserFile();
		FileUtils.writeStringToFile(file, content, "UTF-8");
	}
	
	public static String[] read() throws IOException{
		File file = ConfigFiles.getBrowserFile();
		if(!file.exists()){
			return null;
		}
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		String browser = lines.get(0);
		String homepage = "";
		if(lines.size() > 1){
			homepage = lines.get(1);
		}
		
		String[] ss = {browser,homepage};
		return ss;
	}
	public static void request(HttpServletRequest req) throws IOException{
		if(!"post".equalsIgnoreCase(req.getMethod())){
			return ;
		}
		String browserStr = req.getParameter("browser");
		String homepageStr = req.getParameter("homepage");
		write(browserStr,homepageStr);
	}
}
