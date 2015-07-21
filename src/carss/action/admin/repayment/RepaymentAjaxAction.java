/**
 * @功能 
 */

package carss.action.admin.repayment;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.CardInfo;
import carss.po.DealInfo;
import carss.po.PostInfo;
import carss.service.CardInfoService;
import carss.service.DealInfoService;
import carss.service.PostInfoService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(type = "json") })
public class RepaymentAjaxAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;

	@Resource
	private PostInfoService postInfoService;

	
	@Resource
	private DealInfoService dealInfoService;

	
	private Integer id;

	private CardInfo one = new CardInfo();
	private PostInfo post = new PostInfo();

	private Boolean result = false;

	private Double alsoPayMoney;

	private Double postMoney;

	/**
	 * @功能
	 */
	public String execute() {
		one = cardInfoService.get(id);
 
		cardInfoService.update(one);
		result = true;
		return SUCCESS;
	}
	
	
	public String updateDeal() {
		DealInfo dl = dealInfoService.get(id); 
		dealInfoService.updateMoneyForAdmin(dl);
		result = true;
		return SUCCESS;
	}


	public String updateAlso() {
		DealInfo dl = dealInfoService.get(id); 
		dealInfoService.updateMoneyForAdmin(dl);
		result = true;
		return SUCCESS;
	}

	public String post() {
		post = postInfoService.get(id);
		postMoney = post.getPostMoney();
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Double getAlsoPayMoney() {
		return alsoPayMoney;
	}

	public void setAlsoPayMoney(Double alsoPayMoney) {
		this.alsoPayMoney = alsoPayMoney;
	}

	public Double getPostMoney() {
		return postMoney;
	}

	public void setPostMoney(Double postMoney) {
		this.postMoney = postMoney;
	}

}
