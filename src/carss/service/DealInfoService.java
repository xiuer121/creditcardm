/**
 * @功能 服务层
 */

package carss.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.constant.DealInfoConstant;
import carss.dao.BaseDao;
import carss.po.DealInfo;
import carss.po.auth.Admin;
import carss.service.perm.AdminService;

@Scope("prototype")
@Service
public class DealInfoService extends BaseService<DealInfo> {

	@Resource(name = "dealInfoDao")
	private BaseDao<DealInfo> dealInfoDao;

	@Override
	protected BaseDao<DealInfo> getDAO() {
		return dealInfoDao;
	}

	@Resource
	private AdminService adminService;

	public void updateMoneyForAdmin(DealInfo one) {
		Double money = one.getMoney();
		Admin admin = one.getAdminInfo();
		money = money + admin.getMoney();
		admin.setMoney(money);
		adminService.update(admin); 
		one.setCheckState(DealInfoConstant.DEAL_CHECK_YES);
		dealInfoDao.update(one);
	}

}
