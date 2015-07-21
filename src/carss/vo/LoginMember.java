package carss.vo;





import java.util.Date;

import org.apache.struts2.ServletActionContext;

import carss.po.Member;








public class LoginMember {

	private Integer id;						//����
	
	private String loginName;				//��¼��
	private String password;				//һ������
 
	
	private Date lastDate;					//�ϴε�¼ʱ��
	private Integer loginNum;				//��¼����
	
 
	private String personName;				//������
	private Integer level;				
	private Date loginTime;					//��½ʱ��
	private String loginIp;					//��½IP
	private Integer type;				
	public LoginMember(Member one){
		
		this.id=one.getId();
		
		this.loginName=one.getLoginName();
		 
		this.personName=one.getPersonName();
	
		this.level=one.getLevel();
		this.loginTime=new Date();
		this.loginIp=ServletActionContext.getRequest().getRemoteHost();
		
		
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
	 
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Integer getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
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

	 
	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}

	
	

	
	
}
