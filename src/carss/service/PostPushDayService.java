/**
 * @功能 服务层
 */

package carss.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.dao.BaseDao;
import carss.po.PostPushDay;

@Scope("prototype")
@Service
public class PostPushDayService extends BaseService<PostPushDay> {

	@Resource(name = "postPushDayDao")
	private BaseDao<PostPushDay> postPushDayDao;

	@Override
	protected BaseDao<PostPushDay> getDAO() {

		return postPushDayDao;
	}

	 

}
