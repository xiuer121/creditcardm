/**
 * @���� Ͷ���̵�¼
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

	private String loginName; // ��¼��
	private String password; // ��ѯ����
	private String validate; // ��֤��

	private String message;
	private Member one; // ��¼��Ͷ������Ϣ

	private String result;

	/**
	 * @���� ��¼�¼�
	 */
	public String execute() {
		System.out.println("loginName:"+loginName);
		if (this.loginName != null && this.loginName.length() > 0) {
			one = memberService.getByLoginName(this.loginName.toLowerCase());
			// �жϵ�¼���Ƿ����
			if (one == null) {
				message = "��¼��������";
			} else {
				/******************** ����һ������ ***********************/

				// �ж������Ƿ���ȷ
				if (one.getPassword().equals(this.password)) {
					// ���ӂ�����Ϣ
					LoginMember loginMember = new LoginMember(one);

					// �ѵ�䛵�½���� ���浽SESSION��������
					ActionContext.getContext().getSession()
							.put("loginMember", loginMember);

					result="1";
				} else {

					message = "��¼���벻��ȷ��";
					// ���������Ӵ�����Ϣ
					one.setErrorNum(one.getErrorNum() + 1);
					one.setErrorDate(new Date());
					this.memberService.update(one);

				}

			}
		} else {
			message = "�������û�����";
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
