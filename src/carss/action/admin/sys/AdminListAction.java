/**
 * @功能 
 */

package carss.action.admin.sys;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.auth.Admin;
import carss.service.perm.AdminService;
import carss.vo.View;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Results({ @Result(location = "admin-list.jsp"),
		@Result(name = "uJson", location = "admin_tree.jsp") })
public class AdminListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private AdminService adminService;

	private Integer id;
	private Integer[] ids;

	private View<Admin> view = new View<Admin>();

	private String json;
	private String is = "";

	private Integer type;

	/**
	 * @功能
	 */
	public String execute() {

		String where = " ";

		view = adminService.getView(where, view, null);

		return SUCCESS;
	}

	public String getUson() {
		List<Admin> adminList = adminService.getList();
		json = "[";
		for (Admin u : adminList) {
			json = json + "{id:'" + u.getId() + "',pId:0, name:'"
					+ u.getPersonName() + "'},";
		}
		json = json.substring(0, json.length() - 1) + "]";

		for (Integer id : ids) {
			is = is + id + ",";
		}

		return "uJson";
	}

	/**
	 * @功能
	 */
	public String remove() throws Exception {

		Admin one = adminService.get(id);
		adminService.delete(one);

		return this.execute();
	}

	/**
	 * @功能
	 */
	public String removeAll() throws Exception {

		if (ids != null) {
			for (Integer tempId : ids) {
				Admin one = adminService.get(tempId);
				adminService.delete(one);
			}
		}

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

	public View<Admin> getView() {
		return view;
	}

	public void setView(View<Admin> view) {
		this.view = view;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getIs() {
		return is;
	}

	public void setIs(String is) {
		this.is = is;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
