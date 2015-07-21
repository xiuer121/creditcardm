/**
 * @���� 
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
	
	private String password;							//һ������ 
	private String passwordRec;						//һ��ȷ������
 
	
	private Boolean result=false;
	
	/**
	 * @���� 
	 */
	public String show() {

//		LoginAdmin loginAdmin=(LoginAdmin)ActionContext.getContext().getSession().get("loginAdmin");
//		Admin one = adminService.get(loginAdmin.getId());

		return SUCCESS;

	}
	
	/**
	 * @���� 
	 */
	public String update() {

		//��õ�¼����
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
	 * @���� 
	 */
	public void validateUpdate() {
		
		//��õ�¼����
//		LoginAdmin loginAdmin=(LoginAdmin)ActionContext.getContext().getSession().get("loginAdmin");
//		Admin one = adminService.get(loginAdmin.getId());
		
		//һ�������Ƿ���д
		if(this.password==null||this.password.length()<1){
			this.addFieldError("password","������δ��д��");
		}else{
			
			//ȷ�������Ƿ���д
			if(this.passwordRec==null||this.passwordRec.length()<1){
				this.addFieldError("onePassword","ȷ������δ��д��");
			}
			
			//���������Ƿ�һ��
			if(!this.password.equals(this.passwordRec)){
				this.addFieldError("onePassword","�������벻һ�£�");
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
