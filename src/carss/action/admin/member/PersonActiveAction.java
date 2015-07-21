/**
 * @���� ����Ͷ����
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
@Results( { 
	    @Result(type="redirectAction",location = "person-active-no"),
	    @Result(name="input",location = "person-active.jsp")
})
public class PersonActiveAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource 
	private MemberService memberService;

	private Integer id;
	private Member one=new Member();
	
	private String activeLoginName;						//ȷ��Ͷ���̱��
	private String myTwoPassword;						//��������
	
	/**
	 * @���� ��ö���
	 */
	public String show()  {
		
		one=memberService.get(this.id);
		
		return INPUT;
	}
	
	/**
	 * @���� ����Ͷ����
	 */
	public String active() {
		
		//����Ͷ����
		Member one=memberService.get(this.id);
		
		one.setActiveDate(new Date());				//��������
		one.setAccountActive(true);
		memberService.update(one);
		return SUCCESS;

	}
	
	/**
	 * @���� ����Ͷ����У��
	 */
	public void validateActive() {
		
		//���Ҫ����Ͷ���̵���Ϣ
		Member one=memberService.get(this.id);
		
		//�жϼ���Ͷ���̱���Ƿ���ȷ
		if(!one.getLoginName().equals(this.activeLoginName)){
			this.addActionError("Ͷ���̱����д����ȷ�����ٴ�ȷ�ϣ�");
		}
		
		//�ж��Լ��Ƿ񼤻�
		if(one.getAccountActive()){
			this.addActionError("��Ͷ�����Ѽ��");
		}
		
		 
		 
		
		if(this.hasErrors()){
			this.show();
		}

		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getActiveLoginName() {
		return activeLoginName;
	}
	public void setActiveLoginName(String activeLoginName) {
		this.activeLoginName = activeLoginName;
	}

	public String getMyTwoPassword() {
		return myTwoPassword;
	}
	public void setMyTwoPassword(String myTwoPassword) {
		this.myTwoPassword = myTwoPassword;
	}

	public Member getOne() {
		return one;
	}
	public void setOne(Member one) {
		this.one = one;
	}

	
}
