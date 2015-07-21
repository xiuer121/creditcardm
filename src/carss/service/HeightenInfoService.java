/**
 * @功能 服务层
 */

package carss.service;



import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.dao.BaseDao;
import carss.po.HeightenInfo;

@Scope("prototype")						
@Service				
public class HeightenInfoService extends BaseService<HeightenInfo>{

	@Resource(name="heightenInfoDao")
	private  BaseDao<HeightenInfo> heightenInfoDao;
	
	@Override
	protected BaseDao<HeightenInfo> getDAO() {
		return heightenInfoDao;
	}
	
 
	

	
	
}
