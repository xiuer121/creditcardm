/**
 * @功能 过滤投资商
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

import carss.vo.LoginMember;











public class FilterMember  implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		
		HttpSession session=request.getSession();
		LoginMember loginMember=(LoginMember)session.getAttribute("loginMember");


		if(loginMember!=null){
			filterChain.doFilter(servletRequest, servletResponse);
		}else{
			response.sendRedirect(request.getContextPath()+"/login-member.jsp");
		}

	}

	
	public void destroy() {

	}
	
	
}
