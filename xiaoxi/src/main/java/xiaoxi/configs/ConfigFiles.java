package xiaoxi.configs;

import java.io.File;

public class ConfigFiles {

	public ConfigFiles() {
	}
	public static File getAfterOperationFile(){
		return new File("afterOperation.txt");
	}
	public static File getBrowserDriverFile(){
		return new File("browserDriver.txt");
	}
	public static File getBrowserFile(){
		return new File("browser.txt");
	}
	public static File getLocateInputFile(){
		return new File("locateInput.txt");
	}
	public static File getPhoneNumberFile(){
		return new File("phoneNumber.txt");
	}
	public static File getBrowserDriverDir(){
		File dir = new File("c:/browser/");
		return dir;
	}
	public static File getChromeDriverFile(){
		//TODO
		return null;
	}
	public static File getIEDriverFile(){
		//TODO
		return null;
	}

}
