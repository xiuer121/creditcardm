/**
 * @功能 激活投资商
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
	
	private String activeLoginName;						//确认投资商编号
	private String myTwoPassword;						//二级密码
	
	/**
	 * @功能 获得对象
	 */
	public String show()  {
		
		one=memberService.get(this.id);
		
		return INPUT;
	}
	
	/**
	 * @功能 激活投资商
	 */
	public String active() {
		
		//激活投资商
		Member one=memberService.get(this.id);
		
		one.setActiveDate(new Date());				//激活日期
		one.setAccountActive(true);
		memberService.update(one);
		return SUCCESS;

	}
	
	/**
	 * @功能 激活投资商校验
	 */
	public void validateActive() {
		
		//获得要激活投资商的信息
		Member one=memberService.get(this.id);
		
		//判断激活投资商编号是否正确
		if(!one.getLoginName().equals(this.activeLoginName)){
			this.addActionError("投资商编号填写不正确，请再次确认！");
		}
		
		//判断自己是否激活
		if(one.getAccountActive()){
			this.addActionError("该投资商已激活！");
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
