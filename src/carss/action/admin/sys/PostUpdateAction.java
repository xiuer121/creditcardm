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
@Results({ @Result(type = "redirectAction", location = "post-list"),
		@Result(name = "input", location = "post-update.jsp") })
public class PostUpdateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private PostInfoService postInfoService;

	private String postNo;
	private String postTitle;
	private Double postRates;

	private Integer id;

	/**
	 * @功能 新增管理员
	 */
	public String execute() throws Exception {

		PostInfo o = postInfoService.get(id);
		o.setPostNo(postNo);
		o.setPostTitle(postTitle);
		o.setPostRates(postRates); 
		postInfoService.update(o);
		return SUCCESS;

	}

	public String show() throws Exception {
		PostInfo o = postInfoService.get(id);
		postNo = o.getPostNo();
		postTitle = o.getPostTitle();
		postRates = o.getPostRates();
	 
		return INPUT;
	}

	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	

}
