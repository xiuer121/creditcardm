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

/**
 * BankCardInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bank_repayment_day")
public class BankRepaymentDay implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String dateTitle;
	private BankCardInfo bankInfo;
	private Double moneyDay;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
 
	
	public String getDateTitle() {
		return dateTitle;
	}

	public void setDateTitle(String dateTitle) {
		this.dateTitle = dateTitle;
	}

	public Double getMoneyDay() {
		return moneyDay;
	}

	public void setMoneyDay(Double moneyDay) {
		this.moneyDay = moneyDay;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "bank_card_id")
	public BankCardInfo getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(BankCardInfo bankInfo) {
		this.bankInfo = bankInfo;
	}

	
	
}