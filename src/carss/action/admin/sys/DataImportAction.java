/**
 * @���� 
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
	
	private Integer cardType;							//������������� 10����20����30���
	
	private File file; // �ļ�����
	private String fileFileName; // �ļ�����
	private String fileContentType; // �ļ�����
	private String ext; // ��׺��
	/**
	 * @���� ��������Ա
	 */
	public String execute() throws Exception {
 
		FileInputStream in = new FileInputStream(file);
		String sheetName="Sheet1";
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("����", "personName");
		fieldMap.put("����", "cardNo");
		fieldMap.put("���֤��", "idNo");
		fieldMap.put("�ֻ�", "phone");
		fieldMap.put("�绰", "tel");
		fieldMap.put("��ͥסַ", "address"); 
		fieldMap.put("��ס��ַ", "liveAddress"); 
		fieldMap.put("��������ϵ�绰", "thirdContact"); 
		fieldMap.put("���", "credits"); 
		fieldMap.put("���", "balance"); 
		fieldMap.put("�������", "alsoPayMoney"); 
		fieldMap.put("ȫ������", "allPoint"); 
		fieldMap.put("��˾����", "companyPoint"); 
		fieldMap.put("Ա������", "staffPoint");
		fieldMap.put("��������", "cardBank");  
		
		List<CardInfo> list=ExcelUtil.excelToList(in, sheetName, CardInfo.class, fieldMap, new String[]{"����"});
		for(CardInfo o :list){ 
			o.setCardType(cardType);
//			o.setCardStates(10);
			cardInfoService.save(o);
		}
	 
		return SUCCESS;

	}
	
	/**
	 * @���� 
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
