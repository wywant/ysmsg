package xiaoxi.ops;

import xiaoxi.configs.PhoneNumberConfig;

public class PhoneNumberChecker {

	public PhoneNumberChecker() {
	}
	public static boolean isAcceptPhoneNumber(String number){
		String phoneNumber = PhoneNumberConfig.getPhoneNumber();
		if(phoneNumber == null){
			return true;
		}
		if(phoneNumber.isEmpty()){
			return true;
		}
		if(phoneNumber.equals(number)){
			return true;
		}
		return false;
	}

}
