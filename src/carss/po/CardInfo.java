package carss.po;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import carss.po.auth.Admin;

/**
 * CardInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "card_info")
public class CardInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String personName;
	private String cardNo;
	private String idNo;
	private String phone;
	private Double credits;
	private Double money;
	private Double rates;
	private Integer cardType; // 10代还，20套现，30提额
	private Integer repaymentStates;
	private String cardBank;
	private Integer cardStates;
	private Date repaymentDate;
	private Date entrustDate;
	private Boolean stayStates;
	private Admin admin;

	private String cardPassword;
	private String queryPassword;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "person_name", length = 20)
	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Column(name = "card_no", length = 20)
	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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

	@Column(name = "credits", precision = 22, scale = 0)
	public Double getCredits() {
		return this.credits;
	}

	public void setCredits(Double credits) {
		this.credits = credits;
	}

	@Column(name = "card_type")
	public Integer getCardType() {
		return this.cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	@Column(name = "repayment_states")
	public Integer getRepaymentStates() {
		return this.repaymentStates;
	}

	public void setRepaymentStates(Integer repaymentStates) {
		this.repaymentStates = repaymentStates;
	}

	@Column(name = "card_bank", length = 20)
	public String getCardBank() {
		return this.cardBank;
	}

	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}

	@Column(name = "repayment_date", length = 19)
	public Date getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	@Column(name = "entrust_date", length = 19)
	public Date getEntrustDate() {
		return this.entrustDate;
	}

	public void setEntrustDate(Date entrustDate) {
		this.entrustDate = entrustDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getCardStates() {
		return cardStates;
	}

	public void setCardStates(Integer cardStates) {
		this.cardStates = cardStates;
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