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
import carss.vo.View;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(location = "post-list.jsp") })
public class PostListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private PostInfoService postInfoService;

	private Integer id;
	private Integer[] ids;

	private View<PostInfo> view = new View<PostInfo>();

	/**
	 * @功能
	 */
	public String execute() {

		String where = " ";

		view = postInfoService.getView(where, view, null);

		return SUCCESS;
	}

	/**
	 * @功能
	 */
	public String remove() throws Exception {

		// Admin one=postInfoService.get(id);
		// adminService.delete(one);
		//
		return this.execute();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public View<PostInfo> getView() {
		return view;
	}

	public void setView(View<PostInfo> view) {
		this.view = view;
	}

}
