package xiaoxi.ops;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import xiaoxi.configs.BrowserConfig;
import xiaoxi.servlets.DataListener;

public class OpenBrowser {

	private static WebDriver webdriver;
	public OpenBrowser() {
	}
	public static WebDriver getWebdriver() {
		return webdriver;
	}

	public static String openBrowser() throws IOException{
		String[] ss = BrowserConfig.read();
		if(ss == null){
			return DataListener.getI18NMessage("pleaseConfigBrowser");
		}
		String browser = ss[0];
		String homepage = null;
		if(ss.length > 1){
			homepage = ss[1];
		}
		if("Chrome".equals(browser)){
			
			webdriver = new ChromeDriver();
		} else if("IE".equals(browser)){
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//			caps.setCapability("EnableNativeEvents", false);
			caps.setCapability("ignoreZoomSetting", true); 
			webdriver = new InternetExplorerDriver(caps);
		} else if("Firefox".equals(browser)){
			webdriver = new FirefoxDriver(); 
		} else {
			return DataListener.getI18NMessage("notSupportedBrowser") + browser;
		}
		if(homepage != null){
			webdriver.get(homepage);
		}
		return null;
	}

}
