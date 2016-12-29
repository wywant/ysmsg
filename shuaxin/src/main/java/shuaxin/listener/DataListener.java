package shuaxin.listener;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import shuaxin.configs.RefreshInterval;


public class DataListener implements ServletContextAttributeListener, ServletContextListener{
private static ResourceBundle bundle;
private ServletContext context = null;
	public DataListener() {
	}
	
	public static String getI18NMessage(String key){
		String value = bundle.getString(key);
		return value;
	}
	 @Override
	    public void attributeAdded(ServletContextAttributeEvent event) {

	        log("attributeAdded('" + event.getName() + "', '" +
	                event.getValue() + "')");

	    }


	    /**
	     * Record the fact that a servlet context attribute was removed.
	     *
	     * @param event The servlet context attribute event
	     */
	    @Override
	    public void attributeRemoved(ServletContextAttributeEvent event) {

	        log("attributeRemoved('" + event.getName() + "', '" +
	                event.getValue() + "')");

	    }


	    /**
	     * Record the fact that a servlet context attribute was replaced.
	     *
	     * @param event The servlet context attribute event
	     */
	    @Override
	    public void attributeReplaced(ServletContextAttributeEvent event) {

	        log("attributeReplaced('" + event.getName() + "', '" +
	                event.getValue() + "')");

	    }


	    /**
	     * Record the fact that this web application has been destroyed.
	     *
	     * @param event The servlet context event
	     */
	    @Override
	    public void contextDestroyed(ServletContextEvent event) {

	        log("contextDestroyed()");
	        this.context = null;

	    }


	    /**
	     * Record the fact that this web application has been initialized.
	     * @param event The servlet context event
	     */
	    @Override
	    public void contextInitialized(ServletContextEvent event) {
	    	
	    	
	        this.context = event.getServletContext();
	        String path = context.getRealPath("selinum");
	        File dir = new File(path);
	        File chromeDirverFile = new File(dir,"chromedriver.exe");
	        File ieDriverFile = new File(dir,"IEDriverServer.exe");
	        try {
				String chromePath = chromeDirverFile.getCanonicalPath();
				String iePath = ieDriverFile.getCanonicalPath();
				System.out.println(chromePath);
				System.out.println(iePath);
				System.setProperty("webdriver.chrome.driver", 
						chromePath); 
		        System.setProperty("webdriver.ie.driver", iePath);
		        RefreshInterval.load();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        System.out.println(path);
	        
	        log("contextInitialized()");
	        bundle = ResourceBundle .getBundle("shuaxin.i18n.message");
	       
	    }


	    // -------------------------------------------------------- Private Methods


	    /**
	     * Log a message to the servlet context application log.
	     *
	     * @param message Message to be logged
	     */
	    private void log(String message) {

	        if (context != null)
	            context.log("ContextListener: " + message);
	        else
	            System.out.println("ContextListener: " + message);

	    }
}
