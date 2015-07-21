/**
 * @功能 
 */

package carss.action.admin.info;




import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.auth.Admin;
import carss.service.perm.AdminService;
import carss.vo.LoginAdmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")							
@Results( { 
		@Result(location = "update-pwd.jsp"),
	    @Result(name="input",location = "update-pwd.jsp")
})
public class UpdatePwdAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private AdminService adminService;
	
	private String password;							//一级密码 
	private String passwordRec;						//一级确认密码
 
	
	private Boolean result=false;
	
	/**
	 * @功能 
	 */
	public String show() {

//		LoginAdmin loginAdmin=(LoginAdmin)ActionContext.getContext().getSession().get("loginAdmin");
//		Admin one = adminService.get(loginAdmin.getId());

		return SUCCESS;

	}
	
	/**
	 * @功能 
	 */
	public String update() {

		//获得登录资料
		LoginAdmin loginAdmin=(LoginAdmin)ActionContext.getContext().getSession().get("loginAdmin");
		Admin one = adminService.get(loginAdmin.getId());

 
		one.setPassword(password);
	 
		adminService.update(one);
		
		loginAdmin.setPassword(password); 
		
		
		ActionContext.getContext().getSession().put("loginAdmin", loginAdmin);

		result=true;

		return SUCCESS;
	}
	
	/**
	 * @功能 
	 */
	public void validateUpdate() {
		
		//获得登录资料
//		LoginAdmin loginAdmin=(LoginAdmin)ActionContext.getContext().getSession().get("loginAdmin");
//		Admin one = adminService.get(loginAdmin.getId());
		
		//一级密码是否填写
		if(this.password==null||this.password.length()<1){
			this.addFieldError("password","级密码未填写！");
		}else{
			
			//确认密码是否填写
			if(this.passwordRec==null||this.passwordRec.length()<1){
				this.addFieldError("onePassword","确认密码未填写！");
			}
			
			//两次密码是否一致
			if(!this.password.equals(this.passwordRec)){
				this.addFieldError("onePassword","两次密码不一致！");
			}
		}
		
		 
		
		if(this.hasErrors()){
			this.show();
		}

	}

	 
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRec() {
		return passwordRec;
	}

	public void setPasswordRec(String passwordRec) {
		this.passwordRec = passwordRec;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	
	
	
}
