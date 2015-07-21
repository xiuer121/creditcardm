package carss.action.admin.fx;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.util.JdbcConn;

import com.creditcard.tool.chart.Category;
import com.creditcard.tool.chart.CategoryObject;
import com.creditcard.tool.chart.Chart;
import com.creditcard.tool.chart.LineChartsObject;
import com.creditcard.tool.chart.LineDataObject;
import com.creditcard.tool.chart.LineDatasetObject;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(type = "json") })
public class CompanyHuanLineMonthAjaxAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String start;
	private String end;

	private LineChartsObject chartsObject = new LineChartsObject();

	@Override
	public String execute() throws Exception {

		// 图标数据
		List<LineDatasetObject> dataset = new ArrayList<LineDatasetObject>();
		List<Category> ctegorylist = null;
		List<CategoryObject> categories = new ArrayList<CategoryObject>();

		// ------------------声明X数据
		CategoryObject categoryObj = new CategoryObject();
		JdbcConn jdbcConn = new JdbcConn();
		String where = "";

		ctegorylist = new ArrayList<Category>();
		where = " where 1 = 1 and substr(date_title,1,4) = ?  ";

		String sql = "select substr(date_title,1,6) as date_title,SUM(money_day)as money from "
				+ "  #TABLE  a  "
				+ where
				+ " group by substr(date_title,1,6) order by "
				+ "substr(date_title,1,6) desc";

		List<Object> pare = new ArrayList<Object>();
		pare.add(start); 
		String sqlHuanKa = sql.replace("#TABLE", " bank_repayment_day ");
		LineDatasetObject datasetObject = new LineDatasetObject();
		datasetObject.setSeriesname("还 卡走势");
		List<LineDataObject> datas = new ArrayList<LineDataObject>();
		ResultSet rs = jdbcConn.query(sqlHuanKa, pare.toArray());

		while (rs.next()) {
			// 设置图表插件的数据
			Category category = new Category();
			category.setLabel(rs.getString("date_title"));
			LineDataObject dataObject = new LineDataObject();
			dataObject.setValue(rs.getString("money"));
			datas.add(dataObject);
			ctegorylist.add(category);
		}
		datasetObject.setData(datas);
		dataset.add(datasetObject);

		// 生成第二条线
		ctegorylist = new ArrayList<Category>();
		datasetObject = new LineDatasetObject();
		datasetObject.setSeriesname("刷卡走势");
		datas = new ArrayList<LineDataObject>();
		String sqlPostKa = sql.replace("#TABLE", " post_push_day ");
		rs = jdbcConn.query(sqlPostKa, pare.toArray());
		while (rs.next()) {
			// 设置图表插件的数据
			Category category = new Category();
			category.setLabel(rs.getString("date_title"));
			LineDataObject dataObject = new LineDataObject();
			dataObject.setValue(rs.getString("money"));
			datas.add(dataObject);
			ctegorylist.add(category);
		}
		datasetObject.setData(datas);
		dataset.add(datasetObject);

		categories.add(categoryObj);
		categoryObj.setCategory(ctegorylist);

		Chart chart = new Chart();
		chart.setCaption("走势图");
		chart.setShowpercentvalues("1");
		chart.setFormatNumberScale("0");
		chart.setXAxisName("日期");
		chart.setYAxisName("金额");
		chart.setDecimalPrecision("2");
		chartsObject.setChart(chart);
		chartsObject.setCategories(categories);
		chartsObject.setDataset(dataset);

	 
		jdbcConn.closeAll();
		return SUCCESS;

	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public LineChartsObject getChartsObject() {
		return chartsObject;
	}

	public void setChartsObject(LineChartsObject chartsObject) {
		this.chartsObject = chartsObject;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
