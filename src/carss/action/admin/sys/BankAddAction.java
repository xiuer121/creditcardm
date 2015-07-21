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

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(type = "redirectAction", location = "bank-list"),
		@Result(name = "input", location = "bank-add.jsp") })
public class BankAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private BankCardInfoService bankCardInfoService;

	private String bankNo;
	private String bankTitle;
	private String bankCardNo;

	/**
	 * @功能 新增管理员
	 */
	public String execute() throws Exception {

		BankCardInfo o = new BankCardInfo();

		o.setBankNo(bankNo);
		o.setBankTitle(bankTitle);
		o.setBankCardNo(bankCardNo);
		o.setBankMoney(0d);
		bankCardInfoService.save(o);
		return SUCCESS;

	}

	/**
	 * @功能
	 */
	public void validate() {

	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankTitle() {
		return bankTitle;
	}

	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

}
