package carss.vo;





import java.util.Date;




import org.apache.struts2.ServletActionContext;

import carss.po.auth.Admin;








public class LoginAdmin {

	private Integer id;						//����
	
	private Boolean accountUse;				//�ʺ�״̬
	
	private String loginName;				//��¼��
	private String password;				//һ������ 
 
	
 
	
	private String personName;				//��ʵ����
	private String tel;						//��ϵ�绰
	private String remark;					//��ע
	
	private Date loginTime;					//��½ʱ��
	private String loginIp;					//��½IP
 

	public LoginAdmin(Admin one){
		
		this.id=one.getId();
		
		this.accountUse=one.getAccountUse();
		
		this.loginName=one.getLoginName();
		this.password=one.getPassword();  
		
		this.personName=one.getPersonName();
		this.tel=one.getTel();
		this.remark=one.getRemark();
		
		this.loginTime=new Date();
		
		String loginIp=ServletActionContext.getRequest().getRemoteHost();
		this.loginIp=loginIp;
	
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getAccountUse() {
		return accountUse;
	}

	public void setAccountUse(Boolean accountUse) {
		this.accountUse = accountUse;
	}

 

	
	
}
