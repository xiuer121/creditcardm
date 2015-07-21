/**
 * @功能 投资商列表
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
	
	private String loginName="";			//登录名
	private String personName="";			//真实姓名
	private String recommend="";			//推荐人
	private String father="";				//接点人
	private Integer type;					//等级查询
	
	

	/**
	 * @功能 
	 */
	public String show(){	
		

		Member one=memberService.get(this.id);
		//获得登录信息
		LoginMember loginMember=new LoginMember(one);
		
		//把登录信息保存到SESSION作用域中
		ActionContext.getContext().getSession().put("loginMember", loginMember);
		
		return "show";
	}
	
	/**
	 * @功能 获得注册会员列表
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
