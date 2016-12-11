package xiaoxi.ops;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class OpenNotepad {

	public OpenNotepad() {
	}
	public static void main(String[] args) throws IOException {
		openNotepad("ggggg");
	}
	public static void openNotepad(String content) throws IOException{
		File file = File.createTempFile("test", "aaa.txt");
		FileUtils.writeStringToFile(file, content, "UTF-8");
		Desktop.getDesktop().edit(file);
	}

}
