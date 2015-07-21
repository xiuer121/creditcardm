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
import carss.po.BankCardInfo;
import carss.po.BankRepaymentDay;

@Scope("prototype")
@Service
public class BankCardInfoService extends BaseService<BankCardInfo> {

	@Resource(name = "bankCardInfoDao")
	private BaseDao<BankCardInfo> bankCardInfoDao;

	@Override
	protected BaseDao<BankCardInfo> getDAO() {
		return bankCardInfoDao;
	}

	@Resource
	private BankRepaymentDayService BankRepaymentDayService;

	public void clearDayMoney() {
		List<BankCardInfo> list = bankCardInfoDao.getList();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for (BankCardInfo o : list) {
			BankRepaymentDay bpd = new BankRepaymentDay();
			bpd.setMoneyDay(o.getBankMoney());
			bpd.setDateTitle(sdf.format(calendar.getTime()));
			bpd.setBankInfo(o);
			BankRepaymentDayService.save(bpd);
			// 修改当日值为领
			o.setBankMoney(0d);
			this.update(o);
		}

	}

}
