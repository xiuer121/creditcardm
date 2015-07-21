/**
 * @功能 
 */

package carss.action.admin.repayment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.constant.CardConstant;
import carss.constant.CreditRecConstant;
import carss.constant.DealInfoConstant;
import carss.po.BankCardInfo;
import carss.po.CardInfo;
import carss.po.CreditRecords;
import carss.po.DealInfo;
import carss.po.auth.Admin;
import carss.service.BankCardInfoService;
import carss.service.CardInfoService;
import carss.service.CreditRecordsService;
import carss.service.DealInfoService;
import carss.service.perm.AdminService;
import carss.vo.LoginAdmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(type = "redirectAction", location = "repayment-list"),
		@Result(name = "input", location = "repayment-add.jsp"), })
public class RepaymentAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;

	@Resource
	private AdminService adminService;

	@Resource
	private DealInfoService dealInfoService;

	@Resource
	private BankCardInfoService bankCardInfoService;

	@Resource
	private CreditRecordsService creditRecordsService;

 
	private Integer id;

	private Integer type;

	private Integer bankId;
	private String cardNo;
	private String cardBank;
	private String personName;
	private String idNo;
	private String phone;

	private Double credits;
	private Double money;
	private Double rates;
	private Boolean stayStates;
	
	private String cardPassword;
	private String queryPassword;

	private List<BankCardInfo> bankList = new ArrayList<BankCardInfo>();
 

	/**
	 * @功能
	 */
	public String show() {

		bankList = bankCardInfoService.getList();

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
		one.setCardType(CardConstant.CARD_TYPE_REPAYMENT);
		one.setCredits(credits);
		one.setEntrustDate(new Date());
		one.setMoney(money);
		one.setRates(rates);
		one.setIdNo(idNo);
		one.setPersonName(personName);
		one.setPhone(phone);
		one.setRepaymentStates(CardConstant.CARD_REPAYMENT_ALSO);
		one.setStayStates(stayStates);
		one.setRepaymentDate(new Date());
		one.setCardStates(CardConstant.CARD_CANCEL_NO);
		one.setCardPassword(cardPassword);
		one.setQueryPassword(queryPassword);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);

		cardInfoService.save(one);

		if (stayStates) {
			CardInfo next = new CardInfo();
			next = one;
			next.setRepaymentDate(calendar.getTime());
			cardInfoService.clear();
			cardInfoService.save(next);
		}
		// 保存还卡记录
		BankCardInfo bankInfo = bankCardInfoService.get(bankId);
		CreditRecords crs = new CreditRecords();
		crs.setBankInfo(bankInfo);
		crs.setBrushType(CreditRecConstant.CREDITREC_REPAYMENT);
		crs.setCardInfo(one);
		crs.setBrushMoney(money);
		crs.setBrushDate(new Date());
		creditRecordsService.save(crs);

		// 还卡操作时候，修改银行卡的当日还卡金额总
		bankInfo.setBankMoney(bankInfo.getBankMoney() + money);
		bankCardInfoService.update(bankInfo);

		// 生成一条工资记录
		DealInfo dealInfo = new DealInfo();
		dealInfo.setBankMoney(money);
		dealInfo.setCardInfo(one);
		dealInfo.setDealStates(DealInfoConstant.DEAL_STATES_PLUSH_REPAYMENT);
		dealInfo.setCommitDate(new Date());
		dealInfo.setNeedMoney(money);
		dealInfo.setCheckState(DealInfoConstant.DEAL_CHECK_NO);
		dealInfo.setFinshState(DealInfoConstant.DEAL_FINSH_NO);
		dealInfo.setPostMoney(0d);
		dealInfo.setAdminInfo(adminInfo);
		dealInfoService.save(dealInfo);
		return SUCCESS;
	}

	/**
	 * @功能
	 */

	@Override
	public void validate() {
		String where = " where o.cardInfo.cardNo = ? and o.dealStates = ? and finshState = ? ";
		List<Object> params = new ArrayList<Object>();
		params.add(cardNo);
		params.add(DealInfoConstant.DEAL_STATES_PLUSH_REPAYMENT);
		params.add(DealInfoConstant.DEAL_FINSH_NO);
		List<DealInfo> deals = dealInfoService.getList(where, params.toArray());
		if (deals.size() > 0) {
			this.addActionError("已经有一条提额申请");
		}
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

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
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

	public Boolean getStayStates() {
		return stayStates;
	}

	public void setStayStates(Boolean stayStates) {
		this.stayStates = stayStates;
	}

	public List<BankCardInfo> getBankList() {
		return bankList;
	}

	public void setBankList(List<BankCardInfo> bankList) {
		this.bankList = bankList;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
