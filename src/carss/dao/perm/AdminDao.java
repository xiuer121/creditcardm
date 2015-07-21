package carss.dao.perm;





import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import carss.dao.BaseDao;
import carss.po.auth.Admin;








@Scope("prototype")			  
@Repository      
public class AdminDao extends BaseDao<Admin>{
	
	/**
	 * @功能 根据用户名获得对象
	 */
	public Admin getByLoginName(String loginName){
		Admin o=null;
		String hql=" where o.loginName=?";
		List<Admin> list=this.getList(hql,new Object[]{loginName});
		if(list.size()==1){
			o=list.get(0);
		}
		return o;
	}
	

	
}

