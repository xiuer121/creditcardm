/**
 * @���� 
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

	private String loginName; // Ͷ���̱��

	private String password; // һ������
	private String twoPassword; // ��������
	private String passwordRec; // һ��ȷ������
	private String twoPasswordRec; // ����ȷ������

	private String title; // ��ʾ����
	private String personName; // ��ʵ����
	private String tel; // ��ϵ�绰


	/**
	 * @���� ��������Ա
	 */
	public String execute() throws Exception {

		Admin admin = new Admin();

		admin.setAccountUse(true); // �ʺ�״̬

		admin.setLoginNum(0); // ��¼����

		admin.setErrorNum(0); // ����������

		admin.setLoginName(this.loginName); // ��¼��

		admin.setPassword(this.password); // һ������

		admin.setPersonName(this.personName); // ��ʵ����
		admin.setTel(this.tel); // ��ϵ�绰
		// admin.setEmail(this.email);
		
		
		admin.setMoney(0d);

		adminService.save(admin);

		return SUCCESS;

	}

	/**
	 * @����
	 */
	public void validate() {

		// һ�������Ƿ���д
		if (this.password == null || this.password.length() < 1) {
			this.addFieldError("onePassword", "һ������δ��д��");
		} else {

			// ȷ�������Ƿ���д
			if (this.passwordRec == null || this.passwordRec.length() < 1) {
				this.addFieldError("passwordRec", "ȷ������δ��д��");
			}

			// ���������Ƿ�һ��
			if (!this.password.equals(this.passwordRec)) {
				this.addFieldError("password", "�������벻һ�£�");
			}
		}

		// ����Ͷ���̵ĵ�����Ƿ���д
		if (this.loginName == null || this.loginName.length() < 1) {
			this.addFieldError("loginName", "��¼��δ��д��");
		}
 

		// ����Ͷ���̵ĵ�����Ƿ����؏�
		Admin admin = adminService.getByLoginName(this.loginName);
		if (admin != null) {
			this.addFieldError("loginName", "�õ�¼���Ѵ��ڣ�");
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
