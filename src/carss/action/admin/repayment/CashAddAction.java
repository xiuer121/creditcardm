/**
 * @功能 
 */

package carss.action.admin.repayment;

import java.util.ArrayList;
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
import carss.po.CardInfo;
import carss.po.CreditRecords;
import carss.po.DealInfo;
import carss.po.PostInfo;
import carss.po.auth.Admin;
import carss.service.CardInfoService;
import carss.service.CreditRecordsService;
import carss.service.DealInfoService;
import carss.service.PostInfoService;
import carss.service.perm.AdminService;
import carss.vo.LoginAdmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(type = "redirectAction", location = "cash-list"),
		@Result(name = "input", location = "cash-add.jsp"), })
public class CashAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;

	@Resource
	private AdminService adminService;

	@Resource
	private DealInfoService dealInfoService;

	@Resource
	private PostInfoService postInfoService;

	@Resource
	private CreditRecordsService creditRecordsService;

	private Integer id;

	private Integer type;

	private Integer postId;
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
	
	private List<PostInfo> postList = new ArrayList<PostInfo>();

	/**
	 * @功能
	 */

	@Override
	public String execute() throws Exception {

		LoginAdmin loginAdmin = (LoginAdmin) ActionContext.getContext()
				.getSession().get("loginAdmin");

		CardInfo one = new CardInfo();

		Admin adminInfo = adminService.get(loginAdmin.getId());

		one.setAdmin(adminInfo);
		one.setCardBank(cardBank);
		one.setCardNo(cardNo);
		one.setCardType(CardConstant.CARD_TYPE_CASHT);
		one.setCredits(credits);
		one.setEntrustDate(new Date());
		one.setMoney(money);
		one.setRates(rates);
		one.setIdNo(idNo);
		one.setPersonName(personName);
		one.setPhone(phone);
		one.setStayStates(stayStates);
		one.setCardStates(CardConstant.CARD_CANCEL_NO);
		one.setCardPassword(cardPassword);
		one.setQueryPassword(queryPassword);
		
		cardInfoService.save(one);

		// 保存刷卡记录
		PostInfo postInfo = postInfoService.get(postId);
		CreditRecords crs = new CreditRecords();
		crs.setPostInfo(postInfo);
		crs.setBrushType(CreditRecConstant.CREDITREC_PLUSH);
		crs.setCardInfo(one);
		crs.setBrushMoney(money);
		crs.setBrushDate(new Date());
		creditRecordsService.save(crs);

		// 刷卡操作时候，修改POST的当日还卡金额总
		postInfo.setPostMoney(postInfo.getPostMoney() + money);
		postInfoService.update(postInfo);

		// 获取上一条记录
		// String where =
		// " where o.cardInfo.cardNo = ? and o.dealStates = ? and finshState = ? ";
		// List<Object> params = new ArrayList<Object>();
		// params.add(cardNo);
		// params.add(DealInfoConstant.DEAL_STATES_PLUSH_REPAYMENT);
		// params.add(DealInfoConstant.DEAL_FINSH_NO);
		// List<DealInfo> deals = dealInfoService.getList(where,
		// params.toArray());
		// if(deals.size()>0){
		// DealInfo dealInfo = deals.get(0);
		// dealInfo.setPostMoney(money);
		// dealInfo.setCardInfo(one);
		// dealInfo.setDealStates(DealInfoConstant.DEAL_STATES_PLUSH);
		// dealInfo.setCommitDate(new Date());
		// money = money +dealInfo.getPostMoney();
		// dealInfo.setCheckState(DealInfoConstant.DEAL_CHECK_NO);
		// if(dealInfo.getBankMoney()<money){
		// dealInfo.setFinshState(DealInfoConstant.DEAL_FINSH_YES);
		// }
		// dealInfo.setPostMoney(0d);
		// dealInfo.setAdminInfo(adminInfo);
		// dealInfoService.update(dealInfo);
		//
		// }
		// 生成一条工资记录
		DealInfo dealInfo = new DealInfo();
		dealInfo.setBankMoney(0d);
		dealInfo.setCardInfo(one);
		dealInfo.setDealStates(DealInfoConstant.DEAL_STATES_PLUSH);
		dealInfo.setCommitDate(new Date());
		dealInfo.setNeedMoney(money);
		dealInfo.setCheckState(DealInfoConstant.DEAL_CHECK_NO);
		dealInfo.setFinshState(DealInfoConstant.DEAL_FINSH_YES);
		dealInfo.setPostMoney(money);
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

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<PostInfo> getPostList() {
		return postList;
	}

	public void setPostList(List<PostInfo> postList) {
		this.postList = postList;
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
