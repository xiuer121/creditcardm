package carss.dao;





import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import carss.po.PostInfo;








@Scope("prototype")			  
@Repository      
public class PostInfoDao extends BaseDao<PostInfo>{
  
}

