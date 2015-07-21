/**
 * @功能 未激活會員
 */

package carss.action.admin.member;




import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.Member;
import carss.service.MemberService;
import carss.vo.View;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")							
@Results( { 
	    @Result(location = "person-active-no.jsp")
})
public class PersonActiveNoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource 
	private MemberService memberService;
	
	private View<Member> view=new View<Member>();

	private Integer id;


	/**
	 * @功能 获得未激活會員列表
	 */
	public String execute(){
		
		//组装where查詢语句
		String where=" where o.accountActive=false order by o.registerDate desc";
		
		view=memberService.getView(where,view, null);
		
		return SUCCESS;
	}
 
	
//	/**
//	 * @功能 导出
//	 */
//	public String out() throws Exception{
//		
//		//组装where查詢语句
//		String where=" where o.accountActive=false ";
//		
//		List<Member> list=memberService.getList(where, null);
//		
//		String realPath = ServletActionContext.getServletContext().getRealPath("model/noActive.xls");
//
//		// 读取EXCEL文件
//		FileInputStream fileIn=new FileInputStream(realPath);
//		POIFSFileSystem fs=new POIFSFileSystem(fileIn);
//
//		HSSFWorkbook wb=new HSSFWorkbook(fs);
//		HSSFSheet sheet=wb.getSheetAt(0);
//		
//		int num=1;
//		
////		for(Member p:list){
////			HSSFRow row=sheet.createRow(num);
////			
////			//投资商编号
////			HSSFCell loginName=row.createCell((short)0);
////			loginName.setCellValue(p.getLoginName());
////			
////			//姓名
////			HSSFCell personName=row.createCell((short)1);
////			personName.setCellValue(p.getPersonName());
////			
////			//推荐人
////			HSSFCell recommend=row.createCell((short)2);
////			recommend.setCellValue(p.getRecommend().getLoginName());
////			
////			//接点人
////			HSSFCell father=row.createCell((short)3);
////			father.setCellValue(p.getFather().getLoginName());
////			
////			//手机号码
////			HSSFCell tel=row.createCell((short)4);
////			tel.setCellValue(p.getTel());
////			
////			//所属商务中心
////			HSSFCell baodan=row.createCell((short)5);
////			baodan.setCellValue(p.getBaodan().getLoginName());
////
////			//注册时间
////			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////			HSSFCell registerDate=row.createCell((short)7);
////			registerDate.setCellValue(dateFormat.format(p.getRegisterDate()));
////			
////			
////			
////			num++;
////
////		}
//
//
//
//		/***************************  文件下载  **************************************/
//		//下载时显示的名称
//		String fileName = "未认证投资商";
//	
//		// 设置文件下载
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setContentType("application/vnd.ms-excel");
//		response.addHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes(), "iso8859-1") + ".xls");
//	
//		// 定义输出流
//		ServletOutputStream out= response.getOutputStream();
//		try {
//			wb.write(out);
//			out.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//			throw new Exception("文件输出出错！");
//		} finally {
//			fileIn.close();
//			fileIn=null;
//				
//			out.close();
//			out = null;
//		}
//		
//
//		return null;
//
//	}


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
	
}
