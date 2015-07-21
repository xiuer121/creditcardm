/**
 * @功能 
 */

package carss.action.admin.sys;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.BankRepaymentDay;
import carss.service.BankRepaymentDayService;
import carss.vo.View;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(location = "bank-day-list.jsp")})
public class BankDayListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private BankRepaymentDayService bankRepaymentDayService;
 
	private View<BankRepaymentDay> view = new View<BankRepaymentDay>();

 

	/**
	 * @功能
	 */
	public String execute() {

		String where = " where 1 = 1 order by o.dateTitle desc";

		
	
		view = bankRepaymentDayService.getView(where, view, null); 
		return SUCCESS;
	}



	public View<BankRepaymentDay> getView() {
		return view;
	}



	public void setView(View<BankRepaymentDay> view) {
		this.view = view;
	}

 

 

}
