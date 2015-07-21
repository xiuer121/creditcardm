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
@Results({ @Result(type = "redirectAction", location = "admin-list"),
		@Result(name = "input", location = "admin-add.jsp") })
public class AdminAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private AdminService adminService;

	private String loginName; // 投资商编号

	private String password; // 一级密码
	private String twoPassword; // 二级密码
	private String passwordRec; // 一级确认密码
	private String twoPasswordRec; // 二级确认密码

	private String title; // 显示名称
	private String personName; // 真实姓名
	private String tel; // 联系电话


	/**
	 * @功能 新增管理员
	 */
	public String execute() throws Exception {

		Admin admin = new Admin();

		admin.setAccountUse(true); // 帐号状态

		admin.setLoginNum(0); // 登录次数

		admin.setErrorNum(0); // 密码错误次数

		admin.setLoginName(this.loginName); // 登录名

		admin.setPassword(this.password); // 一级密码

		admin.setPersonName(this.personName); // 真实姓名
		admin.setTel(this.tel); // 联系电话
		// admin.setEmail(this.email);
		
		
		admin.setMoney(0d);

		adminService.save(admin);

		return SUCCESS;

	}

	/**
	 * @功能
	 */
	public void validate() {

		// 一级密码是否填写
		if (this.password == null || this.password.length() < 1) {
			this.addFieldError("onePassword", "一级密码未填写！");
		} else {

			// 确认密码是否填写
			if (this.passwordRec == null || this.passwordRec.length() < 1) {
				this.addFieldError("passwordRec", "确认密码未填写！");
			}

			// 两次密码是否一致
			if (!this.password.equals(this.passwordRec)) {
				this.addFieldError("password", "两次密码不一致！");
			}
		}

		// 新增投资商的登錄名是否填写
		if (this.loginName == null || this.loginName.length() < 1) {
			this.addFieldError("loginName", "登录名未填写！");
		}
 

		// 新增投资商的登錄名是否有重復
		Admin admin = adminService.getByLoginName(this.loginName);
		if (admin != null) {
			this.addFieldError("loginName", "该登录名已存在！");
		}

	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getTwoPassword() {
		return twoPassword;
	}

	public void setTwoPassword(String twoPassword) {
		this.twoPassword = twoPassword;
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

	public String getTwoPasswordRec() {
		return twoPasswordRec;
	}

	public void setTwoPasswordRec(String twoPasswordRec) {
		this.twoPasswordRec = twoPasswordRec;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

 

}
