package carss.servlet;




import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import carss.web.Param;








public class AppListener implements ServletContextListener {

	/**
	 * @���� servletContext������ʱ�򴥷����¼�
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
	//	System.out.println("[------ϵͳ��ʼ��ʼ����------]");
		
		Param.webPath=servletContextEvent.getServletContext().getRealPath("/");

	}
	
	/**
	 * @���� servletContext�رյ�ʱ�򴥷�
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
	//	System.out.println("------ϵͳ�ر���ɣ�------");
	}

}
