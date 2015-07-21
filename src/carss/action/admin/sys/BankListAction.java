/**
 * @功能 
 */

package carss.action.admin.sys;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.BankCardInfo;
import carss.service.BankCardInfoService;
import carss.vo.View;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(location = "bank-list.jsp") })
public class BankListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private BankCardInfoService bankCardInfoService;

	private Integer id;
	private Integer[] ids;

	private View<BankCardInfo> view = new View<BankCardInfo>();

	/**
	 * @功能
	 */
	public String execute() {

		String where = " ";

		view = bankCardInfoService.getView(where, view, null);

		return SUCCESS;
	}

	/**
	 * @功能
	 */
	public String remove() throws Exception {

		// Admin one=postInfoService.get(id);
		// adminService.delete(one);
		//
		return this.execute();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public View<BankCardInfo> getView() {
		return view;
	}

	public void setView(View<BankCardInfo> view) {
		this.view = view;
	}

	 

}
