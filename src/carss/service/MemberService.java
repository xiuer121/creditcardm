/**
 * @功能 服务层
 */

package carss.service;



import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.dao.BaseDao;
import carss.dao.MemberDao;
import carss.po.Member;

@Scope("prototype")						
@Service				
public class MemberService extends BaseService<Member>{

	@Resource(name="memberDao")
	private  BaseDao<Member> memberDao;
	
	@Override
	protected BaseDao<Member> getDAO() {
		return memberDao;
	}
	
 
	
	/**
	 * @功能 根据用户名获得对象
	 */
	public Member getByLoginName(String loginName){
		return ((MemberDao)memberDao).getByLoginName(loginName);
		
	}
	

	
	

	
	
}
