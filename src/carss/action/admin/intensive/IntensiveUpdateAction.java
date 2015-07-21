/**
 * @功能 
 */

package carss.action.admin.intensive;

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
import carss.service.BankCardInfoService;
import carss.service.CardInfoService;
import carss.service.CreditRecordsService;
import carss.service.PostInfoService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(location = "repayment-show.jsp"),
		@Result(name = "input", location = "intensive-show.jsp") })
public class IntensiveUpdateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;

	@Resource
	private PostInfoService postInfoService;

	@Resource
	private BankCardInfoService bankCardInfoService;
	
	@Resource
	private CreditRecordsService creditRecordsService;

	private Integer id;

	private CardInfo one = new CardInfo();

	private List<PostInfo> postList = new ArrayList<PostInfo>();

	private List<BankCardInfo> bankList = new ArrayList<BankCardInfo>();
	private List<CreditRecords> creditsRecList = new ArrayList<CreditRecords>();

	/**
	 * @功能
	 */
	public String execute() {
		one = cardInfoService.get(id);
		return INPUT;
	}

	public String show() {
		postList = postInfoService.getList();
		bankList = bankCardInfoService.getList();
		String where = " where  o.cardInfo.id = ? ";
		creditsRecList = creditRecordsService.getList(where,new Object[]{id});

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

 

}
