package carss.vo;





import java.util.Date;




import org.apache.struts2.ServletActionContext;

import carss.po.auth.Admin;








public class LoginAdmin {

	private Integer id;						//主键
	
	private Boolean accountUse;				//帐号状态
	
	private String loginName;				//登录名
	private String password;				//一级密码 
 
	
 
	
	private String personName;				//真实姓名
	private String tel;						//联系电话
	private String remark;					//备注
	
	private Date loginTime;					//登陆时间
	private String loginIp;					//登陆IP
 

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
