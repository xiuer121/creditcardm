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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import carss.po.auth.Admin;

/**
 * DealInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "deal_info")
public class WealthInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Admin adminInfo;
	private CardInfo cardInfo;
	private Double bankMoney;
	private Double postMoney;
	private Integer dealStates;
	private Double money;
	private Integer checkState;
	private Admin checkAdminInfo;
	private Date commitDate;
	private Date checkDate;

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
	@Column(name = "bank_money", precision = 22, scale = 0)
	public Double getBankMoney() {
		return this.bankMoney;
	}

	public void setBankMoney(Double bankMoney) {
		this.bankMoney = bankMoney;
	}

	@Column(name = "post_money", precision = 22, scale = 0)
	public Double getPostMoney() {
		return this.postMoney;
	}

	public void setPostMoney(Double postMoney) {
		this.postMoney = postMoney;
	}

	@Column(name = "deal_states")
	public Integer getDealStates() {
		return this.dealStates;
	}

	public void setDealStates(Integer dealStates) {
		this.dealStates = dealStates;
	}

	@Column(name = "money", precision = 22, scale = 0)
	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Column(name = "check_state")
	public Integer getCheckState() {
		return this.checkState;
	}

	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "commit_date", length = 10)
	public Date getCommitDate() {
		return this.commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "check_date", length = 10)
	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "check_admin_id")
	public Admin getCheckAdminInfo() {
		return checkAdminInfo;
	}

	public void setCheckAdminInfo(Admin checkAdminInfo) {
		this.checkAdminInfo = checkAdminInfo;
	}

}