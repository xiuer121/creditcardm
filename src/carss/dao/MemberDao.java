package carss.dao;





import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import carss.po.Member;








@Scope("prototype")			  
@Repository      
public class MemberDao extends BaseDao<Member>{
	
	/**
	 * @功能 根据用户名获得对象
	 */
	public Member getByLoginName(String loginName){
		Member o=null;
		String hql=" where o.loginName=?";
		List<Member> list=this.getList(hql,new Object[]{loginName});
		if(list.size()==1){
			o=list.get(0);
		}
		return o;
	}
	

	
	
}

