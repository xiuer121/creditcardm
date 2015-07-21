/**
 * @功能 
 */

package carss.action.admin.sys;



import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.CardInfo;
import carss.service.CardInfoService;
import carss.util.ExcelUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")							
@Results( { 
	    @Result(type="redirectAction",location = "../repayment/repayment-list")

})
public class DataImportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private CardInfoService cardInfoService;
	
	private Integer cardType;							//导入的数据类型 10代还20精养30提额
	
	private File file; // 文件对象
	private String fileFileName; // 文件名称
	private String fileContentType; // 文件类型
	private String ext; // 后缀名
	/**
	 * @功能 新增管理员
	 */
	public String execute() throws Exception {
 
		FileInputStream in = new FileInputStream(file);
		String sheetName="Sheet1";
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("姓名", "personName");
		fieldMap.put("卡号", "cardNo");
		fieldMap.put("身份证号", "idNo");
		fieldMap.put("手机", "phone");
		fieldMap.put("电话", "tel");
		fieldMap.put("家庭住址", "address"); 
		fieldMap.put("居住地址", "liveAddress"); 
		fieldMap.put("第三方联系电话", "thirdContact"); 
		fieldMap.put("额度", "credits"); 
		fieldMap.put("余额", "balance"); 
		fieldMap.put("代还金额", "alsoPayMoney"); 
		fieldMap.put("全部返点", "allPoint"); 
		fieldMap.put("公司返点", "companyPoint"); 
		fieldMap.put("员工返点", "staffPoint");
		fieldMap.put("所属银行", "cardBank");  
		
		List<CardInfo> list=ExcelUtil.excelToList(in, sheetName, CardInfo.class, fieldMap, new String[]{"卡号"});
		for(CardInfo o :list){ 
			o.setCardType(cardType);
//			o.setCardStates(10);
			cardInfoService.save(o);
		}
	 
		return SUCCESS;

	}
	
	/**
	 * @功能 
	 */
	public void validate() {
 
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	
	
	 
	
}
