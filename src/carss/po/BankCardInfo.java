package carss.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BankCardInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bank_card_info")
public class BankCardInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer adminId;
	private String bankNo;
	private String bankTitle;
	private String bankCardNo;
	private Double bankMoney;
 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "admin_id")
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "bank_no", length = 20)
	public String getBankNo() {
		return this.bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	@Column(name = "bank_title", length = 50)
	public String getBankTitle() {
		return this.bankTitle;
	}

	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}

	@Column(name = "bank_card_no", length = 50)
	public String getBankCardNo() {
		return this.bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public Double getBankMoney() {
		return bankMoney;
	}

	public void setBankMoney(Double bankMoney) {
		this.bankMoney = bankMoney;
	}
	
	

}