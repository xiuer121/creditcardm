package carss.servlet;




import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import carss.web.Param;








public class AppListener implements ServletContextListener {

	/**
	 * @功能 servletContext启动的时候触发的事件
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
	//	System.out.println("[------系统开始初始化！------]");
		
		Param.webPath=servletContextEvent.getServletContext().getRealPath("/");

	}
	
	/**
	 * @功能 servletContext关闭的时候触发
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
	//	System.out.println("------系统关闭完成！------");
	}

}
