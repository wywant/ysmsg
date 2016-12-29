package shuaxin.configs;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class RefreshInterval {
private static int interval = 5;
private static String filename = "refreshInterval.txt";
	public RefreshInterval() {
	}
	public static int getInterval() {
		return interval;
	}
	public static void setInterval(int interval) {
		RefreshInterval.interval = interval;
	}
	public static void load() throws IOException{
		File file = new File(filename);
		if(!file.exists()){
			return;
		}
		String str = FileUtils.readFileToString(file).trim();
		if(str.isEmpty()){
			return;
		}
		int n = Integer.parseInt(str);
		setInterval(n);
	}
	public static void setInterval(HttpServletRequest req) throws IOException{
		if(!"post".equalsIgnoreCase(req.getMethod())){
			return;
		}
		String refreshInterval = req.getParameter("interval");
		if(refreshInterval == null){
			return;
		}
		refreshInterval = refreshInterval.trim();
		if(refreshInterval.isEmpty()){
			return;
		}
		int n = Integer.parseInt(refreshInterval);
		setInterval(n);
		File file = new File(filename);
		FileUtils.writeStringToFile(file, refreshInterval,"UTF-8");
	}

}
