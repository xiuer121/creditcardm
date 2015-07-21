package carss.dao;





import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import carss.po.CardInfo;








@Scope("prototype")			  
@Repository      
public class CardInfoDao extends BaseDao<CardInfo>{
  
}

