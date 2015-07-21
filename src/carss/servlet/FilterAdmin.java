/**
 * @���� ���˹���Ա
 */

package carss.servlet;





import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carss.vo.LoginAdmin;










public class FilterAdmin  implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
	}
	
	

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		
		//�����ȼ�����40���� ����Ա
		HttpSession session=request.getSession();
		LoginAdmin loginAdmin=(LoginAdmin)session.getAttribute("loginAdmin");

		
		if(loginAdmin!=null){
			filterChain.doFilter(servletRequest, servletResponse);
		}else{
			//��������Ҫ����߻ؕ��TԱ��½���
			response.sendRedirect(request.getContextPath()+"/login-admin.jsp");
		}

	}
	
	public void destroy() {

	}
	
	
}
