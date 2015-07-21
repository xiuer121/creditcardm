/**
 * @功能 投资商登录
 */

package carss.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.Member;
import carss.service.MemberService;
import carss.vo.LoginMember;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(type = "json") })
public class LoginMemberAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private MemberService memberService;

	private String loginName; // 登录名
	private String password; // 查询密码
	private String validate; // 验证码

	private String message;
	private Member one; // 登录的投资商信息

	private String result;

	/**
	 * @功能 登录事件
	 */
	public String execute() {
		System.out.println("loginName:"+loginName);
		if (this.loginName != null && this.loginName.length() > 0) {
			one = memberService.getByLoginName(this.loginName.toLowerCase());
			// 判断登录名是否存在
			if (one == null) {
				message = "登录名不存在";
			} else {
				/******************** 设置一个密码 ***********************/

				// 判断密码是否正确
				if (one.getPassword().equals(this.password)) {
					// 增加個人信息
					LoginMember loginMember = new LoginMember(one);

					// 把登錄登陆信心 保存到SESSION作用域中
					ActionContext.getContext().getSession()
							.put("loginMember", loginMember);

					result="1";
				} else {

					message = "登录密码不正确！";
					// 密码错误，添加错误信息
					one.setErrorNum(one.getErrorNum() + 1);
					one.setErrorDate(new Date());
					this.memberService.update(one);

				}

			}
		} else {
			message = "请输入用户名！";
		}

		return SUCCESS;

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
