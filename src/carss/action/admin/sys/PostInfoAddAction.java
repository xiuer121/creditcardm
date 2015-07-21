/**
 * @功能 
 */

package carss.action.admin.sys;



import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.PostInfo;
import carss.service.PostInfoService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")							
@Results( { 
	    @Result(type="redirectAction",location = "post-list"),
	    @Result(name="input",location = "post-add.jsp")
})
public class PostInfoAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private PostInfoService postInfoService;
	
	private String postNo;
	private String postTitle;
	private Double postRates;
	private Double postMaxMoney;

	
	/**
	 * @功能 新增管理员
	 */
	public String execute() throws Exception {
		
		PostInfo o = new PostInfo();
		
		o.setPostNo(postNo);
		o.setPostTitle(postTitle);
		o.setPostRates(postRates);
		o.setPostMoney(0d);
		o.setPostMaxMoney(postMaxMoney);
		postInfoService.save(o);
		return SUCCESS;
		

	}
	
	/**
	 * @功能 
	 */
	public void validate() {
		
	 
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Double getPostRates() {
		return postRates;
	}

	public void setPostRates(Double postRates) {
		this.postRates = postRates;
	}

	public Double getPostMaxMoney() {
		return postMaxMoney;
	}

	public void setPostMaxMoney(Double postMaxMoney) {
		this.postMaxMoney = postMaxMoney;
	}

	
	
	 
	
	
}
