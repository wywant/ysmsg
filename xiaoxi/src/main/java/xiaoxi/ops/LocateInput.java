package xiaoxi.ops;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import xiaoxi.configs.LocateInputConfig;
import xiaoxi.servlets.DataListener;

public class LocateInput {

	public LocateInput() {
	}
	
	public static String inputVerificateCode(String verficateCode) throws IOException{
		String[] ss = LocateInputConfig.read();
		if(ss == null){
			return DataListener.getI18NMessage("pleaseSetHowToLocateVCInput");
		}
		String type = ss[0];
		String expression = ss[1];
//		Date d1 = new Date();
		WebDriver webDriver = OpenBrowser.getWebdriver();
		if(webDriver == null){
			return DataListener.getI18NMessage("openBrowserInHome");
		}
		String currentHandle = webDriver.getWindowHandle();  
//        System.out.println("currentHandler=" + currentHandle);
//        System.out.println(webDriver.getTitle());
        Set<String> handles = webDriver.getWindowHandles();
        String lastHandle = webDriver.getWindowHandle();
        for(String s : handles){
        	lastHandle = s;
        }
        System.out.println("lastHandle=" + lastHandle);
        System.out.println("handlers=" + handles);
        if(lastHandle.equals(currentHandle)){
        	
        } else {
        	webDriver.switchTo().window(lastHandle);
        }
//        System.out.println(handles.getClass().getName());
		
//        for (String s : handles) {  
//            if (s.equals(currentHandle))  
//                continue;  
//            else {  
//            	webDriver.switchTo().window(s); 
//            }  
//        }

		WebElement element;
		if("ID".equals(type)){
			
			element = webDriver.findElement(By.id(expression));
		} else {
			element = webDriver.findElement(By.xpath(expression));
		}
		
//		Date d2 = new Date();
//		System.out.println("find element timecost = " + (d2.getTime() - d1.getTime()));
//		Date d3 = new Date();
		element.clear();
//		System.out.println("find element timecost = " + (d3.getTime() - d2.getTime()));
//		Date d4 = new Date();
		element.sendKeys(verficateCode);
//		System.out.println("find element timecost = " + (d4.getTime() - d3.getTime()));
		String message = DataListener.getI18NMessage("successInputVerificateCodeToBrowser");
		return message;
	}
	

}
