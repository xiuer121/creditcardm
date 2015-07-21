/**
 * @���� Ͷ�����б�
 */

package carss.action.admin.member;




import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.Member;
import carss.service.MemberService;
import carss.vo.LoginMember;
import carss.vo.View;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")							
@Results( { 
	    @Result(location = "person-list.jsp"),
	    @Result(name="show",type="redirectAction",location = "../../member/application-member"),
})
public class PersonListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource 
	private MemberService memberService;
	
	 
	
	
	private Integer id;
	private View<Member> view=new View<Member>();
	
	private String loginName="";			//��¼��
	private String personName="";			//��ʵ����
	private String recommend="";			//�Ƽ���
	private String father="";				//�ӵ���
	private Integer type;					//�ȼ���ѯ
	
	

	/**
	 * @���� 
	 */
	public String show(){	
		

		Member one=memberService.get(this.id);
		//��õ�¼��Ϣ
		LoginMember loginMember=new LoginMember(one);
		
		//�ѵ�¼��Ϣ���浽SESSION��������
		ActionContext.getContext().getSession().put("loginMember", loginMember);
		
		return "show";
	}
	
	/**
	 * @���� ���ע���Ա�б�
	 */
	public String execute(){	
	
		List<Object> queryList=new ArrayList<Object>();
		String where=" where o.accountActive=true and o.loginName like ? and  o.personName like ?";		
		queryList.add("%"+this.loginName+"%");
		queryList.add("%"+this.personName+"%");
		 
	
		where=where+" order by o.activeDate  desc";
		view=memberService.getView(where,view,queryList.toArray());
		
		return SUCCESS;
	}
	

	public View<Member> getView() {
		return view;
	}
	public void setView(View<Member> view) {
		this.view = view;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}


	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	
	
}
