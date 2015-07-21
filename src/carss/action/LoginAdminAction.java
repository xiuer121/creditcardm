/**
 * @���� ����Ա��¼
 */

package carss.action;




import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import carss.po.auth.Admin;
import carss.service.perm.AdminService;
import carss.vo.LoginAdmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

 
 
@Controller
@Scope("prototype")	
@Results( {  
	 //@Result(location = "login-val.jsp"),
	 @Result(type="redirectAction",location = "admin/application-admin"),
	 @Result(name = "input",location = "login-admin.jsp")
})
public class LoginAdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private AdminService adminService;
	
 
 

	private String loginName; 				//��¼��
	private String password; 				//��ѯ����
	private String validate;				//��֤��
	
	private Admin one=null;						//����Ա�ĵ�¼��Ϣ


	/**
	 * @���� ��¼�¼�
	 */
	public String login() {
		
		if(one.getLoginNum()==null){
			one.setLoginNum(1);
		}else{
			one.setLoginNum(one.getLoginNum()+1);
		}
		
		
		one.setLastTime(one.getLoginTime());
		one.setLoginTime(new Date());
	
		
		//���ӂ�����Ϣ
		LoginAdmin loginAdmin=new LoginAdmin(one);
		
		//�ѵ�䛵�½���� ���浽SESSION��������
		ActionContext.getContext().getSession().put("loginAdmin", loginAdmin);
	
		 
		adminService.update(one);
	 
	//	systemService.ValToEmail1(C,su,one.getEmail());
		
		
		return SUCCESS;

	}
	
	

	/**
	 * @���� У��
	 */
	public void validateLogin() {
		
//		//��֤���Ƿ���ȷ
//		if(ActionContext.getContext().getSession().get("validate")==null){
//			this.addFieldError("validate","��¼ʧЧ,�����µ�¼��");
//			return;
//		}
//		String validateSession=ActionContext.getContext().getSession().get("validate").toString();
//		if(!validate.equals(validateSession)){
//			this.addFieldError("validate","��֤�벻��ȷ��");
//		}

		if(this.loginName!=null){
			one=adminService.getByLoginName(this.loginName.toLowerCase());
			//�жϵ�¼���Ƿ����
			if(one==null){
				this.addFieldError("loginName","��¼��������");
				
			}else{
				/********************  ����һ��ͨ������  ***********************/
			 
				//�ж������Ƿ���ȷ
				if(one.getPassword().equals(this.password)){
					
					//��¼�˻��Ƿ�ע��
					if(!one.getAccountUse()){
						this.addFieldError("loginName","���˻���ע����");
					}

				}else{
					
					this.addFieldError("password","��¼���벻��ȷ��");
					
					//���������Ӵ�����Ϣ
					one.setErrorNum(one.getErrorNum()+1);
					one.setErrorDate(new Date());
					this.adminService.update(one);
					
				}

			}
		}else{
			this.addFieldError("loginName","�û���δ��д��");
		}
		
		
		
		/*********************  ������־    ********************************/
 
		
		
////		//һ�����루��¼���룩����������Σ�����������Сʱ
//		if(!this.hasErrors()){
//			if(one.getErrorNum()>=3){
//				
//				Integer mm=(int)((new Date().getTime()-one.getErrorDate().getTime())/(1000*60));	//���������
//				if(mm<=10){
//					this.addActionError("�������������������ϣ��ʺű���������ȴ�"+(10-mm)+"���Ӻ��ٴε�¼��");
//				}else{
//					one.setErrorNum(0);			//��մ������
//					this.adminService.update(one);
//				}
//				
//			}
//		}
//		
		
		
	}
	
	


	@RequiredStringValidator(message = "�������û���!")
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@RequiredStringValidator(message = "����������!")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}

}
