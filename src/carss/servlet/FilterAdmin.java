/**
 * @功能 过滤管理员
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
		
		//帳戶等級等于40才是 管理员
		HttpSession session=request.getSession();
		LoginAdmin loginAdmin=(LoginAdmin)session.getAttribute("loginAdmin");

		
		if(loginAdmin!=null){
			filterChain.doFilter(servletRequest, servletResponse);
		}else{
			//級别不满足要求就踢回會員员登陆頁面
			response.sendRedirect(request.getContextPath()+"/login-admin.jsp");
		}

	}
	
	public void destroy() {

	}
	
	
}
