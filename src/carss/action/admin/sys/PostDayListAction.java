/**
 * @功能 
 */

package carss.action.admin.sys;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.PostPushDay;
import carss.service.PostPushDayService;
import carss.vo.View;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(location = "post-day-list.jsp") })
public class PostDayListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private PostPushDayService postPushDayService;

	private View<PostPushDay> view = new View<PostPushDay>();

	/**
	 * @功能
	 */
	public String execute() {

		String where = " where 1 = 1 order by o.dateTitle desc";

		view = postPushDayService.getView(where, view, null);
		return SUCCESS;
	}

	public View<PostPushDay> getView() {
		return view;
	}

	public void setView(View<PostPushDay> view) {
		this.view = view;
	}

}
