/**
 * @功能 服务层
 */

package carss.service;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carss.dao.BaseDao;
import carss.dao.DealInfoDao;
import carss.po.CardInfo;
import carss.po.DealInfo;

@Scope("prototype")						
@Service				
public class CardInfoService extends BaseService<CardInfo>{

	@Resource(name="cardInfoDao")
	private  BaseDao<CardInfo> cardInfoDao;
	
	@Override
	protected BaseDao<CardInfo> getDAO() {
		return cardInfoDao;
	}
	@Autowired
	private DealInfoDao dealInfoDao;
	
	public void updateMoneyWithDeal(CardInfo one){ 
		 update(one); 
		 String where =" where o.cardInfo.id  = ? ";
		 List<DealInfo> list =dealInfoDao.getList(where, new Object[]{one.getId()});
		 if(list.size()>0){
			 DealInfo dealInfo = list.get(0); 
			 dealInfo.setMoney(one.getMoney()*one.getRates()*one.getAdmin().getPoint());
			 if(dealInfo.getPostMoney()>0){
				 dealInfo.setPostMoney(one.getMoney());
			 }
			 dealInfoDao.update(dealInfo);
		 }
	
		
	}
 
	

	
	
}
