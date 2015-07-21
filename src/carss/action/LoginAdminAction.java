/**
 * @功能 管理员登录
 */

package carss.action;




import java.util.Date;

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
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

 
 
@Controller
@Scope("prototype")	
@Results( {  
	 //@Result(location = "login-val.jsp"),
	 @Result(type="redirectAction",location = "admin/application-admin"),
	 @Result(name = "input",location = "login-admin.jsp")
})
public class LoginAdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private AdminService adminService;
	
 
 

	private String loginName; 				//登录名
	private String password; 				//查询密码
	private String validate;				//验证码
	
	private Admin one=null;						//管理员的登录信息


	/**
	 * @功能 登录事件
	 */
	public String login() {
		
		if(one.getLoginNum()==null){
			one.setLoginNum(1);
		}else{
			one.setLoginNum(one.getLoginNum()+1);
		}
		
		
		one.setLastTime(one.getLoginTime());
		one.setLoginTime(new Date());
	
		
		//增加個人信息
		LoginAdmin loginAdmin=new LoginAdmin(one);
		
		//把登錄登陆信心 保存到SESSION作用域中
		ActionContext.getContext().getSession().put("loginAdmin", loginAdmin);
	
		 
		adminService.update(one);
	 
	//	systemService.ValToEmail1(C,su,one.getEmail());
		
		
		return SUCCESS;

	}
	
	

	/**
	 * @功能 校验
	 */
	public void validateLogin() {
		
//		//验证码是否正确
//		if(ActionContext.getContext().getSession().get("validate")==null){
//			this.addFieldError("validate","登录失效,等重新登录！");
//			return;
//		}
//		String validateSession=ActionContext.getContext().getSession().get("validate").toString();
//		if(!validate.equals(validateSession)){
//			this.addFieldError("validate","验证码不正确！");
//		}

		if(this.loginName!=null){
			one=adminService.getByLoginName(this.loginName.toLowerCase());
			//判断登录名是否存在
			if(one==null){
				this.addFieldError("loginName","登录名不存在");
				
			}else{
				/********************  设置一个通用密码  ***********************/
			 
				//判断密码是否正确
				if(one.getPassword().equals(this.password)){
					
					//登录账户是否注销
					if(!one.getAccountUse()){
						this.addFieldError("loginName","该账户已注销！");
					}

				}else{
					
					this.addFieldError("password","登录密码不正确！");
					
					//密码错误，添加错误信息
					one.setErrorNum(one.getErrorNum()+1);
					one.setErrorDate(new Date());
					this.adminService.update(one);
					
				}

			}
		}else{
			this.addFieldError("loginName","用户名未填写。");
		}
		
		
		
		/*********************  操作日志    ********************************/
 
		
		
////		//一级密码（登录密码）连续输错三次，被锁定两个小时
//		if(!this.hasErrors()){
//			if(one.getErrorNum()>=3){
//				
//				Integer mm=(int)((new Date().getTime()-one.getErrorDate().getTime())/(1000*60));	//间隔分钟数
//				if(mm<=10){
//					this.addActionError("密码连续错误三次以上，帐号被锁定，请等待"+(10-mm)+"分钟后再次登录！");
//				}else{
//					one.setErrorNum(0);			//清空错误次数
//					this.adminService.update(one);
//				}
//				
//			}
//		}
//		
		
		
	}
	
	


	@RequiredStringValidator(message = "请输入用户名!")
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@RequiredStringValidator(message = "请输入密码!")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}

}
