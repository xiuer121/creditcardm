/**
 * @功能 服务层
 */

package carss.service;



import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.dao.BaseDao;
import carss.po.BankRepaymentDay;

@Scope("prototype")						
@Service				
public class BankRepaymentDayService extends BaseService<BankRepaymentDay>{

	@Resource(name="bankRepaymentDayDao")
	private  BaseDao<BankRepaymentDay> bankRepaymentDayDao;
	
	@Override
	protected BaseDao<BankRepaymentDay> getDAO() {
		return bankRepaymentDayDao;
	}
	
 
	

	
	
}
