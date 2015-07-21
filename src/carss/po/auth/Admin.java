/**
 * @���� ����Ա���ϱ�
 */

package carss.po.auth;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
@Table(name = "admin")
public class Admin {

	private static final long serialVersionUID = 1L;

	private Integer id; // ����

	private Boolean accountUse; // �ʺ�״̬

	private Date lastTime; // �ϴε�¼ʱ��
	private Integer loginNum; // ��¼����
	private Date loginTime; // ��¼ʱ��

	private Integer errorNum; // ����������
	private Date errorDate; // �������ʱ��

	private String loginName; // ��¼��
	private String password; // ��ԃ����

	private String personName; // ����
	private String tel; // ��ϵ�绰
	private String remark; // ��ע

	private Double point;
	private Double money;
	
	
	/**
	 * @���� �޲εĹ��캯��
	 */
	public Admin() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "login_name", length = 50)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "person_name", length = 50)
	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Column(name = "tel", length = 50)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "remark", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "account_use")
	public Boolean getAccountUse() {
		return accountUse;
	}

	public void setAccountUse(Boolean accountUse) {
		this.accountUse = accountUse;
	}

	public Integer getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "error_date")
	public Date getErrorDate() {
		return errorDate;
	}

	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_time")
	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "login_time")
	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	

}