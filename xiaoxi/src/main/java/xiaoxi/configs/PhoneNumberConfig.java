package xiaoxi.configs;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class PhoneNumberConfig {
private static String phoneNumber;
	public PhoneNumberConfig() {
	}
	public static void load() throws IOException{
		phoneNumber = read();
	}
	
	public static String getPhoneNumber() {
		return phoneNumber;
	}
	public static String read() throws IOException{
		File file = ConfigFiles.getPhoneNumberFile();
		if(!file.exists()){
			return null;
		}
		String content = FileUtils.readFileToString(file, "UTF-8");
		content = content.trim();
		if(content.isEmpty()){
			return null;
		}
		return content;
	}
	public static void write(String number) throws IOException{
		phoneNumber = number;
		if(number == null){
			number = "";
		}
		File file = ConfigFiles.getPhoneNumberFile();
		FileUtils.writeStringToFile(file, number, "UTF-8");
	}
	public static void request(HttpServletRequest req) throws IOException{
		if(!"post".equalsIgnoreCase(req.getMethod())){
			return ;
		}
		String phoneNumber = req.getParameter("phoneNumber");
		write(phoneNumber);
	}
}
