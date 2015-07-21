/**
 * @功能 
 */

package carss.action.admin.sys;



import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.auth.Admin;
import carss.service.perm.AdminService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")							
@Results( { 
	    @Result(type="redirectAction",location = "admin-list"),
	    @Result(name="input",location = "admin-update.jsp")
})
public class AdminUpdateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private AdminService adminService;
	

	private Integer id;
	private String loginName;							//投资商编号
	
	private String password;							//一级密码
 
	
	private String title;								//显示名称
	private String personName;							//真实姓名
	private String tel;									//联系电话


	/**
	 * @功能 
	 */
	public String show()  {
		
		Admin admin=adminService.get(id);
		this.loginName=admin.getLoginName(); 
		if(!admin.getPassword().equals(this.password)){
			admin.setPassword(this.password);
		}
		 	 
		this.personName=admin.getPersonName();
		this.tel=admin.getTel();
		
		return INPUT;

	}
	
	/**
	 * @功能 
	 */
	public String execute() {

		Admin admin=adminService.get(id);
	 
		if(!admin.getPassword().equals(this.password)){
			admin.setPassword(this.password);
		}
		 	
		
	 
		admin.setPersonName(this.personName);
		admin.setTel(this.tel);
		
		adminService.update(admin);
		
		return SUCCESS;

	}
	
	/**
	 * @功能 
	 */
	public void validate() {
		
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	
	

	
	
}
