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
@Results({ @Result(type = "redirectAction", location = "repayment-list"),
		@Result(name = "input", location = "repayment-update.jsp") })
public class RepaymentUpdateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;
	
	@Resource
	private PostInfoService postInfoService;


	@Resource
	private CreditRecordsService creditRecordsService;

	

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
	
	private CardInfo one = new CardInfo();
	private List<PostInfo> postList = new ArrayList<PostInfo>();
	
	
	
	private Integer postId;
	private Integer selects;

	/**
	 * @功能
	 */
	public String execute() {
		
		

		LoginAdmin loginAdmin = (LoginAdmin) ActionContext.getContext()
				.getSession().get("loginAdmin");
 

		Admin adminInfo = adminService.get(loginAdmin.getId());
		
		
		one = cardInfoService.get(id); 
		
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
		
		
		 //获取上一条记录
		 String where = " where o.cardInfo.cardNo = ? and o.dealStates = ? and finshState = ? ";
		 List<Object> params = new ArrayList<Object>();
		 params.add(one.getCardNo());
		 params.add(DealInfoConstant.DEAL_STATES_PLUSH_REPAYMENT);
		 params.add(DealInfoConstant.DEAL_FINSH_NO);
		 List<DealInfo> deals = dealInfoService.getList(where,
		 params.toArray());
		 if(deals.size()>0){
		 DealInfo dealInfo = deals.get(0);
		
		 dealInfo.setCardInfo(one);

		 dealInfo.setCommitDate(new Date());
		 money = money +dealInfo.getPostMoney(); 
		 dealInfo.setPostMoney(money);
		 dealInfo.setCheckState(DealInfoConstant.DEAL_CHECK_NO);
		 if(dealInfo.getBankMoney()<money){
		//完成刷卡操作。进行返点。	  
		 dealInfo.setMoney(dealInfo.getBankMoney()*one.getRates()*adminInfo.getPoint());	 
		 dealInfo.setDealStates(DealInfoConstant.DEAL_STATES_PLUSH);
		 dealInfo.setFinshState(DealInfoConstant.DEAL_FINSH_YES);
		 } 
		 dealInfo.setAdminInfo(adminInfo);
		 dealInfoService.update(dealInfo);
		
		 }
		
		
		
		
		return SUCCESS;
	}

	public String show() {
		String where ="order by o.postMaxMoney - postMoney desc";
		postList = postInfoService.getList(where,null);
		
		one = cardInfoService.get(id);
		personName = one.getPersonName();
		idNo = one.getIdNo();
		phone = one.getPhone();

		cardNo = one.getCardNo();
		cardBank = one.getCardBank();
		credits = one.getCredits();
	 
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

	public List<PostInfo> getPostList() {
		return postList;
	}

	public void setPostList(List<PostInfo> postList) {
		this.postList = postList;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	
	

}
