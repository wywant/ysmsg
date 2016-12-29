package shuaxin.ops;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import shuaxin.configs.HomepageConfig;


public class OpenBrowser {

	private static WebDriver webdriver;
	public OpenBrowser() {
	}
	public static WebDriver getWebdriver() {
		return webdriver;
	}
	public static String refresh(HttpServletRequest req){
		if(webdriver == null){
			return null;
		}
		 Set<String> handles = webdriver.getWindowHandles();
		 List<String> refreshHandlers = RefreshPages.getRefreshHandlers();
		 StringBuilder sb = new StringBuilder();
	        for(String handle : handles){
	        	if(!refreshHandlers.contains(handle)){
	        		continue;
	        	}
	        	webdriver.switchTo().window(handle);
	        	webdriver.navigate().refresh();
	        	sb.append(handle).append("<br/>");
	        }
	     if(sb.length() == 0){
	    	 return null;
	     }
	     return sb.toString();
	}
	public static String openBrowser() throws IOException{
		webdriver = new ChromeDriver();
		String homepage = HomepageConfig.read();
		if(homepage != null){
			webdriver.get(homepage);
		}
		return null;
	}
	public static List<String> getWindowHandles(){
		if(webdriver == null){
			return new ArrayList<String>();
		}
		 Set<String> handles = webdriver.getWindowHandles();
	     return new ArrayList<String>(handles);   
	}
}
