package xiaoxi.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectionTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ConnectionTestServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String connectionOK = DataListener.getI18NMessage("connectionOK");
		resp.setContentType ("text/html;charset=utf-8");
		resp.getWriter().write(connectionOK);
	}

}
