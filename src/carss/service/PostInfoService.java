/**
 * @功能 服务层
 */

package carss.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.dao.BaseDao;
import carss.po.PostInfo;
import carss.po.PostPushDay;

@Scope("prototype")
@Service
public class PostInfoService extends BaseService<PostInfo> {

	@Resource(name = "postInfoDao")
	private BaseDao<PostInfo> postInfoDao;

	@Override
	protected BaseDao<PostInfo> getDAO() {
		return postInfoDao;
	}

	@Resource
	private PostPushDayService postPushDayService;

	public void clearDayMoney() {

		List<PostInfo> list = postInfoDao.getList();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for (PostInfo o : list) {
			PostPushDay ppd = new PostPushDay();
			ppd.setMoneyDay(o.getPostMoney());
			ppd.setDateTitle(sdf.format(calendar.getTime()));
			ppd.setPostInfo(o);
			this.postPushDayService.save(ppd);
			// 修改当日值为领
			o.setPostMoney(0d);

			this.update(o);
		}

	}

}
