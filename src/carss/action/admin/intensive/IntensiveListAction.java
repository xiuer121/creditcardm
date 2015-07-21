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

import carss.po.CardInfo;
import carss.service.CardInfoService;
import carss.vo.View;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(location = "intensive-list.jsp") })
public class IntensiveListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;

	private Integer id;
	private Integer[] ids;

	private View<CardInfo> view = new View<CardInfo>();

	private String personName; // 姓名
	private String cardNo; // 卡号
	private String idNo; // 身份证号
	private String phone; // 手机号
 

	/**
	 * @功能
	 */
	public String execute() {

		String where = " where  1 = 1 and cardType = 10 ";
		List<Object> parmas = new ArrayList<Object>();
		if (personName != null && personName.length() > 0) {
			where = where + " and o .personName like  ? ";
			parmas.add("%" + personName + "%");
		}
		if (cardNo != null && cardNo.length() > 0) {
			where = where + " and o .cardNo like ? ";
			parmas.add("%" + cardNo + "%");
		}
		if (idNo != null && idNo.length() > 0) {
			where = where + " and o .idNo like ? ";
			parmas.add("%" + idNo + "%");
		}
		if (phone != null && phone.length() > 0) {
			where = where + " and (o .phone like ? or o.tel like ?) ";
			parmas.add("%" + phone + "%");
			parmas.add("%" + phone + "%");
		} 
 

		view = cardInfoService.getView(where, view, parmas.toArray());
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public View<CardInfo> getView() {
		return view;
	}

	public void setView(View<CardInfo> view) {
		this.view = view;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
 
	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

}
