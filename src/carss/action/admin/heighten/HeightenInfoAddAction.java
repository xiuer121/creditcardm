/**
 * @功能 
 */

package carss.action.admin.heighten;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.constant.CardConstant;
import carss.constant.DealInfoConstant;
import carss.po.CardInfo;
import carss.po.DealInfo;
import carss.po.auth.Admin;
import carss.service.CardInfoService;
import carss.service.DealInfoService;
import carss.service.perm.AdminService;
import carss.vo.LoginAdmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(type = "redirectAction", location = "heighten-info-list"),
		@Result(name = "input", location = "heighten-info-add.jsp") })
public class HeightenInfoAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;
	

	@Resource
	private DealInfoService dealInfoService;

	@Resource
	private AdminService adminService;

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
	/**
	 * @功能
	 */
	public String zhuan() {

		if (id != null) {
			CardInfo one = cardInfoService.get(id);
			if (one != null) {
				personName = one.getPersonName();
				idNo = one.getIdNo();
				phone = one.getPhone();
				cardNo = one.getCardNo();
				cardBank = one.getCardBank();
				credits = one.getCredits();
				money = one.getMoney();
				rates = one.getRates();

			}

		}

		return INPUT;

	}

	@Override
	public String execute() throws Exception {
		LoginAdmin loginAdmin = (LoginAdmin) ActionContext.getContext()
				.getSession().get("loginAdmin");

		CardInfo one = new CardInfo();

		Admin adminInfo = adminService.get(loginAdmin.getId());

		one.setAdmin(adminInfo);
		one.setCardBank(cardBank);
		one.setCardNo(cardNo);
		one.setCardType(CardConstant.CARD_TYPE_HEIGHTEN);
		one.setCredits(credits);
		one.setEntrustDate(new Date());
		one.setMoney(money);
		one.setRates(rates);
		one.setIdNo(idNo);
		one.setPersonName(personName);
		one.setPhone(phone);
		one.setCardStates(CardConstant.CARD_CANCEL_NO);
		one.setCardPassword(cardPassword);
		one.setQueryPassword(queryPassword);
		cardInfoService.save(one);

		// 生成一条工资记录
		DealInfo dealInfo = new DealInfo();
		dealInfo.setBankMoney(0d);
		dealInfo.setCardInfo(one); 
		dealInfo.setCommitDate(new Date());
		dealInfo.setNeedMoney(money);
		dealInfo.setCheckState(DealInfoConstant.DEAL_CHECK_NO);
		dealInfo.setFinshState(DealInfoConstant.DEAL_FINSH_YES);
		dealInfo.setPostMoney(0d);
		dealInfo.setMoney(money*rates*adminInfo.getPoint());
		dealInfo.setAdminInfo(adminInfo);
		dealInfoService.save(dealInfo);
		return SUCCESS;
	}

	/**
	 * @功能
	 */

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
