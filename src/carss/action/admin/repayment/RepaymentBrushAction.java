/**

 * @功能 
 */

package carss.action.admin.repayment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.BankCardInfo;
import carss.po.CardInfo;
import carss.po.CreditRecords;
import carss.po.DealInfo;
import carss.po.PostInfo;
import carss.service.BankCardInfoService;
import carss.service.CardInfoService;
import carss.service.CreditRecordsService;
import carss.service.DealInfoService;
import carss.service.PostInfoService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(type = "json") })
public class RepaymentBrushAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CreditRecordsService creditRecordsService;

	@Resource
	private BankCardInfoService bankCardInfoService;

	@Resource
	private PostInfoService postInfoService;

	@Resource
	private CardInfoService cardInfoService;

	@Resource
	private DealInfoService dealInfoService;

	private String brushType;

	private Integer id;
	private Integer bankId;
	private Integer postId;

	private String smallTicketNo;
	private Double brushMoney;

	private String brushDate;

	private BankCardInfo bankCardInfo;
	private PostInfo postInfo;
	private CardInfo cardInfo;

	private String postTitle = "";

	private String bankTitle = "";

	private Boolean result = true;

	private String message = "";

	/**
	 * @功能
	 */
	public String execute() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		CreditRecords o = new CreditRecords();
		cardInfo = cardInfoService.get(id);
		o.setCardInfo(cardInfo);
		Integer intType = Integer.parseInt(brushType);
		// 获取交易操作的条件
		String where = " where o.cardInfo.id = ? and o.dealStates = ? and finshState = ? ";
		List<Object> params = new ArrayList<Object>();
		params.add(cardInfo.getId());
		params.add(10);
		params.add(10);
		List<DealInfo> deals = dealInfoService.getList(where, params.toArray());

	 
		// 操作类型 10 刷出用post 20存入用银行卡
		if (brushType != null && brushType.length() > 0) {
			if (intType == 10) {
				postInfo = postInfoService.get(postId);
				o.setPostInfo(postInfo);
				postTitle = postInfo.getPostNo() + "--"
						+ postInfo.getPostTitle();
				// 刷出操作。如果存入金额没达到代还金额不允许做刷出操作
				if (deals.size() == 1) {
					DealInfo dealInfo = deals.get(0);
					Double postMoney = dealInfo.getPostMoney();// 之前取出金额
					Double bankMoney = dealInfo.getBankMoney(); // 获取存入金额
					Double andMoney = postMoney + brushMoney; //

					dealInfo.setPostMoney(andMoney);
					if (postMoney > bankMoney) {
						dealInfo.setFinshState(20);
					}
					postInfo.setPostMoney(postInfo.getPostMoney() + brushMoney);
					postInfoService.update(postInfo);
					dealInfoService.update(dealInfo);

				} else {
					result = false;
					message = "请先进行还款操作再做刷卡操作！";
				}

			}
			if (intType == 20) {
				bankCardInfo = bankCardInfoService.get(bankId);
				o.setBankInfo(bankCardInfo);
				bankTitle = bankCardInfo.getBankNo() + "--"
						+ bankCardInfo.getBankTitle();

				// 获取需要代还金额，获取之前的存入金额。判断是否超出需要代还金额如果操作不可以操作
				if (deals.size() == 1) {
					DealInfo dealInfo = deals.get(0);
					Double bankMoney = dealInfo.getBankMoney();// 之前存入金额
					Double needMoney = dealInfo.getNeedMoney();// 需要代还金额
					Double andMoney = bankMoney + brushMoney; //
					if (andMoney <= needMoney) {
						dealInfo.setBankMoney(andMoney);
						dealInfoService.update(dealInfo);
					} else {
						result = false;
						message = "存入金额不能大于代还金额！";

					}

				} else {
					if (brushMoney <= cardInfo.getMoney()) {
						DealInfo dealInfo = new DealInfo();
						dealInfo.setBankMoney(brushMoney);
						dealInfo.setCardInfo(cardInfo);
						dealInfo.setDealStates(10);
						dealInfo.setCommitDate(new Date());
						dealInfo.setNeedMoney(cardInfo.getMoney());
						dealInfo.setCheckState(10);
						dealInfo.setFinshState(10);
						dealInfo.setPostMoney(0d);
						dealInfo.setAdminInfo(cardInfo.getAdmin());
						dealInfoService.save(dealInfo);
					} else {
						result = false;
						message = "存入金额不能大于代还金额！";

					}

				}

			}
			o.setBrushType(intType);
		} else {
			message = "添加记录失败！";
			result = false;

		}
		o.setSmallTicketNo(smallTicketNo);
		if (brushDate != null && brushDate.length() > 0) {
			o.setBrushDate(sdf.parse(brushDate));
		} else {
			message = "添加记录失败！";
			result = false;
		}
		o.setBrushMoney(brushMoney);

		if (result) {
			o.setEntryDate(new Date());
			creditRecordsService.save(o);
			message = "添加记录成功！";
		}

		return SUCCESS;
	}

	public void setBrushMoney(Double brushMoney) {
		this.brushMoney = brushMoney;
	}

	public void setBrushType(String brushType) {
		this.brushType = brushType;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public void setBrushDate(String brushDate) {
		this.brushDate = brushDate;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBrushType() {
		return brushType;
	}

	public String getSmallTicketNo() {
		return smallTicketNo;
	}

	public Double getBrushMoney() {
		return brushMoney;
	}

	public String getBrushDate() {
		return brushDate;
	}

	public Boolean getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public void setSmallTicketNo(String smallTicketNo) {
		this.smallTicketNo = smallTicketNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getBankTitle() {
		return bankTitle;
	}

	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}

}
