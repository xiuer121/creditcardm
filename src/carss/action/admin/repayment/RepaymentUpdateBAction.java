/**
 * @功能 
 */

package carss.action.admin.repayment;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.BankCardInfo;
import carss.po.CardInfo;
import carss.po.CreditRecords;
import carss.po.PostInfo;
import carss.po.auth.Admin;
import carss.service.BankCardInfoService;
import carss.service.CardInfoService;
import carss.service.CreditRecordsService;
import carss.service.PostInfoService;
import carss.service.perm.AdminService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(type = "redirectAction", location = "repayment-list"),
		@Result(name = "input", location = "repayment-update.jsp") })
public class RepaymentUpdateBAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;

	@Resource
	private PostInfoService postInfoService;

	@Resource
	private BankCardInfoService bankCardInfoService;

	@Resource
	private CreditRecordsService creditRecordsService;
	@Resource
	private AdminService adminService;
	private Integer id;

	private CardInfo one = new CardInfo();

	private List<PostInfo> postList = new ArrayList<PostInfo>();

	private List<BankCardInfo> bankList = new ArrayList<BankCardInfo>();
	private List<CreditRecords> creditsRecList = new ArrayList<CreditRecords>();

	private String is;
	private Integer selects;
 

	/**
	 * @功能
	 */
	public String execute() {
		one = cardInfoService.get(id);
		
		
		
		
		
		return SUCCESS;
	}

	public String del() {
		one = cardInfoService.get(id);
		one.setCardStates(20);
		cardInfoService.update(one);
		return this.execute();
	}

	public String fen() {
		if (is != null && selects != null) { 
			Admin admin = adminService.get(selects); 
			
			String[] iss =is.split(",");
			for(String s :iss){
				one =cardInfoService.get(Integer.parseInt(s));
				one.setAdmin(admin); 
				cardInfoService.update(one);
			}
		
		}

		return SUCCESS;
	}

	public String show() {
		
		String where ="order by o.postMaxMoney - postMoney desc";
		postList = postInfoService.getList(where,null);
		bankList = bankCardInfoService.getList();
		where = " where  o.cardInfo.id = ? ";
		creditsRecList = creditRecordsService.getList(where,
				new Object[] { id }); 
		//存入金额
 
		
		one = cardInfoService.get(id);
		return INPUT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CardInfo getOne() {
		return one;
	}

	public void setOne(CardInfo one) {
		this.one = one;
	}

	public List<PostInfo> getPostList() {
		return postList;
	}

	public void setPostList(List<PostInfo> postList) {
		this.postList = postList;
	}

	public List<BankCardInfo> getBankList() {
		return bankList;
	}

	public void setBankList(List<BankCardInfo> bankList) {
		this.bankList = bankList;
	}

	public List<CreditRecords> getCreditsRecList() {
		return creditsRecList;
	}

	public void setCreditsRecList(List<CreditRecords> creditsRecList) {
		this.creditsRecList = creditsRecList;
	}

	public String getIs() {
		return is;
	}

	public void setIs(String is) {
		this.is = is;
	}

	public Integer getSelects() {
		return selects;
	}

	public void setSelects(Integer selects) {
		this.selects = selects;
	}
	
	

}
