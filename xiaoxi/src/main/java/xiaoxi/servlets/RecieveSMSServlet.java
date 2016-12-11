package xiaoxi.servlets;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xiaoxi.configs.AfterOperationConfig;
import xiaoxi.ops.CopyToClipBoard;
import xiaoxi.ops.LocateInput;
import xiaoxi.ops.OpenNotepad;
import xiaoxi.ops.PhoneNumberChecker;
import xiaoxi.ops.VerificateExtractor;

public class RecieveSMSServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RecieveSMSServlet() {
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eAddress = req.getParameter("a");
		String eContent = req.getParameter("c");
		
		String message;
		if(eAddress == null){
			message = DataListener.getI18NMessage("parameterAIsRequired");
		} else if(eContent == null){
			message = DataListener.getI18NMessage("parameterCIsRequired");
		} else {
			String address = URLDecoder.decode(eAddress, "UTF-8");
			String content = URLDecoder.decode(eContent, "UTF-8");
			String verificateCode;
			if(!PhoneNumberChecker.isAcceptPhoneNumber(address)){
				message = DataListener.getI18NMessage("isNotPhoneNumberOfVerificateCode") + address;
			} else if((verificateCode = VerificateExtractor.extractVerifcateCode(content)) != null){
				int operation = AfterOperationConfig.getOperation();
				if(operation == 1){
					CopyToClipBoard.copyToClipBoard(verificateCode);
					message = DataListener.getI18NMessage("successCopyToClipboard");
				} else if(operation == 2){
					OpenNotepad.openNotepad(verificateCode);
					message = DataListener.getI18NMessage("successOpenTextFile");
				} else if(operation == 3){
					CopyToClipBoard.copyToClipBoard(verificateCode);
					OpenNotepad.openNotepad(verificateCode);
					message = DataListener.getI18NMessage("successCopyAndOpen");
				} else if(operation == 4){
					message = LocateInput.inputVerificateCode(verificateCode);
				} else {
					message = DataListener.getI18NMessage("configAfterOperation");
				}
			} else {
				message = DataListener.getI18NMessage("failedExtractVerificateCode");
			}
		}
		
		resp.setContentType ("text/html;charset=utf-8");
		resp.getWriter().write(message);
		
	}

}
