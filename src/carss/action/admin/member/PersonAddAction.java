/**
 * @功能 注册投资商
 */

package carss.action.admin.member;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.Member;
import carss.service.MemberService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(type = "redirectAction", location = "person-add-success"),
		@Result(name = "input", location = "person-add.jsp") })
public class PersonAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private MemberService memberService;

	private String loginName; // 用户名
	private String password; // 一级密码
	private String passwordRec; // 一级确认密码

	private String personName = ""; // 真实姓名
	private String cardNo; // 身份证号
	private String sex; // 性别

	private String tel; // 联系电话
	private String qq; // QQ号码
	private String email; // 电子邮件

	public String show() {
		return INPUT;
	}

	/**
	 * @功能 新增投资商
	 */
	public String add() {

		// 经纪人
		Member member = new Member();

		member.setLoginName(this.loginName); // 登录名

		member.setPassword(this.password); // 一级密码

		member.setPersonName(this.personName); // 真实姓名
		member.setCardNo(this.cardNo); // 身份证号
		member.setSex(this.sex); // 性别
		member.setTel(this.tel); // 联系电话
		member.setQq(this.qq); // QQ号码
		member.setEmail(this.email); // 电子邮件
		member.setAccountActive(true);
		member.setRegisterDate(new Date());
		memberService.save(member);

		return SUCCESS;

	}

	/**
	 * @功能 新增投资商校验
	 */
	public void validateAdd() {

		// 一级密码是否填写
		if (this.password == null || this.password.length() < 1) {
			this.addFieldError("password", "一级密码未填写！");
		} else {

			// 确认密码是否填写
			if (this.passwordRec == null || this.passwordRec.length() < 1) {
				this.addFieldError("onePassword", "确认密码未填写！");
			}

			// 两次密码是否一致
			if (!this.password.equals(this.passwordRec)) {
				this.addFieldError("onePassword", "两次密码不一致！");
			}
		}

		// 姓名
		if (this.personName == null || this.personName.length() < 1) {
			this.addFieldError("personName", "姓名未填写！");
		}
		// 电话
		if (this.tel == null || this.tel.length() < 1) {
			this.addFieldError("tel", "电话未填写！");
		}

		if (this.hasErrors()) {
			this.show();
		}
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
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

	public String getPasswordRec() {
		return passwordRec;
	}

	public void setPasswordRec(String passwordRec) {
		this.passwordRec = passwordRec;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
