/**
 * @功能 
 */

package carss.action.admin.repayment;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.CardInfo;
import carss.service.CardInfoService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(type = "redirectAction", location = "cash-list"),
		@Result(name = "input", location = "cash-update.jsp") })
public class CashUpdateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;
	
 

 

	private Integer id;

	private String cardNo;
	private String cardBank;
	private String personName;
	private String idNo;
	private String phone;
	private Double credits;
	private Double money;
	private Double rates;
	
	private String cardPassword;
	private String queryPassword;
	
	private CardInfo one = new CardInfo();
 
	private Integer selects;

	/**
	 * @功能
	 */
	public String execute() {
		one = cardInfoService.get(id);

		one.setCardNo(cardNo);
		one.setCardBank(cardBank);
		one.setCredits(credits);
		one.setIdNo(idNo);
		one.setPersonName(personName);
		one.setPhone(phone);
		one.setMoney(money);
		one.setRates(rates);
		one.setCardPassword(cardPassword);
		one.setQueryPassword(queryPassword);
		cardInfoService.updateMoneyWithDeal(one);
		
		//修改操作，把交易信息进行修改
		
		
		
		
		return SUCCESS;
	}

	public String show() {
		one = cardInfoService.get(id);
		personName = one.getPersonName();
		idNo = one.getIdNo();
		phone = one.getPhone();

		cardNo = one.getCardNo();
		cardBank = one.getCardBank();
		credits = one.getCredits();
		money = one.getMoney();
		rates = one.getRates();
		cardPassword = one.getCardPassword();
		queryPassword = one.getQueryPassword();
		return INPUT;
	}

	public String fen() {
		// if (is != null && selects != null) {
		// Admin admin = adminService.get(selects);
		//
		// String[] iss = is.split(",");
		// for (String s : iss) {
		// one = heightenInfoService.get(Integer.parseInt(s));
		// one.setAdminInfo(admin);
		// heightenInfoService.update(one);
		// }
		//
		// }

		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardBank() {
		return cardBank;
	}

	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getCredits() {
		return credits;
	}

	public void setCredits(Double credits) {
		this.credits = credits;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getRates() {
		return rates;
	}

	public void setRates(Double rates) {
		this.rates = rates;
	}

	public CardInfo getOne() {
		return one;
	}

	public void setOne(CardInfo one) {
		this.one = one;
	}

	public Integer getSelects() {
		return selects;
	}

	public void setSelects(Integer selects) {
		this.selects = selects;
	}

	public String getCardPassword() {
		return cardPassword;
	}

	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}

	public String getQueryPassword() {
		return queryPassword;
	}

	public void setQueryPassword(String queryPassword) {
		this.queryPassword = queryPassword;
	}
	
	
	

}
