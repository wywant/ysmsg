package xiaoxi.ops;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CopyToClipBoard {

	public CopyToClipBoard() {
	}

	public static void main(String[] args) {

		copyToClipBoard("google it");
	}
	public static void copyToClipBoard(String message){
		StringSelection stringSelection = new StringSelection(message);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}

}
