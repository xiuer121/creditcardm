/**
 * @功能 服务层
 */

package carss.service;



import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.dao.BaseDao;
import carss.po.CreditRecords;

@Scope("prototype")						
@Service				
public class CreditRecordsService extends BaseService<CreditRecords>{

	@Resource(name="creditRecordsDao")
	private  BaseDao<CreditRecords> creditRecordsDao;
	
	@Override
	protected BaseDao<CreditRecords> getDAO() {
		return creditRecordsDao;
	}
	
 
	

	
	
}
