package carss.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PostInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "post_info")
public class PostInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer adminId;
	private String postNo;
	private String postTitle;
	private Double postRates;
	private Double postMoney;
	private Double postMaxMoney;

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

	@Column(name = "post_no", length = 20)
	public String getPostNo() {
		return this.postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	@Column(name = "post_title", length = 50)
	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	@Column(name = "post_rates", precision = 22, scale = 0)
	public Double getPostRates() {
		return this.postRates;
	}

	public void setPostRates(Double postRates) {
		this.postRates = postRates;
	}

	@Column(name = "post_money", precision = 22, scale = 0)
	public Double getPostMoney() {
		return this.postMoney;
	}

	public void setPostMoney(Double postMoney) {
		this.postMoney = postMoney;
	}

	public Double getPostMaxMoney() {
		return postMaxMoney;
	}

	public void setPostMaxMoney(Double postMaxMoney) {
		this.postMaxMoney = postMaxMoney;
	}

}