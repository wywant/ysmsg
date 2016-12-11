package xiaoxi.ops;

import java.util.ArrayList;
import java.util.List;

public class VerificateExtractor {

	public VerificateExtractor() {
	}
	private static boolean isVCChar(char c){
		if(c >= '0' && c <= '9'){
			return true;
		}
		if(c >= 'a' && c <= 'z'){
			return true;
		}
		if(c >= 'A' && c <= 'Z'){
			return true;
		}
		return false;
	}
	public static String extractVerifcateCode(String content){
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		char[] cs = content.toCharArray();
		for(char c : cs){
			if(isVCChar(c)){
				sb.append(c);
			} else {
				if(sb.length() > 0){
					String s = sb.toString();
					list.add(s);
					sb.setLength(0);
				}
			}
		}
		for(String s : list){
			if(s.length() >= 6){
				return s;
			}
		}
		return null;
	}

}
