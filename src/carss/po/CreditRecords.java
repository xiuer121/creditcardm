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

/**
 * CreditRecords entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "credit_records")
public class CreditRecords implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8095674835658655048L;
	private Integer id;
	private CardInfo cardInfo;
	private PostInfo postInfo;
	private BankCardInfo bankInfo;
	private String smallTicketNo;
	private Date brushDate;
	private Double brushMoney;
	private Integer brushType;   //10´æÈë 20Ë¢³ö
	private Date entryDate;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "card_info_id")
	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	} 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "post_id")
	public PostInfo getPostInfo() {
		return postInfo;
	}

	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
	} 
	 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "bank_id")
	public BankCardInfo getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(BankCardInfo bankInfo) {
		this.bankInfo = bankInfo;
	}

 
 

	@Column(name = "small_ticket_no", length = 50)
	public String getSmallTicketNo() {
		return this.smallTicketNo;
	}

	public void setSmallTicketNo(String smallTicketNo) {
		this.smallTicketNo = smallTicketNo;
	}

	@Column(name = "brush_money", precision = 22, scale = 0)
	public Double getBrushMoney() {
		return this.brushMoney;
	}

	public void setBrushMoney(Double brushMoney) {
		this.brushMoney = brushMoney;
	}

	@Column(name = "brush_type")
	public Integer getBrushType() {
		return this.brushType;
	}

	public void setBrushType(Integer brushType) {
		this.brushType = brushType;
	}

	@Column(name = "brush_date", length = 19)
	public Date getBrushDate() {
		return brushDate;
	}

	public void setBrushDate(Date brushDate) {
		this.brushDate = brushDate;
	}

	@Column(name = "entry_date", length = 19)
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getEntryDate() {
		return entryDate;
	}

}