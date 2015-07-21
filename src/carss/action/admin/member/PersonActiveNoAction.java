/**
 * @���� δ������T
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
	 * @���� ���δ������T�б�
	 */
	public String execute(){
		
		//��װwhere��ԃ���
		String where=" where o.accountActive=false order by o.registerDate desc";
		
		view=memberService.getView(where,view, null);
		
		return SUCCESS;
	}
 
	
//	/**
//	 * @���� ����
//	 */
//	public String out() throws Exception{
//		
//		//��װwhere��ԃ���
//		String where=" where o.accountActive=false ";
//		
//		List<Member> list=memberService.getList(where, null);
//		
//		String realPath = ServletActionContext.getServletContext().getRealPath("model/noActive.xls");
//
//		// ��ȡEXCEL�ļ�
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
////			//Ͷ���̱��
////			HSSFCell loginName=row.createCell((short)0);
////			loginName.setCellValue(p.getLoginName());
////			
////			//����
////			HSSFCell personName=row.createCell((short)1);
////			personName.setCellValue(p.getPersonName());
////			
////			//�Ƽ���
////			HSSFCell recommend=row.createCell((short)2);
////			recommend.setCellValue(p.getRecommend().getLoginName());
////			
////			//�ӵ���
////			HSSFCell father=row.createCell((short)3);
////			father.setCellValue(p.getFather().getLoginName());
////			
////			//�ֻ�����
////			HSSFCell tel=row.createCell((short)4);
////			tel.setCellValue(p.getTel());
////			
////			//������������
////			HSSFCell baodan=row.createCell((short)5);
////			baodan.setCellValue(p.getBaodan().getLoginName());
////
////			//ע��ʱ��
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
//		/***************************  �ļ�����  **************************************/
//		//����ʱ��ʾ������
//		String fileName = "δ��֤Ͷ����";
//	
//		// �����ļ�����
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setContentType("application/vnd.ms-excel");
//		response.addHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes(), "iso8859-1") + ".xls");
//	
//		// ���������
//		ServletOutputStream out= response.getOutputStream();
//		try {
//			wb.write(out);
//			out.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//			throw new Exception("�ļ��������");
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
