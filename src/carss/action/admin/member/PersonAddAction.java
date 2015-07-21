/**
 * @���� ע��Ͷ����
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

	private String loginName; // �û���
	private String password; // һ������
	private String passwordRec; // һ��ȷ������

	private String personName = ""; // ��ʵ����
	private String cardNo; // ���֤��
	private String sex; // �Ա�

	private String tel; // ��ϵ�绰
	private String qq; // QQ����
	private String email; // �����ʼ�

	public String show() {
		return INPUT;
	}

	/**
	 * @���� ����Ͷ����
	 */
	public String add() {

		// ������
		Member member = new Member();

		member.setLoginName(this.loginName); // ��¼��

		member.setPassword(this.password); // һ������

		member.setPersonName(this.personName); // ��ʵ����
		member.setCardNo(this.cardNo); // ���֤��
		member.setSex(this.sex); // �Ա�
		member.setTel(this.tel); // ��ϵ�绰
		member.setQq(this.qq); // QQ����
		member.setEmail(this.email); // �����ʼ�
		member.setAccountActive(true);
		member.setRegisterDate(new Date());
		memberService.save(member);

		return SUCCESS;

	}

	/**
	 * @���� ����Ͷ����У��
	 */
	public void validateAdd() {

		// һ�������Ƿ���д
		if (this.password == null || this.password.length() < 1) {
			this.addFieldError("password", "һ������δ��д��");
		} else {

			// ȷ�������Ƿ���д
			if (this.passwordRec == null || this.passwordRec.length() < 1) {
				this.addFieldError("onePassword", "ȷ������δ��д��");
			}

			// ���������Ƿ�һ��
			if (!this.password.equals(this.passwordRec)) {
				this.addFieldError("onePassword", "�������벻һ�£�");
			}
		}

		// ����
		if (this.personName == null || this.personName.length() < 1) {
			this.addFieldError("personName", "����δ��д��");
		}
		// �绰
		if (this.tel == null || this.tel.length() < 1) {
			this.addFieldError("tel", "�绰δ��д��");
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
