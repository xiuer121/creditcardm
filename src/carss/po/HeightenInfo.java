package carss.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import carss.po.auth.Admin;

/**
 * HeightenInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "heighten_info")
public class HeightenInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Admin adminInfo;
	private CardInfo cardInfo;
	private Double currentCredits;
	private Double heightenCredits;
	private String cardNo;
	private String cardBank;
	private String personName;
	private String idNo;
	private String phone;
	private String tel;
	private Integer enoughStates;
	private Double allPoint;
	private Double companyPoint;
	private Double staffPoint;
	private Double balance;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	public Admin getAdminInfo() {
		return adminInfo;
	}

	public void setAdminInfo(Admin adminInfo) {
		this.adminInfo = adminInfo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "card_info_id")
	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	} 

	@Column(name = "current_credits", precision = 22, scale = 0)
	public Double getCurrentCredits() {
		return this.currentCredits;
	}

	public void setCurrentCredits(Double currentCredits) {
		this.currentCredits = currentCredits;
	}

	@Column(name = "heighten_credits", precision = 22, scale = 0)
	public Double getHeightenCredits() {
		return this.heightenCredits;
	}

	public void setHeightenCredits(Double heightenCredits) {
		this.heightenCredits = heightenCredits;
	}

	@Column(name = "card_no", length = 20)
	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name = "card_bank", length = 20)
	public String getCardBank() {
		return this.cardBank;
	}

	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}

	@Column(name = "person_name", length = 20)
	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Column(name = "id_no", length = 20)
	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "enough_states")
	public Integer getEnoughStates() {
		return this.enoughStates;
	}

	public void setEnoughStates(Integer enoughStates) {
		this.enoughStates = enoughStates;
	}

	@Column(name = "all_point", precision = 22, scale = 0)
	public Double getAllPoint() {
		return this.allPoint;
	}

	public void setAllPoint(Double allPoint) {
		this.allPoint = allPoint;
	}

	@Column(name = "company_point", precision = 22, scale = 0)
	public Double getCompanyPoint() {
		return this.companyPoint;
	}

	public void setCompanyPoint(Double companyPoint) {
		this.companyPoint = companyPoint;
	}

	@Column(name = "staff_point", precision = 22, scale = 0)
	public Double getStaffPoint() {
		return this.staffPoint;
	}

	public void setStaffPoint(Double staffPoint) {
		this.staffPoint = staffPoint;
	}

	@Column(name = "balance", precision = 22, scale = 0)
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
}