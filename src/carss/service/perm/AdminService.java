/**
 * @功能 管理员的服务层
 */

package carss.service.perm;




import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.dao.BaseDao;
import carss.dao.perm.AdminDao;
import carss.po.BankCardInfo;
import carss.po.BankRepaymentDay;
import carss.po.auth.Admin;
import carss.service.BankCardInfoService;
import carss.service.BankRepaymentDayService;
import carss.service.BaseService;







@Scope("prototype")						
@Service				
public class AdminService extends BaseService<Admin>{

	@Resource(name="adminDao")
	private  BaseDao<Admin> adminDao;
	
	@Override
	protected BaseDao<Admin> getDAO() {
		return adminDao;
	}
 
	/**
	 * @功能 根据用户名获得对象
	 */
	public Admin getByLoginName(String loginName){
		return ((AdminDao)adminDao).getByLoginName(loginName);
		
	}



 
	
	

}
