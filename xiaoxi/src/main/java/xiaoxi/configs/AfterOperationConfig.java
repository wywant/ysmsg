package xiaoxi.configs;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class AfterOperationConfig {
private static Integer operation;
	public AfterOperationConfig() {
	}
	public static void load(){
		operation = read();
	}
	public static int getOperation(){
		return operation;
	}
	public static int read(){
		File file = ConfigFiles.getAfterOperationFile();
		if(!file.exists()){
			return 1;
		}
		try {
			String content = FileUtils.readFileToString(file);
			Integer number = Integer.parseInt(content);
			return number;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
		
	}
	public static void write(String value) throws IOException{
		File file = ConfigFiles.getAfterOperationFile();
		FileUtils.writeStringToFile(file, value, "UTF-8");
	}
	
	public static void request(HttpServletRequest req) throws IOException{
		if(!"post".equalsIgnoreCase(req.getMethod())){
			return ;
		}
		String operationStr = req.getParameter("operation");
		write(operationStr);
		operation = Integer.parseInt(operationStr);
	}

}
